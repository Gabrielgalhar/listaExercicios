package com.example.Livro.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name = "Projeto")
@Table(name = "tb_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_projeto")
    private String nome;

    @Column(name = "dt_inicio")
    private LocalDate dataInicio;

    @Column(name = "dt_fim")
    private LocalDate dataFim;

    public Projeto() {
    }

    public Projeto(Long id, String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}