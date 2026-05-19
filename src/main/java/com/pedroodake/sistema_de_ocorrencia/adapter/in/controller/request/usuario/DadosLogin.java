package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(
        @NotBlank
        //@Email Não quero que seja email
        //@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") Não quero que seja cpf
        String login,

        @NotBlank
        //@Pattern(regexp = ".{8,}") Não quero que tenha esse padrão
        String senha) {
}