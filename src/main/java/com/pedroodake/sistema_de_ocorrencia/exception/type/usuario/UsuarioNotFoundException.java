package com.pedroodake.sistema_de_ocorrencia.exception.type.usuario;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}