package com.biblioteca.controller;

import com.biblioteca.model.Aluguel;
import com.biblioteca.repository.AluguelRepository;
import com.biblioteca.mongo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
@CrossOrigin(origins = "http://localhost:63342")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private LogService logService;

    @GetMapping
    public List<Aluguel> listar() {
        logService.registrar("Listou todos os alugueis", "Sistema");
        return aluguelRepository.findAll();
    }

    @PostMapping
    public Aluguel registrar(@RequestBody Aluguel aluguel) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        aluguel.setIdAluguel("ALU_" + timestamp);
        aluguel.setDataAluguel(LocalDate.now());
        aluguel.setStatus("ativo");

        Aluguel novo = aluguelRepository.save(aluguel);

        logService.registrar(
                "Registrou aluguel do livro " + aluguel.getIdLivro(),
                "Usuário ID " + aluguel.getIdUsuario()
        );

        return novo;
    }

    @PutMapping("/{id}/devolver")
    public Aluguel devolver(@PathVariable String id) {
        Aluguel aluguel = aluguelRepository.findById(id).orElseThrow();

        aluguel.setStatus("devolvido");
        aluguel.setDataDevolucao(LocalDate.now());

        Aluguel devolvido = aluguelRepository.save(aluguel);

        logService.registrar(
                "Devolveu o livro " + aluguel.getIdLivro(),
                "Usuário ID " + aluguel.getIdUsuario()
        );

        return devolvido;
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Aluguel> listarPorUsuario(@PathVariable String idUsuario) {

        logService.registrar(
                "Listou alugueis do usuário",
                "Usuário ID " + idUsuario
        );

        return aluguelRepository.findByIdUsuario(idUsuario);
    }
}