create schema if not exists forum;

create table if not exists forum.curso(
    id    bigserial primary key,
    nome  varchar(100) not null,
    categoria varchar(100)
);