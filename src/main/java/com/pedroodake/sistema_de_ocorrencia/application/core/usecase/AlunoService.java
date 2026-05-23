package com.pedroodake.sistema_de_ocorrencia.application.core.usecase;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper.AlunoMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno.DadosAtualizacaoAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno.DadosCadastroAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno.DadosDetalhamentoAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno.DadosListagemAluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.AlunoRepository;
import com.pedroodake.sistema_de_ocorrencia.exception.type.aluno.AlunoNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    private final AlunoMapper mapper;

    public AlunoService(
            AlunoRepository repository,
            AlunoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public DadosDetalhamentoAluno cadastrarAluno(DadosCadastroAluno dados) {
        Aluno aluno = mapper.toDomain(dados);
        Aluno saved =repository.save(aluno);
        return mapper.toDetailsDTO(saved);
    }

    public Page<DadosListagemAluno> listarAlunos(Pageable paginacao) {
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
    }

    public DadosDetalhamentoAluno detalharAluno(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() ->
                        new AlunoNotFoundException("ID do aluno não existe! : ( "));
        return mapper.toDetailsDTO(aluno);
    }

    @Transactional
    public DadosDetalhamentoAluno atualizarAluno(DadosAtualizacaoAluno dados) {
        Aluno aluno = repository.findById(dados.id())
                .orElseThrow(() ->
                        new AlunoNotFoundException("ID do aluno não existe! : ("));
        aluno.atualizarInformacoes(dados.nome(), dados.data_nascimento()); // FUTURAMENTE ADICIONAR O CAMPO DA FOTO
        Aluno saved = repository.save(aluno);
        return mapper.toDetailsDTO(saved);
    }

    @Transactional
    public void excluirAluno(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() ->
                        new AlunoNotFoundException("ID do aluno não existe! : ("));
        aluno.excluir();
        repository.save(aluno);
    }

}
