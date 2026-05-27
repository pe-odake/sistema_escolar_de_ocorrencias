package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;

import java.time.Year;

public record DadosListagemMatricula(
        Long id,
        Aluno aluno,
        Turma turma,
        String nome_turma,
        Turno turno,
        Year ano,
        Integer semestre) {
}
