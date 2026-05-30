CREATE TABLE ocorrencia (
    id BIGSERIAL NOT NULL,
    usuario_id BIGINT NOT NULL,
    turma_id BIGINT NOT NULL,
    aluno_id BIGINT NOT NULL,
    registrada_em TIMESTAMPTZ NOT NULL,
    categoria BIGINT NOT NULL,
    tipo BIGINT NOT NULL,
    descricao VARCHAR(200) NOT NULL,

    PRIMARY KEY(id),
    REFERENCES fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario (id),
    REFERENCES fk_aluno_id FOREIGN KEY (aluno_id) REFERENCES aluno (id),
    REFERENCES fk_turma_id FOREIGN KEY (turma_id) REFERENCES turma (id)
);