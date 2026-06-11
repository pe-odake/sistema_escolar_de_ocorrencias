package com.pedroodake.sistema_de_ocorrencia.application.core.usecase;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.mapper.OcorrenciaMapper;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia.DadosAtualizacaoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia.DadosRegistroOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosDetalhamentoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosListagemOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Matricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Ocorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.domain.model.Usuario;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.MatriculaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.OcorrenciaRepository;
import com.pedroodake.sistema_de_ocorrencia.application.port.out.UsuarioRepository;
import com.pedroodake.sistema_de_ocorrencia.exception.type.matricula.MatriculaNotFoundException;
import com.pedroodake.sistema_de_ocorrencia.exception.type.ocorrencia.OcorrenciaNotFoundException;
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
    private final MatriculaRepository matriculaRepository;

    public OcorrenciaService(
            OcorrenciaRepository repository,
            OcorrenciaMapper mapper,
            UsuarioRepository usuarioRepository,
            MatriculaRepository matriculaRepository){
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioRepository = usuarioRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @Transactional
    public DadosDetalhamentoOcorrencia cadastrarOcorrencia(DadosRegistroOcorrencia dados) {
        if (!usuarioRepository.existsById(dados.idUsuario())) {
            throw new UsuarioNotFoundException("ID do instrutor informado não existe!");
        }
        if (!matriculaRepository.existsById(dados.idMatricula())) {
            throw new MatriculaNotFoundException("ID da matrícula informada não existe!");
        }
        //Validações
        //validadoresOcorrencia.forEach(v -> v.validar(dados));

        Usuario usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        Matricula matricula = matriculaRepository.getReferenceById(dados.idMatricula());

        Ocorrencia ocorrencia = new Ocorrencia(
                null,
                usuario,
                matricula,
                java.time.Instant.now(),
                dados.categoria(),
                dados.tipo(),
                dados.descricao()
        );
        Ocorrencia saved = repository.save(ocorrencia);
        return new DadosDetalhamentoOcorrencia(saved);
    }

    public Page<DadosListagemOcorrencia> listarOcorrencias(Pageable paginacao) {
        // .findAllByAtivoTrue(paginacao)
        return repository
                .findAll(paginacao)
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
                dados.matricula(),
                dados.categoria(),
                dados.tipo(),
                dados.descricao());
        Ocorrencia saved = repository.save(ocorrencia);
        return mapper.toDetailsDTO(saved);
    }

    @Transactional // SUBSTITUIR POR SOFT DELETE
    public void excluirOcorrencia(Long id) {
        Ocorrencia ocorrencia = repository.findById(id)
                .orElseThrow(() ->
                        new OcorrenciaNotFoundException("ID do ocorrencia não existe! : ("));
        repository.delete(ocorrencia);
    }
}
