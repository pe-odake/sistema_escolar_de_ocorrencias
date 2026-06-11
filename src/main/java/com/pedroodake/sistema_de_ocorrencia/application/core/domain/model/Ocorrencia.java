package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;

import java.time.Instant;

public class Ocorrencia {
    private Long id;
    private Usuario usuario;
    private Matricula matricula;
    private Instant registrada_em;
    private Categoria_Ocorrencia categoria;
    private Tipo_Ocorrencia tipo;
    private String descricao;

    public Ocorrencia(
            Long id,
            Usuario usuario,
            Matricula matricula,
            Instant registrada_em,
            Categoria_Ocorrencia categoria,
            Tipo_Ocorrencia tipo,
            String descricao
            ) {
        this.id = id;
        this.usuario = usuario;
        this.matricula = matricula;
        this.registrada_em = registrada_em;
        this.categoria = categoria;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Matricula getMatricula() {
        return matricula;
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
           Matricula matricula,
           Categoria_Ocorrencia categoria,
           Tipo_Ocorrencia tipo,
           String descricao) {
        if (usuario != null ) {
            this.usuario = usuario;
        }
        if (matricula != null ) {
            this.matricula = matricula;
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
