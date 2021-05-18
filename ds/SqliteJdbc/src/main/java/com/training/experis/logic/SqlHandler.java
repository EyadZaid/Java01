package com.training.experis.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlHandler implements ISqlHandler {

    @Override
    public Connection connect() throws SQLException {
        var url = "jdbc:sqlite:";
        var dbFile = "src\\main\\resources\\chinook.db";
        Connection conn = DriverManager.getConnection(url + dbFile);
        return conn;
    }

}
