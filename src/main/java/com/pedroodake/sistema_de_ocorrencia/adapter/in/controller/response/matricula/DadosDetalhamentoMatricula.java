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
        String nome_turma,
        Turno turno,
        Year ano,
        Integer semestre,
        boolean ativo) {

    public DadosDetalhamentoMatricula(Matricula matricula) {
        this(
            matricula.getId(),
            matricula.getAluno(),
            matricula.getTurma(),
            matricula.getTurma().getNome_turma(),
            matricula.getTurma().getTurno(),
            matricula.getTurma().getAno(),
            matricula.getTurma().getSemestre(),
            matricula.isAtivo()
        );
    }
}
