package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record DadosAtualizacaoOcorrencia(
        @NotNull
        Long id,
        Usuario usuario,
        Turma turma,
        Aluno aluno,
        Categoria_Ocorrencia categoriaOcorrencia,
        Tipo_Ocorrencia tipoOcorrencia,
        String descricao
) {
}
