package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.AlunoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AlunoJpaRepository extends JpaRepository<AlunoEntity, Long> {

    Page<AlunoEntity> findAllByAtivoTrue(Pageable paginacao);
}
