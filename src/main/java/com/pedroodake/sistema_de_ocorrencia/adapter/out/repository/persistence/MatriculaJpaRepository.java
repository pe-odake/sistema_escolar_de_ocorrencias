package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.MatriculaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaJpaRepository extends JpaRepository<MatriculaEntity, Long> {

    Page<MatriculaEntity> findAllByAtivoTrue(Pageable paginacao);
}
