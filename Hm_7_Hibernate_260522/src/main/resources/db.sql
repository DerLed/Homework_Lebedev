DROP TABLE if EXISTS public.hall CASCADE;
DROP table if EXISTS public.sector CASCADE;
DROP TABLE if EXISTS public.movie CASCADE;
DROP TABLE if EXISTS public.place CASCADE;
DROP TABLE if EXISTS public."row" CASCADE;
DROP TABLE if EXISTS public."show" CASCADE;
DROP TABLE if EXISTS public.ticket CASCADE;
DROP TABLE if EXISTS public.usr CASCADE;
DROP TABLE if EXISTS public.vip_user CASCADE;
DROP table if EXISTS public.ticket_status CASCADE;



CREATE TABLE public.movie
(
    id          serial
        constraint movie_pk
            primary key,
    title       varchar(255)  NOT null,
    description varchar(2000) NOT null,
    duration    integer       not null
);

COMMENT ON COLUMN public.movie.duration IS 'minute';

CREATE TABLE public.hall
(
    id   integer GENERATED ALWAYS AS identity
        CONSTRAINT hall_pk PRIMARY KEY,
    name varchar(255) NOT null
);

CREATE TABLE public."show"
(
    id         serial
        constraint show_pk
            primary key,
    movie_id   integer   not null
        constraint movie_fk references public.movie (id),
    time_start timestamp not NULL
);


create table public."row"
(
    id      integer generated always as identity
        constraint row_pk primary key,
    number  smallint NOT null,
    hall_id integer  not null
        constraint hall_fk references public.hall (id),
    unique (NUMBER, HALL_ID)
);

CREATE TABLE public.sector
(
    id           integer NOT NULL GENERATED ALWAYS AS identity
        CONSTRAINT sector_pk PRIMARY KEY,
    sector_title varchar not null
);

create table public.place
(
    id        integer generated always as identity
        constraint place_pk primary key,
    number    smallint Not null,
    row_id    integer  not null
        constraint row_fk references public."row" (id),
    sector_id integer
        constraint sector_fk references public.sector (id)
);

create table public.usr
(
    id    integer GENERATED ALWAYS AS identity
        CONSTRAINT user_pk PRIMARY KEY,
    name  varchar(255) NOT null,
    email varchar(255) NOT null
);

CREATE TABLE public.ticket_status
(
    id            integer NOT NULL GENERATED ALWAYS AS identity
        CONSTRAINT ticket_status_pk PRIMARY KEY,
    ticket_status varchar NOT NULL
);



CREATE TABLE public.ticket
(
    id               integer GENERATED ALWAYS AS identity
        CONSTRAINT ticket_pk PRIMARY KEY,
    show_id          integer not null
        constraint show_fk references public.show (id),
    place_id         integer not null
        constraint place_fk references public.place (id),
    user_id          integer
        constraint user_fk references usr (id),
    ticket_status_id integer not null
        constraint ticket_status_fk references ticket_status (id),
    cost             integer not null,
    unique (show_id, place_id)
);



--create table user_ticket
--(
--    user_id   integer not null
--        constraint user_fk references usr (id) on delete cascade,
--    ticket_id integer not null
--        constraint ticet_fk references ticket (id),
--    primary key (user_id, ticket_id),
--    unique (ticket_id)
--);

create table vip_user
(
    id       integer GENERATED ALWAYS AS identity
        CONSTRAINT vip_user_pk PRIMARY KEY,
    user_id  integer not null unique
        constraint user_fk references usr (id),
    discount integer not null
);

INSERT INTO public.hall ("name")
VALUES ('?????? 1');
INSERT INTO public.hall ("name")
VALUES ('?????? 2');
INSERT INTO public.hall ("name")
VALUES ('?????? 3');


INSERT INTO public."row" ("number", hall_id)
VALUES (1, 1);
INSERT INTO public."row" ("number", hall_id)
VALUES (2, 1);
INSERT INTO public."row" ("number", hall_id)
VALUES (3, 1);
INSERT INTO public."row" ("number", hall_id)
VALUES (4, 1);
INSERT INTO public."row" ("number", hall_id)
VALUES (5, 1);
INSERT INTO public."row" ("number", hall_id)
VALUES (6, 1);

INSERT INTO public."row" ("number", hall_id)
VALUES (1, 2);
INSERT INTO public."row" ("number", hall_id)
VALUES (2, 2);
INSERT INTO public."row" ("number", hall_id)
VALUES (3, 2);
INSERT INTO public."row" ("number", hall_id)
VALUES (4, 2);
INSERT INTO public."row" ("number", hall_id)
VALUES (5, 2);


INSERT INTO public."row" ("number", hall_id)
VALUES (1, 3);
INSERT INTO public."row" ("number", hall_id)
VALUES (2, 3);
INSERT INTO public."row" ("number", hall_id)
VALUES (3, 3);


INSERT INTO public.place ("number", row_id)
VALUES (1, 1);
INSERT INTO public.place ("number", row_id)
VALUES (2, 1);
INSERT INTO public.place ("number", row_id)
VALUES (3, 1);
INSERT INTO public.place ("number", row_id)
VALUES (4, 1);
INSERT INTO public.place ("number", row_id)
VALUES (5, 1);
INSERT INTO public.place ("number", row_id)
VALUES (6, 1);
INSERT INTO public.place ("number", row_id)
VALUES (7, 1);
INSERT INTO public.place ("number", row_id)
VALUES (8, 1);

INSERT INTO public.place ("number", row_id)
VALUES (1, 2);
INSERT INTO public.place ("number", row_id)
VALUES (2, 2);
INSERT INTO public.place ("number", row_id)
VALUES (3, 2);
INSERT INTO public.place ("number", row_id)
VALUES (4, 2);
INSERT INTO public.place ("number", row_id)
VALUES (5, 2);
INSERT INTO public.place ("number", row_id)
VALUES (6, 2);
INSERT INTO public.place ("number", row_id)
VALUES (7, 2);
INSERT INTO public.place ("number", row_id)
VALUES (8, 2);

INSERT INTO public.place ("number", row_id)
VALUES (1, 3);
INSERT INTO public.place ("number", row_id)
VALUES (2, 3);
INSERT INTO public.place ("number", row_id)
VALUES (3, 3);
INSERT INTO public.place ("number", row_id)
VALUES (4, 3);
INSERT INTO public.place ("number", row_id)
VALUES (5, 3);
INSERT INTO public.place ("number", row_id)
VALUES (6, 3);
INSERT INTO public.place ("number", row_id)
VALUES (7, 3);
INSERT INTO public.place ("number", row_id)
VALUES (8, 3);

INSERT INTO public.place ("number", row_id)
VALUES (1, 4);
INSERT INTO public.place ("number", row_id)
VALUES (2, 4);
INSERT INTO public.place ("number", row_id)
VALUES (3, 4);
INSERT INTO public.place ("number", row_id)
VALUES (4, 4);
INSERT INTO public.place ("number", row_id)
VALUES (5, 4);
INSERT INTO public.place ("number", row_id)
VALUES (6, 4);
INSERT INTO public.place ("number", row_id)
VALUES (7, 4);
INSERT INTO public.place ("number", row_id)
VALUES (8, 4);

INSERT INTO public.place ("number", row_id)
VALUES (1, 5);
INSERT INTO public.place ("number", row_id)
VALUES (2, 5);
INSERT INTO public.place ("number", row_id)
VALUES (3, 5);
INSERT INTO public.place ("number", row_id)
VALUES (4, 5);
INSERT INTO public.place ("number", row_id)
VALUES (5, 5);
INSERT INTO public.place ("number", row_id)
VALUES (6, 5);
INSERT INTO public.place ("number", row_id)
VALUES (7, 5);
INSERT INTO public.place ("number", row_id)
VALUES (8, 5);

INSERT INTO public.place ("number", row_id)
VALUES (1, 6);
INSERT INTO public.place ("number", row_id)
VALUES (2, 6);
INSERT INTO public.place ("number", row_id)
VALUES (3, 6);
INSERT INTO public.place ("number", row_id)
VALUES (4, 6);
INSERT INTO public.place ("number", row_id)
VALUES (5, 6);
INSERT INTO public.place ("number", row_id)
VALUES (6, 6);
INSERT INTO public.place ("number", row_id)
VALUES (7, 6);
INSERT INTO public.place ("number", row_id)
VALUES (8, 6);

-----------------------------------------------------------

INSERT INTO public.place ("number", row_id)
VALUES (1, 6);
INSERT INTO public.place ("number", row_id)
VALUES (2, 6);
INSERT INTO public.place ("number", row_id)
VALUES (3, 6);
INSERT INTO public.place ("number", row_id)
VALUES (4, 6);
INSERT INTO public.place ("number", row_id)
VALUES (5, 6);
INSERT INTO public.place ("number", row_id)
VALUES (6, 6);
INSERT INTO public.place ("number", row_id)
VALUES (7, 6);
INSERT INTO public.place ("number", row_id)
VALUES (8, 6);

INSERT INTO public.place ("number", row_id)
VALUES (1, 7);
INSERT INTO public.place ("number", row_id)
VALUES (2, 7);
INSERT INTO public.place ("number", row_id)
VALUES (3, 7);
INSERT INTO public.place ("number", row_id)
VALUES (4, 7);
INSERT INTO public.place ("number", row_id)
VALUES (5, 7);
INSERT INTO public.place ("number", row_id)
VALUES (6, 7);
INSERT INTO public.place ("number", row_id)
VALUES (7, 7);
INSERT INTO public.place ("number", row_id)
VALUES (8, 7);

INSERT INTO public.place ("number", row_id)
VALUES (1, 8);
INSERT INTO public.place ("number", row_id)
VALUES (2, 8);
INSERT INTO public.place ("number", row_id)
VALUES (3, 8);
INSERT INTO public.place ("number", row_id)
VALUES (4, 8);
INSERT INTO public.place ("number", row_id)
VALUES (5, 8);
INSERT INTO public.place ("number", row_id)
VALUES (6, 8);
INSERT INTO public.place ("number", row_id)
VALUES (7, 8);
INSERT INTO public.place ("number", row_id)
VALUES (8, 8);

INSERT INTO public.place ("number", row_id)
VALUES (1, 9);
INSERT INTO public.place ("number", row_id)
VALUES (2, 9);
INSERT INTO public.place ("number", row_id)
VALUES (3, 9);
INSERT INTO public.place ("number", row_id)
VALUES (4, 9);
INSERT INTO public.place ("number", row_id)
VALUES (5, 9);
INSERT INTO public.place ("number", row_id)
VALUES (6, 9);
INSERT INTO public.place ("number", row_id)
VALUES (7, 9);
INSERT INTO public.place ("number", row_id)
VALUES (8, 9);

INSERT INTO public.place ("number", row_id)
VALUES (1, 10);
INSERT INTO public.place ("number", row_id)
VALUES (2, 10);
INSERT INTO public.place ("number", row_id)
VALUES (3, 10);
INSERT INTO public.place ("number", row_id)
VALUES (4, 10);
INSERT INTO public.place ("number", row_id)
VALUES (5, 10);
INSERT INTO public.place ("number", row_id)
VALUES (6, 10);
INSERT INTO public.place ("number", row_id)
VALUES (7, 10);
INSERT INTO public.place ("number", row_id)
VALUES (8, 10);
---------------------------------------------------------

INSERT INTO public.place ("number", row_id)
VALUES (1, 11);
INSERT INTO public.place ("number", row_id)
VALUES (2, 11);
INSERT INTO public.place ("number", row_id)
VALUES (3, 11);
INSERT INTO public.place ("number", row_id)
VALUES (4, 11);
INSERT INTO public.place ("number", row_id)
VALUES (5, 11);
INSERT INTO public.place ("number", row_id)
VALUES (6, 11);


INSERT INTO public.place ("number", row_id)
VALUES (1, 12);
INSERT INTO public.place ("number", row_id)
VALUES (2, 12);
INSERT INTO public.place ("number", row_id)
VALUES (3, 12);
INSERT INTO public.place ("number", row_id)
VALUES (4, 12);
INSERT INTO public.place ("number", row_id)
VALUES (5, 12);
INSERT INTO public.place ("number", row_id)
VALUES (6, 12);


INSERT INTO public.place ("number", row_id)
VALUES (1, 13);
INSERT INTO public.place ("number", row_id)
VALUES (2, 13);
INSERT INTO public.place ("number", row_id)
VALUES (3, 13);
INSERT INTO public.place ("number", row_id)
VALUES (4, 13);
INSERT INTO public.place ("number", row_id)
VALUES (5, 13);
INSERT INTO public.place ("number", row_id)
VALUES (6, 13);
--


INSERT INTO public."usr" (name, email)
VALUES ('??????????', '111@mail.ru');
INSERT INTO public.usr (name, email)
VALUES ('????????????????', '222@mail.ru');
INSERT INTO public.usr (name, email)
VALUES ('??????????', '333@mail.ru');
INSERT INTO public.usr (name, email)
VALUES ('????????????', '444@mail.ru');
INSERT INTO public.usr (name, email)
VALUES ('??????????????', '555@mail.ru');


INSERT INTO public.movie (title, description, duration)
values ('?????????? ???? ????????????????', '1994	?????????? ????????????????	??????????', 142);
INSERT INTO public.movie (title, description, duration)
values ('???????????????? ????????', '1972	?????????????? ???????? ??????????????	????????????????, ??????????', 175);
INSERT INTO public.movie (title, description, duration)
values ('???????????????? ???????? 2', '1974	?????????????? ???????? ??????????????	????????????????, ??????????', 202);
INSERT INTO public.movie (title, description, duration)
values ('???????????? ????????????', '2008	?????????????????? ??????????	????????????, ????????????????, ??????????', 152);
INSERT INTO public.movie (title, description, duration)
values ('12 ???????????????????????? ????????????', '1957	?????????? ??????????	??????????, ????????????????', 130);
INSERT INTO public.movie (title, description, duration)
values ('???????????? ????????????????', '1993	???????????? ????????????????	??????????, ??????????????????, ???????????????????????? ??????????', 130);
INSERT INTO public.movie (title, description, duration)
values ('?????????????????? ??????????: ?????????????????????? ????????????', '2003	?????????? ??????????????	??????????????, ??????????????????????, ????????????', 130);
INSERT INTO public.movie (title, description, duration)
values ('???????????????????????? ??????????', '1994	?????????????? ??????????????????	???????????? ??????????????, ??????????', 90);
INSERT INTO public.movie (title, description, duration)
values ('?????????????????? ??????????: ???????????????? ????????????', '2001	?????????? ??????????????	??????????????, ??????????????????????, ????????????', 90);
INSERT INTO public.movie (title, description, duration)
values ('??????????????, ????????????, ????????', '1966	???????????? ??????????	??????????????????????, ??????????????', 90);

INSERT INTO public."show" (movie_id, time_start)
VALUES (1, '2022-05-22 10:00:00.000');
INSERT INTO public."show" (movie_id, time_start)
VALUES (1, '2022-05-22 12:00:00.000');
INSERT INTO public."show" (movie_id, time_start)
VALUES (1, '2022-05-22 16:00:00.000');

INSERT INTO public."show" (movie_id, time_start)
VALUES (2, '2022-05-22 10:00:00.000');
INSERT INTO public."show" (movie_id, time_start)
VALUES (2, '2022-05-22 12:00:00.000');
INSERT INTO public."show" (movie_id, time_start)
VALUES (2, '2022-05-22 16:00:00.000');

INSERT INTO public."show" (movie_id, time_start)
VALUES (3, '2022-05-22 10:00:00.000');
INSERT INTO public."show" (movie_id, time_start)
VALUES (3, '2022-05-22 12:00:00.000');
INSERT INTO public."show" (movie_id, time_start)
VALUES (4, '2022-05-22 16:00:00.000');


INSERT INTO public.ticket_status (ticket_status)
VALUES ('ON_SALE');
INSERT INTO public.ticket_status (ticket_status)
VALUES ('SOLD');
INSERT INTO public.ticket_status (ticket_status)
VALUES ('CANCELLED');
INSERT INTO public.ticket_status (ticket_status)
VALUES ('BOOKING');
INSERT INTO public.ticket_status (ticket_status)
VALUES ('EXPIRED');
INSERT INTO public.ticket_status (ticket_status)
VALUES ('USED');

INSERT INTO public.ticket (show_id, place_id, cost, ticket_status_id)
VALUES (1, 2, 100, 1);
INSERT INTO public.ticket (show_id, place_id, cost, ticket_status_id)
VALUES (1, 3, 100, 1);
INSERT INTO public.ticket (show_id, place_id, cost, ticket_status_id)
VALUES (1, 4, 100, 1);
INSERT INTO public.ticket (show_id, place_id, cost, ticket_status_id)
VALUES (1, 5, 100, 1);

CREATE TABLE public.genre
(
    id         serial
        constraint show_pk
            primary key,
    "name" varchar(64) not NULL
);

create table public.genre_movie
(
    movie_id integer not null
        constraint movie_fk references movie (id),
    genre_id integer not null
        constraint genre_fk references genre (id),
    primary key (movie_id, genre_id)
);


Insert into public.genre (name)
VALUES ('??????????');
Insert into public.genre (name)
VALUES ('????????????????????????????');
Insert into public.genre (name)
VALUES ('????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('????????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('????????????????????????????');
Insert into public.genre (name)
VALUES ('??????????');
Insert into public.genre (name)
VALUES ('????????????????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('????????????????????????????????');
Insert into public.genre (name)
VALUES ('????????????????');
Insert into public.genre (name)
VALUES ('??????????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('????????????');
Insert into public.genre (name)
VALUES ('????????????????????');
Insert into public.genre (name)
VALUES ('????????????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('????????');
Insert into public.genre (name)
VALUES ('??????????????????????');
Insert into public.genre (name)
VALUES ('??????????????-??????');
Insert into public.genre (name)
VALUES ('????????????????');
Insert into public.genre (name)
VALUES ('??????????');
Insert into public.genre (name)
VALUES ('??????-??????');
Insert into public.genre (name)
VALUES ('??????????????');
Insert into public.genre (name)
VALUES ('??????????');
Insert into public.genre (name)
VALUES ('????????????????????');
Insert into public.genre (name)
VALUES ('??????????????');


INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (1, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (2, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (2, 6);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (3, 6);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (3, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (4, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (6, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (6, 2);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (6, 10);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (6, 6);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (5, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (7, 29);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (7, 21);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (7, 3);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (8, 9);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (8, 11);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (9, 3);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (9, 29);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (9, 21);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (10, 21);
INSERT INTO public.genre_movie (movie_id, genre_id)
VALUES (10, 4);


--INSERT INTO public.user_ticket (user_id, ticket_id)
--VALUES (1, 3);
--INSERT INTO public.user_ticket (user_id, ticket_id)
--VALUES (2, 2);
--INSERT INTO public.user_ticket (user_id, ticket_id)
--VALUES (3, 1);
--INSERT INTO public.user_ticket (user_id, ticket_id)
--VALUES (1, 4);
select movie0_.id          as id1_2_,
       movie0_.description as descript2_2_,
       movie0_.duration    as duration3_2_,
       movie0_.title       as title4_2_
from movie movie0_
         inner join genre_movie genres1_ on movie0_.id = genres1_.movie_id
         inner join genre genre2_ on genres1_.genre_id = genre2_.id
where genre2_.name like ?