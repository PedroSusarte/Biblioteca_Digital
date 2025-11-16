package com.biblioteca.mongo.service;

import com.biblioteca.mongo.model.Log;
import com.biblioteca.mongo.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void registrar(String acao, String usuario) {

        Log log = new Log(
                acao,
                usuario,
                LocalDateTime.now()
        );

        logRepository.save(log);
    }
}
