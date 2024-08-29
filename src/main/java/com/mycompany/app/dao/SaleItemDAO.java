package com.mycompany.app.dao;

import com.mycompany.app.model.SaleItem;

import java.sql.Connection;
import java.util.List;

public class SaleItemDAO extends GenericDAOImpl<SaleItem> implements GenericDAO<SaleItem> {
    private final List<String> COLUMNS = List.of("saleitem");

    public SaleItemDAO(Connection connection) {
        super(SaleItem::new, connection);
        super.tableName = "saleitem";
        super.columns = COLUMNS;
    }
}
