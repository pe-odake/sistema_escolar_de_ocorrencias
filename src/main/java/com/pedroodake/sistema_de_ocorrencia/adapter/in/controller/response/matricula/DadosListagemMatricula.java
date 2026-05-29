package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;

public record DadosListagemMatricula(
        Long id,
        Aluno aluno,
        Turma turma) {
}
