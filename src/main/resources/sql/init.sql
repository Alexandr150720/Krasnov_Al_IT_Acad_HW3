CREATE SCHEMA IF NOT EXISTS vote_app
    AUTHORIZATION postgres;

//таблица жанров
CREATE TABLE IF NOT EXISTS vote_app.genre
(
    genre_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    votes_count integer NOT NULL DEFAULT 0,
    CONSTRAINT genre_pkey PRIMARY KEY (genre_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS vote_app.genre
    OWNER to postgres;

//таблица исполнителей
CREATE TABLE IF NOT EXISTS vote_app.performer
(
    perf_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    votes_count integer NOT NULL DEFAULT 0,
    CONSTRAINT performer_pkey PRIMARY KEY (perf_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS vote_app.performer
    OWNER to postgres;

//таблица голосов
CREATE TABLE IF NOT EXISTS vote_app.vote
(
    vote_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    created_at timestamp(6) without time zone NOT NULL,
    about text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vote_pkey PRIMARY KEY (vote_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS vote_app.vote
    OWNER to postgres;