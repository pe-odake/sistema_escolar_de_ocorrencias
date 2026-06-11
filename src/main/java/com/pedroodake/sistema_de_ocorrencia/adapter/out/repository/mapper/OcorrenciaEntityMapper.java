package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.OcorrenciaEntity;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaEntityMapper {
    private final UsuarioEntityMapper usuarioEntityMapper;
    private final MatriculaEntityMapper matriculaEntityMapper;

    public OcorrenciaEntityMapper(
            UsuarioEntityMapper usuarioEntityMapper,
            MatriculaEntityMapper matriculaEntityMapper) {
        this.usuarioEntityMapper = usuarioEntityMapper;
        this.matriculaEntityMapper = matriculaEntityMapper;
    }

    public Ocorrencia toDomain(OcorrenciaEntity entity) {
        return new Ocorrencia(
                entity.getId(),
                usuarioEntityMapper.toDomain(entity.getUsuario()),
                matriculaEntityMapper.toDomain(entity.getMatricula()),
                entity.getRegistrada_em(),
                entity.getCategoria(),
                entity.getTipo(),
                entity.getDescricao()
        );
    }

    public OcorrenciaEntity toEntity(Ocorrencia ocorrencia) {
        return new OcorrenciaEntity(
                ocorrencia.getId(),
                usuarioEntityMapper.toEntity(ocorrencia.getUsuario()),
                matriculaEntityMapper.toEntity(ocorrencia.getMatricula()),
                ocorrencia.getRegistrada_em(),
                ocorrencia.getCategoria(),
                ocorrencia.getTipo(),
                ocorrencia.getDescricao()
        );
    }
}
