package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    UserDetails findByLogin(String username);

    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);
}