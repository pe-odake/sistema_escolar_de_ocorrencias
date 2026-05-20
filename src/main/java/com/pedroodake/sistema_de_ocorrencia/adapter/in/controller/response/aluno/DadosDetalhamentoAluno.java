package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno;

import java.util.Date;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        Date data_nascimento) {
}
