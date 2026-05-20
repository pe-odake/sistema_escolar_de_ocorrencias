package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno;

import java.util.Date;

public record DadosListagemAluno(
        Long id,
        String nome,
        Date data_nascimento) {
}
