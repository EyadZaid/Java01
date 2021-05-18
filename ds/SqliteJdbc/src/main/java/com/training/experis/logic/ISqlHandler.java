package com.training.experis.logic;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISqlHandler {
    Connection connect() throws SQLException;
}
