package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record DadosRegistroOcorrencia(
        @NotNull
        Long idUsuario,

        @NotNull
        Long idTurma,

        @NotNull
        Long idAluno,

        @NotNull
        Instant registrada_em,

        @NotNull
        Categoria_Ocorrencia categoriaOcorrencia,

        @NotNull
        Tipo_Ocorrencia tipoOcorrencia,
        String descricao) {
}
