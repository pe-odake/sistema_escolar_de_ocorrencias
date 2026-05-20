package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma.DadosAtualizacaoTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.turma.DadosCadastroTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma.DadosDetalhamentoTurma;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.turma.DadosListagemTurma;
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
@RequestMapping("/turmas")
@SecurityRequirement(name = "bearer-key")
public class TurmaContoller implements ModelDomainController<
        DadosCadastroTurma,
        DadosListagemTurma,
        DadosAtualizacaoTurma,
        Void,
        DadosDetalhamentoTurma,
        Long>  {
    private final TurmaService service;

    public TurmaController(TurmaService turma) {
        this.service = service;
    }
    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoTurma> cadastrar(
            @RequestBody @Valid DadosCadastroTurma dados,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoTurma dto = service.cadastrarTurma(dados);
        URI uri = uriBuilder
                .path("/usuarios/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Page<DadosListagemTurma>> listar(
            @ParameterObject @PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
        return ResponseEntity.ok(service.listarTurmas(paginacao));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoTurma> detalhar(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.detalharTurma(id));
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoTurma> atualizar(
            @RequestBody @Valid DadosAtualizacaoTurma dados) {
        return ResponseEntity.ok(service.atualizarTurma(dados));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluirTurma(id);
        return ResponseEntity.noContent().build();
    }

}