package com.pedroodake.sistema_de_ocorrencia.application.core.usecase;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper.TurmaMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma.DadosAtualizacaoTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma.DadosCadastroTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma.DadosDetalhamentoTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma.DadosListagemTurma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.TurmaRepository;
import com.pedroodake.sistema_de_ocorrencia.exception.type.turma.TurmaNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurmaService {
    private final TurmaRepository repository;
    private final TurmaMapper mapper;

    public TurmaService(
            TurmaRepository repository,
            TurmaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public DadosDetalhamentoTurma cadastrarTurma(DadosCadastroTurma dados) {
        Turma turma = mapper.toDomain(dados);
        Turma saved =repository.save(turma);
        return mapper.toDetailsDTO(saved);
    }

    public Page<DadosListagemTurma> listarTurmas(Pageable paginacao) {
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
    }

    public DadosDetalhamentoTurma detalharTurma(Long id) {
        Turma aluno = repository.findById(id)
                .orElseThrow(() ->
                        new TurmaNotFoundException("ID da turma não existe! : ( "));
        return mapper.toDetailsDTO(aluno);
    }

    @Transactional
    public DadosDetalhamentoTurma atualizarTurma(DadosAtualizacaoTurma dados) {
        Turma aluno = repository.findById(dados.id())
                .orElseThrow(() ->
                        new TurmaNotFoundException("ID da turma não existe! : ("));
        aluno.atualizarInformacoes(
                dados.nome_turma(),
                dados.turno(),
                dados.ano(),
                dados.semestre());
        Turma saved = repository.save(aluno);
        return mapper.toDetailsDTO(saved);
    }

    @Transactional
    public void excluirTurma(Long id) {
        Turma aluno = repository.findById(id)
                .orElseThrow(() ->
                        new TurmaNotFoundException("ID do aluno não existe! : ("));
        aluno.excluir();
        repository.save(aluno);
    }
}
