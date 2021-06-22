package com.experis.cdrinsight.services;

import com.experis.cdrinsight.entities.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
}
