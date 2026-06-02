package com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.persistence;

import com.pedroodake.sistema_de_ocorrencia.adapter.out.repository.entity.OcorrenciaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaJpaRepository extends JpaRepository<OcorrenciaEntity, Long> {
    Page<OcorrenciaEntity> findAllByAtivoTrue(Pageable paginacao);

}
