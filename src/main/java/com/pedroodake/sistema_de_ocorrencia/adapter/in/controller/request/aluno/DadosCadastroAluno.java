package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroAluno(
        @NotBlank
        String nome,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull
        LocalDate data_nascimento) {
}
