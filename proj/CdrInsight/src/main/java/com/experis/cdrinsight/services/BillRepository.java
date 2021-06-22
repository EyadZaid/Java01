package com.experis.cdrinsight.services;

import com.experis.cdrinsight.entities.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository<Bill, String> {
}
