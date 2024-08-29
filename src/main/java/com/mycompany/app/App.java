package com.mycompany.app;

import com.mycompany.app.controller.HelloWorldHandler;
import com.mycompany.app.dao.ProductTypeDAO;
import com.mycompany.app.dao.SaleDAO;
import com.mycompany.app.model.ProductType;
import com.mycompany.app.model.Sale;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args ){

        try{
            HttpServer servidor = HttpServer.create(
                    new InetSocketAddress( 8080),0
            );

            servidor.createContext("/helloWorld",
                    new HelloWorldHandler());

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/your_db", "root", "root"
            );

            SaleDAO saleDAO = new SaleDAO(connection);
            Sale sale = saleDAO.getById(1);
            sale.setSaleItems(saleDAO.getSaleItemsBySaleId(1));


            ProductTypeDAO productTypeDAO = new ProductTypeDAO(connection);

            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(0, "Teste"));
            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(4, "Teste 2"));
            productTypeDAO.getAll().forEach(System.out::println);
            System.out.println(productTypeDAO.getById(1));
            productTypeDAO.deleteById(5);
            productTypeDAO.getAll().forEach(System.out::println);



            servidor.setExecutor(null);
            servidor.start();
            System.out.println("Servidor rodando na porta 8080");
        }catch( IOException e ){
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}