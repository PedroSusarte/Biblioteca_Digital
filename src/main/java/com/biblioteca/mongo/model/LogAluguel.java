package com.biblioteca.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs_aluguel")
public class LogAluguel {

    @Id
    private String id;

    private String idLivro;
    private String usuario;
    private LocalDateTime data;

    public LogAluguel() { }

    public LogAluguel(String idLivro, String usuario, LocalDateTime data) {
        this.idLivro = idLivro;
        this.usuario = usuario;
        this.data = data;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdLivro() { return idLivro; }
    public void setIdLivro(String idLivro) { this.idLivro = idLivro; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
