package com.example.Livro.service;

import com.example.Livro.entity.Projeto;
import com.example.Livro.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> buscarPorId(Long id) {
        return projetoRepository.findById(id);
    }

    public boolean existePorId(Long id) {
        return projetoRepository.existsById(id);
    }

    public void deletarPorId(Long id) {
        projetoRepository.deleteById(id);
    }
}
