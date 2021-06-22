package com.experis.cdrinsight.services;

import com.experis.cdrinsight.entities.SmsCdr;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SmsCdrRepository extends MongoRepository<SmsCdr, String> {
}
