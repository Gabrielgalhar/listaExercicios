package com.example.Livro.controller;

import com.example.Livro.entity.Fornecedor;
import com.example.Livro.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor) {
        Fornecedor salvo = fornecedorService.salvar(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listar() {
        return ResponseEntity.ok(fornecedorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!fornecedorService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        fornecedorService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}