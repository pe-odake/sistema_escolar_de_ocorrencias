package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record DadosListagemOcorrencia (
        Long id,
        UsuarioResumo usuario,
        TurmaResumo turma,
        AlunoResumo aluno,
        @JsonFormat(pattern = "dd/MM/yyyy - HH:mm", timezone = "America/Sao_Paulo")
        Instant registrada_em,
        Categoria_Ocorrencia categoria,
        Tipo_Ocorrencia tipo,
        String descricao) {

    public DadosListagemOcorrencia(Ocorrencia ocorrencia) {
        this(
                ocorrencia.getId(),
                new UsuarioResumo(ocorrencia.getUsuario()),
                new TurmaResumo(ocorrencia.getMatricula().getTurma()),
                new AlunoResumo(ocorrencia.getMatricula().getAluno()),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoria(),
                ocorrencia.getTipo(),
                ocorrencia.getDescricao()
        );
    }

    public record UsuarioResumo(Long id, String nome) {
        public UsuarioResumo(Usuario usuario) {
            this(usuario.getId(), usuario.getNome());
        }
    }

    public record TurmaResumo(Long id, String nome_turma) {
        public TurmaResumo(Turma turma) {
            this(turma.getId(), turma.getNome_turma());
        }
    }

    public record AlunoResumo(Long id, String nome) {
        public AlunoResumo(Aluno aluno) {
            this(aluno.getId(), aluno.getNome());
        }
    }
}
