package com.biblioteca.service;

import com.biblioteca.model.Aluguel;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.AluguelRepository;
import com.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.findAll();
    }

    public Aluguel registrarAluguel(Aluguel aluguel) {
        String idGerado = "ALU_" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        aluguel.setIdAluguel(idGerado);
        aluguel.setDataAluguel(LocalDate.now());
        aluguel.setStatus("ativo");

        Optional<Livro> livroOpt = livroRepository.findById(aluguel.getIdLivro());
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            if (!livro.getDisponivel()) {
                throw new RuntimeException("Livro indisponível para aluguel!");
            }
            livro.setDisponivel(false);
            livroRepository.save(livro);
        }

        return aluguelRepository.save(aluguel);
    }

    public Aluguel registrarDevolucao(String idAluguel) {
        Optional<Aluguel> aluguelOpt = aluguelRepository.findById(idAluguel);
        if (aluguelOpt.isPresent()) {
            Aluguel aluguel = aluguelOpt.get();
            aluguel.setDataDevolucao(LocalDate.now());
            aluguel.setStatus("devolvido");

            Optional<Livro> livroOpt = livroRepository.findById(aluguel.getIdLivro());
            livroOpt.ifPresent(livro -> {
                livro.setDisponivel(true);
                livroRepository.save(livro);
            });

            return aluguelRepository.save(aluguel);
        }
        throw new RuntimeException("Aluguel não encontrado: " + idAluguel);
    }
}
