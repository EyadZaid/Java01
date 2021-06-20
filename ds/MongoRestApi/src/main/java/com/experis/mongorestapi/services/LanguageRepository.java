package com.experis.mongorestapi.services;

import com.experis.mongorestapi.entities.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LanguageRepository extends MongoRepository<Language, String> {
    List<Language> findByName(String name);

    List<Language> findByYearAfter(int year);

}
