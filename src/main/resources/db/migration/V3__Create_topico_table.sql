create schema if not exists forum;

create table if not exists forum.topico(
    id    bigserial primary key,
    autor_id bigserial not null,
    curso_id bigserial not null,
    titulo  varchar(100) not null,
    mensagem  varchar(100) not null,
    data_criacao  DATE not null,
    status varchar(100),
    CONSTRAINT fk_autor
        FOREIGN KEY(autor_id)
            REFERENCES forum.usuario(id),
    CONSTRAINT fk_curso
        FOREIGN KEY(curso_id)
            REFERENCES forum.curso(id)
);