package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.matricula.DadosCadastroMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosListagemMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosDetalhamentoMatricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {


    public DadosListagemMatricula toListDTO(Matricula matricula) {
        return new DadosListagemMatricula(
                matricula.getId(),
                matricula.getAluno(),
                matricula.getTurma()
        );
    }

    public DadosDetalhamentoMatricula toDetailsDTO(Matricula matricula) {
        return new DadosDetalhamentoMatricula(
                matricula.getId(),
                matricula.getAluno(),
                matricula.getTurma(),
                matricula.isAtivo()
        );
    }
}
