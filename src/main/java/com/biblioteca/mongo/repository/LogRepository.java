package com.biblioteca.mongo.repository;

import com.biblioteca.mongo.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}