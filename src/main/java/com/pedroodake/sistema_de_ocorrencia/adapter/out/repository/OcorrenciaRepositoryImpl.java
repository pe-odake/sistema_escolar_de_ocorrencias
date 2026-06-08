package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.OcorrenciaEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper.OcorrenciaEntityMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence.OcorrenciaJpaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.OcorrenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OcorrenciaRepositoryImpl implements OcorrenciaRepository {
    private final OcorrenciaJpaRepository jpaRepository;
    private final OcorrenciaEntityMapper entityMapper;

    public OcorrenciaRepositoryImpl(
            OcorrenciaJpaRepository jpaRepository,
            OcorrenciaEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override // SUBSTITUIR POR SOFT DELETE
    public void delete(Ocorrencia ocorrencia) {
        jpaRepository.deleteById(ocorrencia.getId());
    }

//    @Override
//    public Page<Ocorrencia> findAllByAtivoTrue(Pageable paginacao) {
//        return jpaRepository
//                .findAllByAtivoTrue(paginacao)
//                .map(entityMapper::toDomain);
//    }

    @Override
    public Page<Ocorrencia> findAll(Pageable paginacao) {
        return jpaRepository
                .findAll(paginacao)
                .map(entityMapper::toDomain);
    }

    @Override
    public Ocorrencia save(Ocorrencia usuario) {
        OcorrenciaEntity entity = entityMapper.toEntity(usuario);
        OcorrenciaEntity saved = jpaRepository.save(entity);
        return entityMapper.toDomain(saved);
    }

    @Override
    public Optional<Ocorrencia> findById(Long id) {
        return jpaRepository
                .findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public Ocorrencia getReferenceById(Long id) {
        OcorrenciaEntity entity = jpaRepository.getReferenceById(id);
        return entityMapper.toDomain(entity);
    }
}
