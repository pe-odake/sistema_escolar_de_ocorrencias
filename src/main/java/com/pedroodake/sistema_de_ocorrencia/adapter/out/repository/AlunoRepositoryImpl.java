package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.AlunoEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper.AlunoEntityMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence.AlunoJpaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlunoRepositoryImpl implements AlunoRepository {
    private final AlunoJpaRepository jpaRepository;
    private final AlunoEntityMapper entityMapper;

    public AlunoRepositoryImpl(
            AlunoJpaRepository jpaRepository,
            AlunoEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Page<Aluno> findAllByAtivoTrue(Pageable paginacao) {
        return jpaRepository
                .findAllByAtivoTrue(paginacao)
                .map(entityMapper::toDomain);
    }

    @Override
    public Aluno save(Aluno usuario) {
        AlunoEntity entity = entityMapper.toEntity(usuario);
        AlunoEntity saved = jpaRepository.save(entity);
        return entityMapper.toDomain(saved);
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return jpaRepository
                .findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public Aluno getReferenceById(Long id) {
        AlunoEntity entity = jpaRepository.getReferenceById(id);
        return entityMapper.toDomain(entity);
    }
}
