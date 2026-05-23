package com.pedroodake.sistema_de_ocorrencia.adapter.in.controller;

import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno.DadosCadastroAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.request.aluno.DadosAtualizacaoAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno.DadosDetalhamentoAluno;
import com.pedroodake.sistema_de_ocorrencia.adapter.in.controller.response.aluno.DadosListagemAluno;
import com.pedroodake.sistema_de_ocorrencia.application.core.usecase.AlunoService;
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
@RequestMapping("/alunos")
@SecurityRequirement(name = "bearer-key")
public class AlunoController implements ModelDomainController<
        DadosCadastroAluno,
        DadosListagemAluno,
        DadosAtualizacaoAluno,
        Void,
        DadosDetalhamentoAluno,
        Long>  {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }
    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoAluno> cadastrar(
            @RequestBody @Valid DadosCadastroAluno dados,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoAluno dto = service.cadastrarAluno(dados);
        URI uri = uriBuilder
                .path("/usuarios/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Page<DadosListagemAluno>> listar(
            @ParameterObject @PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
        return ResponseEntity.ok(service.listarAlunos(paginacao));
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoAluno> detalhar(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.detalharAluno(id));
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<DadosDetalhamentoAluno> atualizar(
            @RequestBody @Valid DadosAtualizacaoAluno dados) {
        return ResponseEntity.ok(service.atualizarAluno(dados));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ANALISTA_DE_QUALIDADE', 'COORDENADOR', 'PROFESSOR_ADMINISTRATIVO')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluirAluno(id);
        return ResponseEntity.noContent().build();
    }

}