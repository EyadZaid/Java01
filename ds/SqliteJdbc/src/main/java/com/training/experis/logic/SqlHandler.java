package com.training.experis.logic;

import java.sql.*;

public class SqlHandler implements ISqlHandler {

    @Override
    public Connection connect() throws SQLException {
        var url = "jdbc:sqlite:";
        var dbFile = "src\\main\\resources\\chinook.db";
        Connection conn = DriverManager.getConnection(url + dbFile);
        return conn;
    }

    @Override
    public ResultSet executeQuery(String sqlPattern, String parameter) {
        try {
            var conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sqlPattern);
            stmt.setString(1, parameter);
            return stmt.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
