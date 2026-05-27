package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.matricula;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMatricula (
    @NotNull
    Aluno aluno,

    @NotNull
    Turma turma){
}
