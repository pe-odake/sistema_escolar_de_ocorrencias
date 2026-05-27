package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.TurmaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaJpaRepository extends JpaRepository<TurmaEntity, Long> {

    Page<TurmaEntity> findAllByAtivoTrue(Pageable paginacao);
}
