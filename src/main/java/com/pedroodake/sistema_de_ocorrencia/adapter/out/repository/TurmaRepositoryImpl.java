package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.TurmaEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper.TurmaEntityMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence.TurmaJpaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.TurmaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TurmaRepositoryImpl implements TurmaRepository {
    private final TurmaJpaRepository jpaRepository;
    private final TurmaEntityMapper entityMapper;

    public TurmaRepositoryImpl(
            TurmaJpaRepository jpaRepository,
            TurmaEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Page<Turma> findAllByAtivoTrue(Pageable paginacao) {
        return jpaRepository
                .findAllByAtivoTrue(paginacao)
                .map(entityMapper::toDomain);
    }

    @Override
    public Turma save(Turma usuario) {
        TurmaEntity entity = entityMapper.toEntity(usuario);
        TurmaEntity saved = jpaRepository.save(entity);
        return entityMapper.toDomain(saved);
    }

    @Override
    public Optional<Turma> findById(Long id) {
        return jpaRepository
                .findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public Turma getReferenceById(Long id) {
        TurmaEntity entity = jpaRepository.getReferenceById(id);
        return entityMapper.toDomain(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
