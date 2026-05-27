package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.UsuarioEntity;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.mapper.UsuarioEntityMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence.UsuarioJpaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioEntityMapper entityMapper;

    public UsuarioRepositoryImpl(
            UsuarioJpaRepository jpaRepository,
            UsuarioEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public UserDetails findByLogin(String username) {
        return jpaRepository.findByLogin(username);
    }

    @Override
    public Page<Usuario> findAllByAtivoTrue(Pageable paginacao) {
        return jpaRepository
                .findAllByAtivoTrue(paginacao)
                .map(entityMapper::toDomain);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = entityMapper.toEntity(usuario);
        UsuarioEntity saved = jpaRepository.save(entity);
        return entityMapper.toDomain(saved);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepository
                .findById(id)
                .map(entityMapper::toDomain);
    }
}