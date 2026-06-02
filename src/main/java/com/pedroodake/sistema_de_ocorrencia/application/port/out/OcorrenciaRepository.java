package com.pedroodake.sistema_de_ocorrencia.application.port.out;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OcorrenciaRepository {
    Page<Ocorrencia> findAllByAtivoTrue(Pageable paginacao);

    Ocorrencia save(Ocorrencia ocorrencia);

    Optional<Ocorrencia> findById(Long id);

    Ocorrencia getReferenceById(Long id);

    boolean existsById(Long id);
}
