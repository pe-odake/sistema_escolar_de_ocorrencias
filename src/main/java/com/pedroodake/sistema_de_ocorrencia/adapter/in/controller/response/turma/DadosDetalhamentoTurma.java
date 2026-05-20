package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Turno;

import java.time.Year;

public record DadosDetalhamentoTurma(
        Long id,
        String nome_turma,
        Turno turno,
        Year ano,
        Integer semestre) {
}
