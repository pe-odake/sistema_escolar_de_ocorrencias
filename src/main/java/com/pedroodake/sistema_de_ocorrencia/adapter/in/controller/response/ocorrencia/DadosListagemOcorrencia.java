package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Categoria_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.enums.Tipo_Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;

import java.time.Instant;

public record DadosListagemOcorrencia (
        Long id,
        Usuario usuario,
        Turma turma,
        Aluno aluno,
        Instant registrada_em,
        Categoria_Ocorrencia categoriaOcorrencia,
        Tipo_Ocorrencia tipoOcorrencia,
        String descricao) {
}
