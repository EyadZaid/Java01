package com.experis.springrestapi.services;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ISqlHandler {
    Connection getConnection();

    ResultSet executeQuery(String sqlPattern, String parameter);

    ResultSet executeQuery(String sqlPattern);
}
