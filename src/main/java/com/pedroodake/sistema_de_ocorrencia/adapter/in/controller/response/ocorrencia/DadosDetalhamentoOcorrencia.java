package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;

import java.time.Instant;

public record DadosDetalhamentoOcorrencia(
        Long id,
        Usuario usuario,
        Turma turma,
        Aluno aluno,
        Instant registrada_em,
        Categoria_Ocorrencia categoriaOcorrencia,
        Tipo_Ocorrencia tipoOcorrencia,
        String descricao) {

    public DadosDetalhamentoOcorrencia(Ocorrencia ocorrencia) {
        this(
                ocorrencia.getId(),
                ocorrencia.getUsuario(),
                ocorrencia.getTurma(),
                ocorrencia.getAluno(),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoriaOcorrencia(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getDescricao()
        );
    }
}
