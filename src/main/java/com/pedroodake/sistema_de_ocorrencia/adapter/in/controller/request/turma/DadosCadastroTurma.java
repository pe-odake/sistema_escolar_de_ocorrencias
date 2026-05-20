package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Year;

public record DadosCadastroTurma(
    @NotBlank
    String nome_turma,

    @NotNull
    Turno turno,

    @NotBlank
    Year ano,

    @NotBlank
    Integer semestre) {
}
