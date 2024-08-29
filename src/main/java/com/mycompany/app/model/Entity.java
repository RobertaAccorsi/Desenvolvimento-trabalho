package com.mycompany.app.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Entity {
    Object constructFromResultSet(ResultSet rs) throws SQLException;
    int getId ();
    PreparedStatement prepareStatement (PreparedStatement preparedStatement) throws SQLException;
}
