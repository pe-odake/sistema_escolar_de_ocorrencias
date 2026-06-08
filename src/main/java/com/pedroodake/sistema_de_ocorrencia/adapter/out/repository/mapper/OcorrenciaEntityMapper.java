package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.OcorrenciaEntity;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaEntityMapper {
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final TurmaEntityMapper turmaEntityMapper;
    private final AlunoEntityMapper alunoEntityMapper;

    public OcorrenciaEntityMapper(
            UsuarioEntityMapper usuarioEntityMapper,
            TurmaEntityMapper turmaEntityMapper,
            AlunoEntityMapper alunoEntityMapper) {
        this.usuarioEntityMapper = usuarioEntityMapper;
        this.turmaEntityMapper = turmaEntityMapper;
        this.alunoEntityMapper = alunoEntityMapper;
    }

    public Ocorrencia toDomain(OcorrenciaEntity entity) {
        return new Ocorrencia(
                entity.getId(),
                usuarioEntityMapper.toDomain(entity.getUsuario()),
                turmaEntityMapper.toDomain(entity.getTurma()),
                alunoEntityMapper.toDomain(entity.getAluno()),
                entity.getRegistrada_em(),
                entity.getCategoriaOcorrencia(),
                entity.getTipoOcorrencia(),
                entity.getDescricao()
        );
    }

    public OcorrenciaEntity toEntity(Ocorrencia ocorrencia) {
        return new OcorrenciaEntity(
                ocorrencia.getId(),
                usuarioEntityMapper.toEntity(ocorrencia.getUsuario()),
                turmaEntityMapper.toEntity(ocorrencia.getTurma()),
                alunoEntityMapper.toEntity(ocorrencia.getAluno()),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoriaOcorrencia(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getDescricao()
        );
    }
}
