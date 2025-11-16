package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.model.Aluguel;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, String> {
    List<Aluguel> findByIdUsuario(String idUsuario);
}
