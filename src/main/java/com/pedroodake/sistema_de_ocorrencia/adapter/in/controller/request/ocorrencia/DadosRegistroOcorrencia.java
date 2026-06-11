package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import jakarta.validation.constraints.NotNull;

public record DadosRegistroOcorrencia(
        @NotNull
        Long idUsuario,

        @NotNull
        Long idMatricula,

        @NotNull
        Categoria_Ocorrencia categoria,

        @NotNull
        Tipo_Ocorrencia tipo,
        
        String descricao) {
}
