package com.example.Livro.service;

import com.example.Livro.entity.Fornecedor;
import com.example.Livro.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public boolean existePorId(Long id) {
        return fornecedorRepository.existsById(id);
    }

    public void deletarPorId(Long id) {
        fornecedorRepository.deleteById(id);
    }
}