-- CRIAÇÃO DAS TABELAS DE ALUNO(SEM FOTO) E TURMA

create table aluno (
    id bigserial not null,
    nome varchar(70) not null,
    data_nascimento date not null,
    ativo boolean not null default true,

    primary key(id)
);

create table turma (
   id bigserial not null,
   nome_turma varchar(70) not null,
   turno varchar(10) not null,
   ano integer not null, -- Postgres não possui tipo YEAR, utiliza-se integer
   semestre smallint,    -- smallint substitui o tinyint para valores pequenos
   ativo boolean not null default true,

   primary key(id)
);

-- POR SER UMA RELAÇÃO N PARA MUITOS, GERA UMA TABELA ASSOCIATIVA

create table matricula (
   id bigserial not null,
   aluno_id bigint not null,
   turma_id bigint not null,
   ativo boolean not null default true,

   primary key(id),
   constraint fk_aluno_id foreign key (aluno_id) references aluno (id),
   constraint fk_turma foreign key (turma_id) references turma (id),
   constraint uk_matricula unique (aluno_id, turma_id) -- FAZ COM QUE NÃO TENHA REPETICAO DE UM MESMO ALUNO NA TURMA
);