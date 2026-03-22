package com.example.Livro.controller;

import com.example.Livro.entity.Projeto;
import com.example.Livro.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody Projeto projeto) {
        Projeto salvo = projetoService.salvar(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listar() {
        return ResponseEntity.ok(projetoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
        return projetoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!projetoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        projetoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}