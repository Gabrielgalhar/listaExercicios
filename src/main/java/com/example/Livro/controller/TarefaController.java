package com.example.Livro.service;

import com.example.Livro.entity.Tarefa;
import com.example.Livro.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodos() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public boolean existePorId(Long id) {
        return tarefaRepository.existsById(id);
    }

    // 🔥 AQUI ESTÁ O DELETE NO SERVICE
    public void deletarPorId(Long id) {
        tarefaRepository.deleteById(id);
    }
}