package com.pedroodake.sistema_de_ocorrencia.application.port.out;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface TurmaRepository {

    Page<Turma> findAllByAtivoTrue(Pageable paginacao);

    Turma save(Turma turma);

    Optional<Turma> findById(Long id);

    Turma getReferenceById(Long id);

    boolean existsById(Long id);
}
