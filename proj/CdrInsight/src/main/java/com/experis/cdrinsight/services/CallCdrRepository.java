package com.experis.cdrinsight.services;

import com.experis.cdrinsight.entities.CallCdr;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CallCdrRepository extends MongoRepository<CallCdr, String> {

}
