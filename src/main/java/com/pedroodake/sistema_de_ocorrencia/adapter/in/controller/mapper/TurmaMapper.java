package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma.DadosCadastroTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma.DadosDetalhamentoTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma.DadosListagemTurma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {
    public Turma toDomain(DadosCadastroTurma dados) {
        return new Turma(
                null,
                dados.nome_turma(),
                dados.turno(),
                dados.ano(),
                dados.semestre()
        );
    }

    public DadosListagemTurma toListDTO(Turma turma) {
        return new DadosListagemTurma(
                turma.getId(),
                turma.getNome_turma(),
                turma.getTurno(),
                turma.getAno(),
                turma.getSemestre()
        );
    }

    public DadosDetalhamentoTurma toDetailsDTO(Turma turma) {
        return new DadosDetalhamentoTurma(
                turma.getId(),
                turma.getNome_turma(),
                turma.getTurno(),
                turma.getAno(),
                turma.getSemestre()
        );
    }

}
