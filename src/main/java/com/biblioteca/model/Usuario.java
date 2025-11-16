package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private String idUsuario;

    private String nome;

    private String email;

    private String senha;

    @Column(name = "id_grupo")
    private String idGrupo;
}