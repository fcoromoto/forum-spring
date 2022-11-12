create schema if not exists forum;

create table if not exists forum.resposta(
    id    bigserial primary key,
    topico_id  bigserial,
    autor_id  bigserial,
    solucao bool not null,
    mensagem  varchar(100) not null,
    data_criacao  DATE not null,
    CONSTRAINT fk_autor
        FOREIGN KEY(autor_id)
            REFERENCES forum.usuario(id),
    CONSTRAINT fk_topico
        FOREIGN KEY(topico_id)
            REFERENCES forum.topico(id)
);