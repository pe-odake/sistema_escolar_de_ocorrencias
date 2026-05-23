package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno;

import java.time.LocalDate;

public record DadosListagemAluno(
        Long id,
        String nome,
        LocalDate data_nascimento) {
}
