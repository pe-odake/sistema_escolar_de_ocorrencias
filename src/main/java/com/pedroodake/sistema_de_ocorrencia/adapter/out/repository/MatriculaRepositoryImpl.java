package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.MatriculaEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper.MatriculaEntityMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence.MatriculaJpaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.MatriculaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MatriculaRepositoryImpl implements MatriculaRepository {
    private final MatriculaJpaRepository jpaRepository;
    private final MatriculaEntityMapper entityMapper;

    public MatriculaRepositoryImpl(
            MatriculaJpaRepository jpaRepository,
            MatriculaEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Page<Matricula> findAllByAtivoTrue(Pageable paginacao) {
        return jpaRepository
                .findAllByAtivoTrue(paginacao)
                .map(entityMapper::toDomain);
    }

    @Override
    public Matricula save(Matricula usuario) {
        MatriculaEntity entity = entityMapper.toEntity(usuario);
        MatriculaEntity saved = jpaRepository.save(entity);
        return entityMapper.toDomain(saved);
    }

    @Override
    public Optional<Matricula> findById(Long id) {
        return jpaRepository
                .findById(id)
                .map(entityMapper::toDomain);
    }
}
