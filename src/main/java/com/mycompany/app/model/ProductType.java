package com.mycompany.app.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductType implements Entity {

    private int id;
    private String description;

    public ProductType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public ProductType() {

    }
    public ProductType(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.description = resultSet.getString("description");

    }

    public int getId() {
        return id;
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, getDescription());
        return preparedStatement;

    }

    public String getDescription() {
        return description;
    }

    @Override
    public Object constructFromResultSet(ResultSet rs) throws SQLException {
        return new ProductType(rs);
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}