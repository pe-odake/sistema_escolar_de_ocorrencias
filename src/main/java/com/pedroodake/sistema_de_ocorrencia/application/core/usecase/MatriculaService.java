package com.pedroodake.sistema_de_ocorrencia.application.core.usecase;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper.MatriculaMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.matricula.DadosCadastroMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosDetalhamentoMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosListagemMatricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.AlunoRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.MatriculaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.TurmaRepository;
import com.pedroodake.sistema_de_ocorrencia.exception.type.aluno.AlunoNotFoundException;
import com.pedroodake.sistema_de_ocorrencia.exception.type.matricula.MatriculaNotFoundException;
import com.pedroodake.sistema_de_ocorrencia.exception.type.turma.TurmaNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatriculaService {
    private final MatriculaRepository repository;
    private final MatriculaMapper mapper;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public MatriculaService(
            MatriculaRepository repository,
            MatriculaMapper mapper,
            AlunoRepository alunoRepository,
            TurmaRepository turmaRepository){
        this.repository = repository;
        this.mapper = mapper;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    @Transactional
    public DadosDetalhamentoMatricula cadastrarMatricula(DadosCadastroMatricula dados) {
        if(!alunoRepository.existsById(dados.idAluno())) {
            throw new AlunoNotFoundException("ID do aluno informado não existe! : (");
        }
        if(!turmaRepository.existsById(dados.idTurma())) {
            throw new TurmaNotFoundException("ID da turma informada não existe! : (");
        }

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Turma turma = turmaRepository.getReferenceById(dados.idTurma());

        Matricula matricula = new Matricula(
                null,
                aluno,
                turma,
                true
        );
        Matricula saved = repository.save(matricula);
        return new DadosDetalhamentoMatricula(saved);

    }

    public Page<DadosListagemMatricula> listarMatriculas(Pageable paginacao) {
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
    }

    public DadosDetalhamentoMatricula detalharMatricula(Long id) {
        Matricula matricula = repository.findById(id)
                .orElseThrow(() ->
                        new MatriculaNotFoundException("ID do matricula não existe! : ( "));
        return mapper.toDetailsDTO(matricula);
    }
//
//    @Transactional
//    public DadosDetalhamentoMatricula atualizarMatricula(DadosAtualizacaoMatricula dados) {
//        Matricula matricula = repository.findById(dados.id())
//                .orElseThrow(() ->
//                        new MatriculaNotFoundException("ID do matricula não existe! : ("));
//        matricula.atualizarInformacoes(dados.nome(), dados.data_nascimento()); // FUTURAMENTE ADICIONAR O CAMPO DA FOTO
//        Matricula saved = repository.save(matricula);
//        return mapper.toDetailsDTO(saved);
//    }

    @Transactional
    public void excluirMatricula(Long id) {
        Matricula matricula = repository.findById(id)
                .orElseThrow(() ->
                        new MatriculaNotFoundException("ID do matricula não existe! : ("));
        matricula.excluir();
        repository.save(matricula);
    }
}
