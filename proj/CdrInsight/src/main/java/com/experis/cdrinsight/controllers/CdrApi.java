package com.experis.cdrinsight.controllers;

import com.experis.cdrinsight.entities.Bill;
import com.experis.cdrinsight.entities.UsageType;
import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.logic.CdrFromFileService;
import com.experis.cdrinsight.logic.CdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/cdr")
public class CdrApi {

    @Autowired
    private CdrService cdrService;


//    @Autowired
//    private CdrFromFileService fileService;


    @GetMapping("/msisdn/{msisdn}")
    public Optional<Bill> getBill(@PathVariable String msisdn){
        return cdrService.getBill(msisdn);
    }

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
