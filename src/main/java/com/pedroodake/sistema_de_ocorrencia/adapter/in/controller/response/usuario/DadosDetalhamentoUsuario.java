package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.usuario;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Perfil;

public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String login,
        boolean ativo,
        Perfil perfil) {
}