package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.usuario;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        String login,
        Perfil perfil) {
}