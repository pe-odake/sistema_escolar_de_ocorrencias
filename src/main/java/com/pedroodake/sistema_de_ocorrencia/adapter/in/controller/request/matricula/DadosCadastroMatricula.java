package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.matricula;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroMatricula (
    @NotNull
    Long idAluno,

    @NotNull
    Long idTurma){
}
