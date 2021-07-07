package com.experis.cdrinsightclient.controllers;

import com.experis.cdrinsightclient.logic.CdrFromFileService;
import com.experis.cdrinsightclient.logic.InputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CdrApi {

    @Autowired
    private CdrFromFileService service;

    @PostMapping("/readCdrs")
    public void insertCdrs() {
        try {
            service.insertCdrsToDB("src\\main\\resources\\425_424-50.cdr", new InputParser());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
