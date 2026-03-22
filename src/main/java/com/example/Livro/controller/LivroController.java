package com.example.Livro.controller;

import com.example.Livro.entity.Livro;
import com.example.Livro.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        livroService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}