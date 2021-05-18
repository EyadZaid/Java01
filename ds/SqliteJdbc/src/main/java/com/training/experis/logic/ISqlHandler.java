package com.training.experis.logic;

import java.sql.Connection;
import java.sql.ResultSet;

public interface ISqlHandler {
    Connection getConnection();

    ResultSet executeQuery(String sqlPattern, String parameter);
}
