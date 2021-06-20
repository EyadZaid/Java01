package com.experis.mongorestapi.controllers;

import com.experis.mongorestapi.entities.Language;
import com.experis.mongorestapi.services.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lang")
public class LanguageAPI {

    @Autowired
    private LanguageRepository repository;

    /**
     * Get all languages
     */
    @GetMapping("/all")
    public ResponseEntity<List<Language>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    /**
     * Get languages by name
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Language>> findByName(@PathVariable String name){
        return ResponseEntity.ok(repository.findByName(name));
    }

    /**
     * Get languages after year
     */
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Language>> findByYearAfter(@PathVariable int year){
        return ResponseEntity.ok(repository.findByYearAfter(year));
    }

    /**
     * Add new language
     */
    @PostMapping("/add")
    public ResponseEntity<Language> addLanguage(@RequestParam("name") String name,
                                                   @RequestParam("creator") String creator,
                                                   @RequestParam("year") int year,
                                                   @RequestParam("lastVersion") float lastVersion){
        return ResponseEntity.ok(repository.save(new Language(name, creator, year, lastVersion)));
    }

}
