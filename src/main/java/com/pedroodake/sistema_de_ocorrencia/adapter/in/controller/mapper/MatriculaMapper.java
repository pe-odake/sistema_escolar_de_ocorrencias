package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.matricula.DadosCadastroMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosListagemMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosDetalhamentoMatricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

@Component
public class MatriculaMapper {
    public Matricula toDomain(DadosCadastroMatricula dados) {
        return new Matricula(
                null,
                dados.aluno(),
                dados.turma(),
                true
        );
    }

    public DadosListagemMatricula toListDTO(Matricula matricula) {
        return new DadosListagemMatricula(
                matricula.getId(),
                matricula.getAluno(),
                matricula.getTurma(),
                matricula.getTurma().getNome_turma(),
                matricula.getTurma().getTurno(),
                matricula.getTurma().getAno(),
                matricula.getTurma().getSemestre()
        );
    }

    public DadosDetalhamentoMatricula toDetailsDTO(Matricula matricula) {
        return new DadosDetalhamentoMatricula(
                matricula.getId(),
                matricula.getAluno(),
                matricula.getTurma(),
                matricula.getTurma().getNome_turma(),
                matricula.getTurma().getTurno(),
                matricula.getTurma().getAno(),
                matricula.getTurma().getSemestre(),
                matricula.isAtivo()
        );
    }
}
