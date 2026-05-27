package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.AlunoEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.MatriculaEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.AlunoEntity;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoEntityMapper {
    public Aluno toDomain(AlunoEntity entity){
        return new Aluno(
                entity.getId(),
                entity.getNome(),
                entity.getData_nascimento(),
                entity.isAtivo()
        );
    }

    public AlunoEntity toEntity(Aluno turma) {
        return new AlunoEntity(
                turma.getId(),
                turma.getNome(),
                turma.getData_nascimento(),
                turma.getAtivo()
        );
    }
}
