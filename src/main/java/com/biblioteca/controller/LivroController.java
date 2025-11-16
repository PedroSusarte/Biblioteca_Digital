package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        String sql = "SELECT gerar_id('LIV') AS novo_id";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        String novoId = (String) result.get("novo_id");

        livro.setIdLivro(novoId);
        livro.setDisponivel(true);

        return livroRepository.save(livro);
    }
}