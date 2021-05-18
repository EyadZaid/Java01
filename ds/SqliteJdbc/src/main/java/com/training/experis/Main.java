package com.training.experis;

import com.training.experis.logic.DbService;
import com.training.experis.logic.SqlHandler;
import com.training.experis.ui.UserInterface;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new DbService(new SqlHandler()));
        ui.run();
    }
}
