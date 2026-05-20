package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosCadastroAluno(
        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        Date data_nascimento) {
}
