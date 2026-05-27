package com.pedroodake.sistema_de_ocorrencia.application.port.out;

import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AlunoRepository {

    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);

    Aluno save(Aluno aluno);

    Optional<Aluno> findById(Long id);

    Aluno getReferenceById(Long id);

    boolean existsById(Long id);
}
