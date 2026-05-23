-- CRIAÇÃO DAS TABELAS DE ALUNO(SEM FOTO) E TURMA

create table aluno (
   id bigint not null auto_increment,
   nome varchar(70) not null,
   data_nascimento date not null,
   ativo tinyint not null default 1,

   primary key(id)
);

create table turma (
   id bigint not null auto_increment,
   nome_turma varchar(70) not null,
   turno varchar(10) not null,
   ano year not null,
   semestre tinyint,
   ativo tinyint not null default 1,

   primary key(id)
);

-- POR SER UMA RELAÇÃO N PARA MUITOS, GERA UMA TABELA ASSOCIATIVA

create table aluno_turma (
    id bigint not null auto_increment,
    aluno_id bigint not null,
    turma_id bigint not null,

    primary key(id),
    constraint fk_aluno foreign key (aluno_id) references aluno (id),
    constraint fk_turma foreign key (turma_id) references turma (id),
    constraint uk_aluno_turma unique (aluno_id, turma_id) -- FAZ COM QUE NÃO TENHA REPETICAO DE UM MESMO ALUNO NA TURMA
);