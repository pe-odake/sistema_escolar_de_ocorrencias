package com.pedroodake.sistema_de_ocorrencia.application.core.usecase;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper.OcorrenciaMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia.DadosAtualizacaoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia.DadosRegistroOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosDetalhamentoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosListagemOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Aluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Turma;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.AlunoRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.OcorrenciaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.TurmaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.UsuarioRepository;
import com.pedroodake.sistema_de_ocorrencia.exception.type.aluno.AlunoNotFoundException;
import com.pedroodake.sistema_de_ocorrencia.exception.type.ocorrencia.OcorrenciaNotFoundException;
import com.pedroodake.sistema_de_ocorrencia.exception.type.turma.TurmaNotFoundException;
import com.pedroodake.sistema_de_ocorrencia.exception.type.usuario.UsuarioNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OcorrenciaService {
    private final OcorrenciaRepository repository;
    private final OcorrenciaMapper mapper;
    private final UsuarioRepository usuarioRepository;
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    public OcorrenciaService(
            OcorrenciaRepository repository,
            OcorrenciaMapper mapper,
            UsuarioRepository usuarioRepository,
            TurmaRepository turmaRepository,
            AlunoRepository alunoRepository){
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioRepository = usuarioRepository;
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public DadosDetalhamentoOcorrencia cadastrarOcorrencia(DadosRegistroOcorrencia dados) {
        if (!usuarioRepository.existsById(dados.idUsuario())) {
            throw new UsuarioNotFoundException("ID do instrutor informado não existe!");
        }
        if (!turmaRepository.existsById(dados.idTurma())) {
            throw new TurmaNotFoundException("ID do aluno informado não existe!");
        }
        if (!alunoRepository.existsById(dados.idAluno())) {
            throw new AlunoNotFoundException("ID do aluno informado não existe!");
        }
        //Validações
        //validadoresOcorrencia.forEach(v -> v.validar(dados));

        Usuario usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        Turma turma = turmaRepository.getReferenceById(dados.idTurma());
        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());

        Ocorrencia ocorrencia = new Ocorrencia(
                null,
                usuario,
                turma,
                aluno,
                dados.registrada_em(),
                dados.categoriaOcorrencia(),
                dados.tipoOcorrencia(),
                dados.descricao()
        );
        Ocorrencia saved = repository.save(ocorrencia);
        return new DadosDetalhamentoOcorrencia(saved);
    }

    public Page<DadosListagemOcorrencia> listarOcorrencias(Pageable paginacao) {
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
    }

    public DadosDetalhamentoOcorrencia detalharOcorrencia(Long id) {
        Ocorrencia ocorrencia = repository.findById(id)
                .orElseThrow(() ->
                        new OcorrenciaNotFoundException("ID do ocorrencia não existe! : ( "));
        return mapper.toDetailsDTO(ocorrencia);
    }

    @Transactional
    public DadosDetalhamentoOcorrencia atualizarOcorrencia(DadosAtualizacaoOcorrencia dados) {
        Ocorrencia ocorrencia = repository.findById(dados.id())
                .orElseThrow(() ->
                        new OcorrenciaNotFoundException("ID do ocorrencia não existe! : ("));
        ocorrencia.atualizarInformacoes(
                dados.usuario(),
                dados.turma(),
                dados.aluno(),
                dados.categoriaOcorrencia(),
                dados.tipoOcorrencia(),
                dados.descricao());
        Ocorrencia saved = repository.save(ocorrencia);
        return mapper.toDetailsDTO(saved);
    }
}
