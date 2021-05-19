package com.training.experis;

import com.training.experis.logic.DbService;
import com.training.experis.logic.SqlHandler;
import com.training.experis.ui.Application;

public class Main {

    public static void main(String[] args) {
        Application ui = new Application(new DbService(new SqlHandler()));
        ui.run();
    }
}
