package com.example.Livro.controller;

import com.example.Livro.entity.Departamento;
import com.example.Livro.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<Departamento> criar(@RequestBody Departamento departamento) {
        Departamento salvo = departamentoService.salvar(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listar() {
        return ResponseEntity.ok(departamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
        return departamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!departamentoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        departamentoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}