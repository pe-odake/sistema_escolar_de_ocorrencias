package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;

import java.time.Year;

public record DadosDetalhamentoMatricula (
        Long id,
        Aluno aluno,
        Turma turma,
        boolean ativo) {

    public DadosDetalhamentoMatricula(Matricula matricula) {
        this(
            matricula.getId(),
            matricula.getAluno(),
            matricula.getTurma(),
            matricula.isAtivo()
        );
    }
}
