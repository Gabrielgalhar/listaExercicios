package com.example.Livro.controller;

import com.example.Livro.entity.Projeto;
import com.example.Livro.repository.ProjetoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoRepository projetoRepository;

    public ProjetoController(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody Projeto projeto) {
        Projeto salvo = projetoRepository.save(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listar() {
        return ResponseEntity.ok(projetoRepository.findAll());
    }
}