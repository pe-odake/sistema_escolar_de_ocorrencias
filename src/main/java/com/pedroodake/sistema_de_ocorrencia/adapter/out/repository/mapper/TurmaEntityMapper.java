package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.TurmaEntity;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaEntityMapper {
    public Turma toDomain(TurmaEntity entity){
        return new Turma(
            entity.getId(),
            entity.getNome_turma(),
            entity.getTurno(),
            entity.getAno(),
            entity.getSemestre(),
            entity.isAtivo()
        );
    }

public TurmaEntity toEntity(Turma turma) {
    return new TurmaEntity(
            turma.getId(),
            turma.getNome_turma(),
            turma.getTurno(),
            turma.getAno(),
            turma.getSemestre(),
            turma.getAtivo()
        );
    }
}
