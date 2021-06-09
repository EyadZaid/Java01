package com.experis.springrestapi;

import com.experis.springrestapi.logic.DbService;
import com.experis.springrestapi.logic.IDbService;
import com.experis.springrestapi.logic.SqlHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
    }

}
