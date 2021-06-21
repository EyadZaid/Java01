package com.experis.cdrinsight.services;

import com.experis.cdrinsight.entities.Cdr;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CdrRepository extends MongoRepository<Cdr, String> {

}
