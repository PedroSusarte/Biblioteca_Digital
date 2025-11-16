package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @Column(name = "id_livro")
    private String idLivro;

    private String titulo;
    private String autor;

    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    private Boolean disponivel;
}
