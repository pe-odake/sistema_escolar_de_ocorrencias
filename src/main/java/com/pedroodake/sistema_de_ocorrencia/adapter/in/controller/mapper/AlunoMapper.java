package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno.DadosCadastroAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno.DadosDetalhamentoAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno.DadosListagemAluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public Aluno toDomain(DadosCadastroAluno dados) {
        return new Aluno(
                null,
                dados.nome(),
                dados.data_nascimento(),
                true
        );
    }

    public DadosListagemAluno toListDTO(Aluno aluno) {
        return new DadosListagemAluno(
                aluno.getId(),
                aluno.getNome(),
                aluno.getData_nascimento()
        );
    }

    public DadosDetalhamentoAluno toDetailsDTO(Aluno aluno) {
        return new DadosDetalhamentoAluno(
                aluno.getId(),
                aluno.getNome(),
                aluno.getData_nascimento(),
                aluno.getAtivo()
        );
    }
}
