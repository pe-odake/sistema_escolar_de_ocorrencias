package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.usuario;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,

        @NotBlank
        String login,

        @NotBlank
        String senha,

        @NotNull
        Perfil perfil) {
}