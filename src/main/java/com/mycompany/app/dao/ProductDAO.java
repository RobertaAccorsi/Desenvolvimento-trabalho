package com.mycompany.app.dao;

import com.mycompany.app.model.Product;

import java.sql.Connection;
import java.util.List;

public class ProductDAO extends GenericDAOImpl<Product> implements GenericDAO<Product> {
    private final String id = "Product";
    private final List<String> COLUMNS = List.of("description");

    public ProductDAO(Connection connection) {
        super(Product::new, connection);
        super.tableName = id;
        super.columns = COLUMNS;
    }


}
