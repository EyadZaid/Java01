package com.experis.cdrinsight.controllers;

import com.experis.cdrinsight.entities.Cdr;
import com.experis.cdrinsight.services.CdrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cdr")
public class CdrApi {
    @Autowired
    private CdrRepository repository;

    @GetMapping("/all")
    public List<Cdr> getAllCdr(){
        return repository.findAll();
    }

    @PostMapping
    public Cdr pushCdr(@RequestBody Cdr cdr){
        return repository.save(cdr);
    }
}
