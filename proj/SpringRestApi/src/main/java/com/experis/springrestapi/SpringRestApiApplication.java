package com.experis.springrestapi;

import com.experis.springrestapi.logic.DbService;
import com.experis.springrestapi.logic.SqlHandler;
import com.experis.springrestapi.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
//        Application ui = new Application(new DbService(new SqlHandler()));
//        ui.run();
    }

}
