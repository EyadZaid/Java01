package com.experis.cdrinsight.services;

import com.experis.cdrinsight.entities.DataCdr;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataCdrRepository extends MongoRepository<DataCdr, String> {
}
