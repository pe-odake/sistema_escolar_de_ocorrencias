package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Perfil;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.time.Year;

public record DadosDetalhamentoOcorrencia(
        Long id,
        UsuarioDetailResponse usuario,
        TurmaDetailResponse turma,
        AlunoDetailResponse aluno,
        
        @JsonFormat(pattern = "dd/MM/yyyy - HH:mm", timezone = "America/Sao_Paulo")
        Instant registrada_em,
        
        Categoria_Ocorrencia categoria,
        Tipo_Ocorrencia tipo,
        String descricao) {

    public DadosDetalhamentoOcorrencia(Ocorrencia ocorrencia) {
        this(
                ocorrencia.getId(),
                new UsuarioDetailResponse(ocorrencia.getUsuario()),
                new TurmaDetailResponse(ocorrencia.getMatricula().getTurma()),
                new AlunoDetailResponse(ocorrencia.getMatricula().getAluno()),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoria(),
                ocorrencia.getTipo(),
                ocorrencia.getDescricao()
        );
    }

    public record UsuarioDetailResponse(Long id, String nome, Perfil perfil) {
        public UsuarioDetailResponse(Usuario usuario) {
            this(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getPerfil()
            );
        }
    }

    public record TurmaDetailResponse(Long id, String nome_turma, Turno turno, Year ano, Integer semestre) {
        public TurmaDetailResponse(Turma turma) {
            this(
                    turma.getId(),
                    turma.getNome_turma(),
                    turma.getTurno(),
                    turma.getAno(),
                    turma.getSemestre()
            );
        }
    }

    public record AlunoDetailResponse(Long id, String nome) {
        public AlunoDetailResponse(Aluno aluno) {
            this(
                    aluno.getId(),
                    aluno.getNome());
        }
    }
}
