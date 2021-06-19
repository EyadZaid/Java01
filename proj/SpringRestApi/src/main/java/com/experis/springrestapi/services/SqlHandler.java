package com.experis.springrestapi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@Profile("dev")
public class SqlHandler implements ISqlHandler {
    private static final String dbFile = "src\\main\\resources\\chinook.db";
    private static final String url = "jdbc:sqlite:";
    private Connection connection;

    public SqlHandler() {
        try {
            connection = DriverManager.getConnection(url + dbFile);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public ResultSet executeQuery(String sqlPattern, String parameter) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlPattern);
            stmt.setString(1, parameter);
            return stmt.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public ResultSet executeQuery(String sqlPattern) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlPattern);
            return stmt.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
