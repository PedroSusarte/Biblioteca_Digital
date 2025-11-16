package com.biblioteca.service;

import com.biblioteca.mongo.model.LogAluguel;
import com.biblioteca.mongo.repository.LogAluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogAluguelService {

    @Autowired
    private LogAluguelRepository logAluguelRepository;

    public void registrarAluguel(String idLivro, String usuario) {

        LogAluguel log = new LogAluguel();
        log.setIdLivro(idLivro);
        log.setUsuario(usuario);
        log.setData(LocalDateTime.now());

        logAluguelRepository.save(log);
    }
}
