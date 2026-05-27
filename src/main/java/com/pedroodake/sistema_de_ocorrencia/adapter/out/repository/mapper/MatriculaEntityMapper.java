package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.MatriculaEntity;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaEntityMapper {
    private final AlunoEntityMapper alunoEntityMapper;
    private final TurmaEntityMapper turmaEntityMapper;

    public MatriculaEntityMapper(
            AlunoEntityMapper alunoEntityMapper,
            TurmaEntityMapper turmaEntityMapper) {
        this.alunoEntityMapper = alunoEntityMapper;
        this.turmaEntityMapper = turmaEntityMapper;
    }

    public Matricula toDomain(MatriculaEntity entity) {
        return new Matricula(
                entity.getId(),
                alunoEntityMapper.toDomain(entity.getAluno()),
                turmaEntityMapper.toDomain(entity.getTurma()),
                entity.isAtivo()
        );
    }

    public MatriculaEntity toEntity(Matricula matricula) {
        return new MatriculaEntity(
                matricula.getId(),
                alunoEntityMapper.toEntity(matricula.getAluno()),
                turmaEntityMapper.toEntity(matricula.getTurma()),
                matricula.isAtivo()
        );
    }
}
