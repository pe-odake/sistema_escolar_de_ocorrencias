package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

public record DadosAtualizacaoTurma(
        @NotNull
        Long id,
        String nome_turma,
        Turno turno,
        Year ano,
        Integer semestre)  {
}
