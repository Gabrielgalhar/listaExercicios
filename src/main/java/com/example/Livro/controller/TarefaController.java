package com.example.Livro.controller;

import com.example.Livro.entity.Tarefa;
import com.example.Livro.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa salvo = tarefaService.salvar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}