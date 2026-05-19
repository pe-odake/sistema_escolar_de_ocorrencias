package com.pedroodake.sistema_de_ocorrencia.application.port.in;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.usuario.DadosLogin;
import com.pedroodake.sistema_de_ocorrencia.config.security.dto.DadosTokenJWT;
import org.springframework.http.ResponseEntity;

public interface LoginPort {
    ResponseEntity<DadosTokenJWT> logar(DadosLogin dados);
}