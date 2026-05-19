-- CRIAÇÃO INICIAL DAS TABELAS DE USUARIO

create table usuario (
    id bigint not null auto_increment,
    nome varchar(70) not null,
    login varchar(100) not null unique,
    senha varchar(255) not null,
    ativo tinyint not null default 1,
    perfil varchar(25) not null,

    primary key(id)
)