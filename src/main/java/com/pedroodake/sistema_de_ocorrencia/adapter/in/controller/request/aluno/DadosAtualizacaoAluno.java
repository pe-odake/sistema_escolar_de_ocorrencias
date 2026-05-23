package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        String nome,
        LocalDate data_nascimento,
        boolean ativo) {
}
