package com.experis.cdrinsight.controllers;

import com.experis.cdrinsight.entities.UsageType;
import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.logic.CdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/cdr")
public class CdrApi {

    @Autowired
    CdrService cdrService;

//    @GetMapping("/all")
//    public List<Cdr> getAllCdr(){
//        return repository.findAll();
//    }

    @PostMapping
    public void pushCdr(){
        Cdr cdr = new Cdr(
                "0",
                "425034077146989",
                "13-93732-0050646",
                UsageType.MOC,
                "9720337418673",
                new Date(),
                1171,
                0,
                0,
                "425034784099853",
                "9720508356329");

        cdrService.insertCdr(cdr);
    }
}
