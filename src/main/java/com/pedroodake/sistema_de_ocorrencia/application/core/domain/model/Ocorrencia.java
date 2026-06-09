package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;

import java.time.Instant;

public class Ocorrencia {
    private Long id;
    private Usuario usuario;
    private Turma turma;
    private Aluno aluno;
    private Instant registrada_em;
    private Categoria_Ocorrencia categoria;
    private Tipo_Ocorrencia tipo;
    private String descricao;

    public Ocorrencia(
            Long id,
            Usuario usuario,
            Turma turma,
            Aluno aluno,
            Instant registrada_em,
            Categoria_Ocorrencia categoria,
            Tipo_Ocorrencia tipo,
            String descricao
            ) {
        this.id = id;
        this.usuario = usuario;
        this.turma = turma;
        this.aluno = aluno;
        this.registrada_em = registrada_em;
        this.categoria = categoria;
        this.tipo = tipo;
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

    public Categoria_Ocorrencia getCategoria() {
        return categoria;
    }

    public Tipo_Ocorrencia getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void atualizarInformacoes(
           Usuario usuario,
           Turma turma,
           Aluno aluno,
           Categoria_Ocorrencia categoria,
           Tipo_Ocorrencia tipo,
           String descricao) {
        if (usuario != null ) {
            this.usuario = usuario;
        }
        if (turma != null ) {
            this.turma = turma;
        }
        if (aluno != null ) {
            this.aluno = aluno;
        }
        if (categoria != null ) {
            this.categoria = categoria;
        }
        if (tipo != null ) {
            this.tipo = tipo;
        }
        if (descricao != null && !descricao.isBlank()) {
            this.descricao = descricao;
        }
    }
}
