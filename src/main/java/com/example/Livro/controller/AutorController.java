package com.example.Livro.controller;

import com.example.Livro.entity.Autor;
import com.example.Livro.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
        Autor autorSalvo = autorService.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        return ResponseEntity.ok(autorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        if (autorService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        autorService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}