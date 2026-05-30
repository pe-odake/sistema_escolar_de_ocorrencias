package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;

import java.time.Instant;

public class Ocorrencia {
    private Long id;
    private Usuario usuario;
    private Turma turma;
    private Aluno aluno;
    private Instant registrada_em;
    private Categoria_Ocorrencia categoriaOcorrencia;
    private Tipo_Ocorrencia tipoOcorrencia;
    private String descricao;

    public Ocorrencia(
            Long id,
            Usuario usuario,
            Turma turma,
            Aluno aluno,
            Instant registrada_em,
            Categoria_Ocorrencia categoriaOcorrencia,
            Tipo_Ocorrencia tipoOcorrencia,
            String descricao) {
        this.id = id;
        this.usuario = usuario;
        this.turma = turma;
        this.aluno = aluno;
        this.registrada_em = registrada_em;
        this.categoriaOcorrencia = categoriaOcorrencia;
        this.tipoOcorrencia = tipoOcorrencia;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Turma getTurma() {
        return turma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Instant getRegistrada_em() {
        return registrada_em;
    }

    public Categoria_Ocorrencia getCategoriaOcorrencia() {
        return categoriaOcorrencia;
    }

    public Tipo_Ocorrencia getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }
}
