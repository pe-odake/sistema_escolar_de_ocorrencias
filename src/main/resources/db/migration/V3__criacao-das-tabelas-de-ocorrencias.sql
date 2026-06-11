CREATE TABLE ocorrencia (
    id BIGSERIAL NOT NULL,
    usuario_id BIGINT NOT NULL,
    matricula_id BIGINT NOT NULL,
    registrada_em TIMESTAMPTZ NOT NULL,
    categoria VARCHAR(14) NOT NULL,
    tipo VARCHAR(13) NOT NULL,
    descricao VARCHAR(200) NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario (id),
    CONSTRAINT fk_matricula_id FOREIGN KEY (matricula_id) REFERENCES matricula (id)
);