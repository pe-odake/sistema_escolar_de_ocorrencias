package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno;

import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        String nome,
        Date data_nascimento) {
}
