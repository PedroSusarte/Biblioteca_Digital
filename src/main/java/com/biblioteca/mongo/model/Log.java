package com.biblioteca.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")
public class Log {

    @Id
    private String id;

    private String acao;
    private String usuario;
    private LocalDateTime data;

    public Log(String acao, String usuario, LocalDateTime data) {
        this.acao = acao;
        this.usuario = usuario;
        this.data = data;
    }

    public Log(String acao, String usuario) {
        this.acao = acao;
        this.usuario = usuario;
        this.data = LocalDateTime.now();
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}