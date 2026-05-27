package com.pedroodake.sistema_de_ocorrencia.application.port.out;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MatriculaRepository {

    Page<Matricula> findAllByAtivoTrue(Pageable paginacao);

    Matricula save(Matricula matricula);

    Optional<Matricula> findById(Long id);
}
