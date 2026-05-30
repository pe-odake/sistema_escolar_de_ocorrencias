package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.matricula.DadosCadastroMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosDetalhamentoMatricula;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.matricula.DadosListagemMatricula;
import com.pedroodake.sistema_de_ocorrencia.application.core.usecase.MatriculaService;
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
@RequestMapping("/matriculas")
@SecurityRequirement(name = "bearer-key")
public class MatriculaController implements ModelDomainController<
        DadosCadastroMatricula,
        DadosListagemMatricula,
        Void,
        Void,
        DadosDetalhamentoMatricula,
        Long> {
    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }
    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoMatricula> cadastrar(
            @RequestBody @Valid DadosCadastroMatricula dados,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoMatricula dto = service.cadastrarMatricula(dados);
        URI uri = uriBuilder
                .path("/matriculas/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Page<DadosListagemMatricula>> listar(
            @ParameterObject @PageableDefault(size = 10) Pageable paginacao) {
        return ResponseEntity.ok(service.listarMatriculas(paginacao));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoMatricula> detalhar(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.detalharMatricula(id));
    }

    @Override
    public ResponseEntity<DadosDetalhamentoMatricula> atualizar(Void dados) {
        return null;
    }

//      NÃO VEJO NECESSIDADE DE ATUALIZAR, TALVEZ FAZER DEPOIS
//    @Override
//    @PutMapping
//    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
//    public ResponseEntity<DadosDetalhamentoMatricula> atualizar(
//            @RequestBody @Valid DadosAtualizacaoMatricula dados) {
//        return ResponseEntity.ok(service.atualizarMatricula(dados));
//    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluirMatricula(id);
        return ResponseEntity.noContent().build();
    }

}