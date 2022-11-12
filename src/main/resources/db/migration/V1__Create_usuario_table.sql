create schema if not exists forum;

create table if not exists forum.usuario(
    id    bigserial primary key,
    nome  varchar(100) not null,
    email varchar(100),
    senha varchar(100)
);