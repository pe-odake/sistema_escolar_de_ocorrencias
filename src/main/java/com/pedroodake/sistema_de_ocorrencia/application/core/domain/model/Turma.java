package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;

import java.time.Year;

public class Turma {
    private Long id;
    private String nome_turma;
    private Turno turno;
    private Year ano;
    private Integer semestre;

    public Turma(
            Long id,
            String nome_turma,
            Turno turno,
            Year ano,
            Integer semestre
    ) {
        this.id = id;
        this.nome_turma = nome_turma;
        this.turno = turno;
        this.ano = ano;
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public Year getAno() {
        return ano;
    }

    public String getTurno() {
        return turno;
    }

    public String getNome_turma() {
        return nome_turma;
    }

}
