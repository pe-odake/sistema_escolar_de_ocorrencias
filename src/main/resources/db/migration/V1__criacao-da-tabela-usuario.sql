-- CRIAÇÃO INICIAL DAS TABELAS DE USUARIO

create table usuario (
    id bigserial not null,
    nome varchar(70) not null,
    login varchar(100) not null unique,
    senha varchar(255) not null,
    ativo boolean not null default true,
    perfil varchar(25) not null,

    primary key(id)
);