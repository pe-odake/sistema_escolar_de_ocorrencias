package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

import java.util.Date;

public class Aluno {
    private Long id;
    private String nome;
    private Date data_nascimento;

    public Aluno(
            Long id,
            String nome,
            Date data_nascimento
    ) {
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

    public Date getData_nascimento() {
        return data_nascimento;
    }
}
