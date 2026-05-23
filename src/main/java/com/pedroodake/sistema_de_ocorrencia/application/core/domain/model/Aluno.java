package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

import java.time.LocalDate;

public class Aluno {
    private Long id;
    private String nome;
    private LocalDate data_nascimento;
    private boolean ativo = true;

    public Aluno(
            Long id,
            String nome,
            LocalDate data_nascimento,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(
            String nome,
            LocalDate data_nascimento) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
        if (data_nascimento != null ) {
            this.data_nascimento = data_nascimento;
        }
    }

}
