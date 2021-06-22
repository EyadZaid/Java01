package com.experis.cdrinsight.services;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CdrRepository extends MongoRepository<Cdr, String> {

}
