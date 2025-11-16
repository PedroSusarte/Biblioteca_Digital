package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "alugueis")
public class Aluguel {

    @Id
    @Column(name = "id_aluguel")
    private String idAluguel;

    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "id_livro")
    private String idLivro;

    @Column(name = "data_aluguel")
    private LocalDate dataAluguel;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    private String status;
}
