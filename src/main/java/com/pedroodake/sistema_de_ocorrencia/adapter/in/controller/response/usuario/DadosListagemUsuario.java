package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.usuario;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Perfil;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String login,
        Boolean ativo,
        Perfil perfil) {
}