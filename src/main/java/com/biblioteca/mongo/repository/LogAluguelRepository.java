package com.biblioteca.mongo.repository;

import com.biblioteca.mongo.model.LogAluguel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogAluguelRepository extends MongoRepository<LogAluguel, String> {
}
