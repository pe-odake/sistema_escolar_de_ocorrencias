package com.pedroodake.sistema_de_ocorrencia.application.core.domain.model;

public class Matricula {
    private Long id;
    private Aluno aluno;
    private Turma turma;
    private boolean ativo = true;

    public Matricula(
            Long id,
            Aluno aluno,
            Turma turma,
            boolean ativo) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void excluir() { this.ativo = false; }
}
