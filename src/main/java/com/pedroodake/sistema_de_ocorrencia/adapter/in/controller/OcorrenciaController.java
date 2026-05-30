package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.ocorrencia.DadosRegistroOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosDetalhamentoOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.ocorrencia.DadosListagemOcorrencia;
import com.pedroodake.sistema_de_ocorrencia.application.core.usecase.OcorrenciaService;
import com.pedroodake.sistema_de_ocorrencia.application.port.in.ModelDomainController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ocorrencias")
@SecurityRequirement(name = "bearer-key")
public class OcorrenciaController implements ModelDomainController<
        DadosRegistroOcorrencia,
        DadosListagemOcorrencia,
        Void,
        Void,
        DadosDetalhamentoOcorrencia,
        Long> {
    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }
    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoOcorrencia> cadastrar(
            @RequestBody @Valid DadosCadastroOcorrencia dados,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoOcorrencia dto = service.cadastrarOcorrencia(dados);
        URI uri = uriBuilder
                .path("/ocorrencias/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Page<DadosListagemOcorrencia>> listar(
            @ParameterObject @PageableDefault(size = 10) Pageable paginacao) {
        return ResponseEntity.ok(service.listarOcorrencias(paginacao));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoOcorrencia> detalhar(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.detalharOcorrencia(id));
    }

    @Override
    public ResponseEntity<DadosDetalhamentoOcorrencia> atualizar(Void dados) {
        return null;
    }

    //  NÃO VEJO NECESSIDADE DE ATUALIZAR, TALVEZ FAZER DEPOIS
    @Override
    @PutMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoOcorrencia> atualizar(
            @RequestBody @Valid DadosAtualizacaoOcorrencia dados) {
        return ResponseEntity.ok(service.atualizarOcorrencia(dados));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluirOcorrencia(id);
        return ResponseEntity.noContent().build();
    }

}