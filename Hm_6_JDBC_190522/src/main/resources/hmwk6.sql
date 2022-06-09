CREATE TABLE public.movie (
                              id integer GENERATED ALWAYS AS identity
                                  CONSTRAINT movie_pk PRIMARY KEY,
                              "name" varchar(255) NOT null,
                              description varchar(2000) NOT null
);

CREATE TABLE public.hall (
                             id integer GENERATED ALWAYS AS identity
                                 CONSTRAINT hall_pk PRIMARY KEY,
                             name varchar(255) NOT null
);

CREATE TABLE public."show" (
                               id integer GENERATED ALWAYS AS identity
                                   CONSTRAINT show_pk PRIMARY KEY,
                               movie_id integer not null constraint movie_fk references public.movie(id),
                               "time" date not NULL
);


create table row (
                     id integer generated always as identity
                         constraint row_pk primary key,
                     number smallint NOT null,
                     hall_id integer not null constraint hall_fk references public.hall(id),
                     unique (NUMBER, HALL_ID)
);

create table public.place (
                              id integer generated always as identity
                                  constraint place_pk primary key,
                              number smallint Not null,
                              row_id integer not null constraint row_fk references public.row(id)
);


CREATE TABLE public.ticket (
                               id integer GENERATED ALWAYS AS identity
                                   CONSTRAINT ticket_pk PRIMARY KEY,
                               show_id integer not null constraint show_fk references public.show(id),
                               place_id integer not null constraint place_fk references public.place(id),
                               cost integer not null,
                               sold boolean not null default false,
                               unique (show_id, place_id)
);

create table usr(
                    id integer GENERATED ALWAYS AS identity
                        CONSTRAINT user_pk PRIMARY KEY,
                    name varchar(255) NOT null,
                    email varchar(255) NOT null
);

create table user_ticket(
                            user_id integer not null constraint user_fk references usr(id) on delete cascade,
                            ticket_id integer not null constraint ticet_fk references ticket(id),
                            primary key (user_id, ticket_id),
                            unique (ticket_id)
);

create table vip_user(
                         id integer GENERATED ALWAYS AS identity
                             CONSTRAINT vip_user_pk PRIMARY KEY,
                         user_id integer not null unique constraint user_fk references usr(id),
                         discount integer not null
);

INSERT INTO public.hall ("name") VALUES('Зал 1');
INSERT INTO public.hall ("name") VALUES('Зал 2');
INSERT INTO public.hall ("name") VALUES('Зал 3');


INSERT INTO public."row" ("number", hall_id) VALUES(1, 1);
INSERT INTO public."row" ("number", hall_id) VALUES(2, 1);
INSERT INTO public."row" ("number", hall_id) VALUES(3, 1);
INSERT INTO public."row" ("number", hall_id) VALUES(4, 1);
INSERT INTO public."row" ("number", hall_id) VALUES(5, 1);
INSERT INTO public."row" ("number", hall_id) VALUES(6, 1);

INSERT INTO public."row" ("number", hall_id) VALUES(1, 2);
INSERT INTO public."row" ("number", hall_id) VALUES(2, 2);
INSERT INTO public."row" ("number", hall_id) VALUES(3, 2);
INSERT INTO public."row" ("number", hall_id) VALUES(4, 2);
INSERT INTO public."row" ("number", hall_id) VALUES(5, 2);


INSERT INTO public."row" ("number", hall_id) VALUES(1, 3);
INSERT INTO public."row" ("number", hall_id) VALUES(2, 3);
INSERT INTO public."row" ("number", hall_id) VALUES(3, 3);


INSERT INTO public.place ("number", row_id) VALUES(1, 1);
INSERT INTO public.place ("number", row_id) VALUES(2, 1);
INSERT INTO public.place ("number", row_id) VALUES(3, 1);
INSERT INTO public.place ("number", row_id) VALUES(4, 1);
INSERT INTO public.place ("number", row_id) VALUES(5, 1);
INSERT INTO public.place ("number", row_id) VALUES(6, 1);
INSERT INTO public.place ("number", row_id) VALUES(7, 1);
INSERT INTO public.place ("number", row_id) VALUES(8, 1);

INSERT INTO public.place ("number", row_id) VALUES(1, 2);
INSERT INTO public.place ("number", row_id) VALUES(2, 2);
INSERT INTO public.place ("number", row_id) VALUES(3, 2);
INSERT INTO public.place ("number", row_id) VALUES(4, 2);
INSERT INTO public.place ("number", row_id) VALUES(5, 2);
INSERT INTO public.place ("number", row_id) VALUES(6, 2);
INSERT INTO public.place ("number", row_id) VALUES(7, 2);
INSERT INTO public.place ("number", row_id) VALUES(8, 2);

INSERT INTO public.place ("number", row_id) VALUES(1, 3);
INSERT INTO public.place ("number", row_id) VALUES(2, 3);
INSERT INTO public.place ("number", row_id) VALUES(3, 3);
INSERT INTO public.place ("number", row_id) VALUES(4, 3);
INSERT INTO public.place ("number", row_id) VALUES(5, 3);
INSERT INTO public.place ("number", row_id) VALUES(6, 3);
INSERT INTO public.place ("number", row_id) VALUES(7, 3);
INSERT INTO public.place ("number", row_id) VALUES(8, 3);

INSERT INTO public.place ("number", row_id) VALUES(1, 4);
INSERT INTO public.place ("number", row_id) VALUES(2, 4);
INSERT INTO public.place ("number", row_id) VALUES(3, 4);
INSERT INTO public.place ("number", row_id) VALUES(4, 4);
INSERT INTO public.place ("number", row_id) VALUES(5, 4);
INSERT INTO public.place ("number", row_id) VALUES(6, 4);
INSERT INTO public.place ("number", row_id) VALUES(7, 4);
INSERT INTO public.place ("number", row_id) VALUES(8, 4);

INSERT INTO public.place ("number", row_id) VALUES(1, 5);
INSERT INTO public.place ("number", row_id) VALUES(2, 5);
INSERT INTO public.place ("number", row_id) VALUES(3, 5);
INSERT INTO public.place ("number", row_id) VALUES(4, 5);
INSERT INTO public.place ("number", row_id) VALUES(5, 5);
INSERT INTO public.place ("number", row_id) VALUES(6, 5);
INSERT INTO public.place ("number", row_id) VALUES(7, 5);
INSERT INTO public.place ("number", row_id) VALUES(8, 5);

INSERT INTO public.place ("number", row_id) VALUES(1, 6);
INSERT INTO public.place ("number", row_id) VALUES(2, 6);
INSERT INTO public.place ("number", row_id) VALUES(3, 6);
INSERT INTO public.place ("number", row_id) VALUES(4, 6);
INSERT INTO public.place ("number", row_id) VALUES(5, 6);
INSERT INTO public.place ("number", row_id) VALUES(6, 6);
INSERT INTO public.place ("number", row_id) VALUES(7, 6);
INSERT INTO public.place ("number", row_id) VALUES(8, 6);

-----------------------------------------------------------

INSERT INTO public.place ("number", row_id) VALUES(1, 6);
INSERT INTO public.place ("number", row_id) VALUES(2, 6);
INSERT INTO public.place ("number", row_id) VALUES(3, 6);
INSERT INTO public.place ("number", row_id) VALUES(4, 6);
INSERT INTO public.place ("number", row_id) VALUES(5, 6);
INSERT INTO public.place ("number", row_id) VALUES(6, 6);
INSERT INTO public.place ("number", row_id) VALUES(7, 6);
INSERT INTO public.place ("number", row_id) VALUES(8, 6);

INSERT INTO public.place ("number", row_id) VALUES(1, 7);
INSERT INTO public.place ("number", row_id) VALUES(2, 7);
INSERT INTO public.place ("number", row_id) VALUES(3, 7);
INSERT INTO public.place ("number", row_id) VALUES(4, 7);
INSERT INTO public.place ("number", row_id) VALUES(5, 7);
INSERT INTO public.place ("number", row_id) VALUES(6, 7);
INSERT INTO public.place ("number", row_id) VALUES(7, 7);
INSERT INTO public.place ("number", row_id) VALUES(8, 7);

INSERT INTO public.place ("number", row_id) VALUES(1, 8);
INSERT INTO public.place ("number", row_id) VALUES(2, 8);
INSERT INTO public.place ("number", row_id) VALUES(3, 8);
INSERT INTO public.place ("number", row_id) VALUES(4, 8);
INSERT INTO public.place ("number", row_id) VALUES(5, 8);
INSERT INTO public.place ("number", row_id) VALUES(6, 8);
INSERT INTO public.place ("number", row_id) VALUES(7, 8);
INSERT INTO public.place ("number", row_id) VALUES(8, 8);

INSERT INTO public.place ("number", row_id) VALUES(1, 9);
INSERT INTO public.place ("number", row_id) VALUES(2, 9);
INSERT INTO public.place ("number", row_id) VALUES(3, 9);
INSERT INTO public.place ("number", row_id) VALUES(4, 9);
INSERT INTO public.place ("number", row_id) VALUES(5, 9);
INSERT INTO public.place ("number", row_id) VALUES(6, 9);
INSERT INTO public.place ("number", row_id) VALUES(7, 9);
INSERT INTO public.place ("number", row_id) VALUES(8, 9);

INSERT INTO public.place ("number", row_id) VALUES(1, 10);
INSERT INTO public.place ("number", row_id) VALUES(2, 10);
INSERT INTO public.place ("number", row_id) VALUES(3, 10);
INSERT INTO public.place ("number", row_id) VALUES(4, 10);
INSERT INTO public.place ("number", row_id) VALUES(5, 10);
INSERT INTO public.place ("number", row_id) VALUES(6, 10);
INSERT INTO public.place ("number", row_id) VALUES(7, 10);
INSERT INTO public.place ("number", row_id) VALUES(8, 10);
---------------------------------------------------------

INSERT INTO public.place ("number", row_id) VALUES(1, 11);
INSERT INTO public.place ("number", row_id) VALUES(2, 11);
INSERT INTO public.place ("number", row_id) VALUES(3, 11);
INSERT INTO public.place ("number", row_id) VALUES(4, 11);
INSERT INTO public.place ("number", row_id) VALUES(5, 11);
INSERT INTO public.place ("number", row_id) VALUES(6, 11);


INSERT INTO public.place ("number", row_id) VALUES(1, 12);
INSERT INTO public.place ("number", row_id) VALUES(2, 12);
INSERT INTO public.place ("number", row_id) VALUES(3, 12);
INSERT INTO public.place ("number", row_id) VALUES(4, 12);
INSERT INTO public.place ("number", row_id) VALUES(5, 12);
INSERT INTO public.place ("number", row_id) VALUES(6, 12);


INSERT INTO public.place ("number", row_id) VALUES(1, 13);
INSERT INTO public.place ("number", row_id) VALUES(2, 13);
INSERT INTO public.place ("number", row_id) VALUES(3, 13);
INSERT INTO public.place ("number", row_id) VALUES(4, 13);
INSERT INTO public.place ("number", row_id) VALUES(5, 13);
INSERT INTO public.place ("number", row_id) VALUES(6, 13);
--


INSERT INTO public.usr (name, email) VALUES('Антон', '111@mail.ru');
INSERT INTO public.usr (name, email) VALUES('Владимир', '222@mail.ru');
INSERT INTO public.usr (name, email) VALUES('Федор', '333@mail.ru');
INSERT INTO public.usr (name, email) VALUES('Максим', '444@mail.ru');
INSERT INTO public.usr (name, email) VALUES('Евгений', '555@mail.ru');


INSERT INTO public.movie ("name", description)  values ('Побег из Шоушенка',  '1994	Фрэнк Дарабонт	драма');
INSERT INTO public.movie ("name", description)  values ('Крёстный отец',  '1972	Фрэнсис Форд Коппола	детектив, драма');
INSERT INTO public.movie ("name", description)  values ('Крёстный отец 2',  '1974	Фрэнсис Форд Коппола	детектив, драма');
INSERT INTO public.movie ("name", description)  values ('Тёмный рыцарь',  '2008	Кристофер Нолан	боевик, детектив, драма');
INSERT INTO public.movie ("name", description)  values ('12 разгневанных мужчин',  '1957	Сидни Люмет	драма, детектив');
INSERT INTO public.movie ("name", description)  values ('Список Шиндлера',  '1993	Стивен Спилберг	драма, биография, исторический фильм');
INSERT INTO public.movie ("name", description)  values ('Властелин колец: Возвращение короля',	  '2003	Питер Джексон	фэнтези, приключение, боевик');
INSERT INTO public.movie ("name", description)  values ('Криминальное чтиво',  '1994	Квентин Тарантино	чёрная комедия, драма');
INSERT INTO public.movie ("name", description)  values ('Властелин колец: Братство Кольцо',  '2001	Питер Джексон	фэнтези, приключение, боевик');
INSERT INTO public.movie ("name", description)  values ('Хороший, плохой, злой',  '1966	Серджо Леоне	приключение, вестерн');

INSERT INTO public."show" (movie_id, "time") VALUES(1, '2022-05-22 10:00:00.000');
INSERT INTO public."show" (movie_id, "time") VALUES(1, '2022-05-22 12:00:00.000');
INSERT INTO public."show" (movie_id, "time") VALUES(1, '2022-05-22 16:00:00.000');

INSERT INTO public."show" (movie_id, "time") VALUES(2, '2022-05-22 10:00:00.000');
INSERT INTO public."show" (movie_id, "time") VALUES(2, '2022-05-22 12:00:00.000');
INSERT INTO public."show" (movie_id, "time") VALUES(2, '2022-05-22 16:00:00.000');

INSERT INTO public."show" (movie_id, "time") VALUES(3, '2022-05-22 10:00:00.000');
INSERT INTO public."show" (movie_id, "time") VALUES(3, '2022-05-22 12:00:00.000');
INSERT INTO public."show" (movie_id, "time") VALUES(4, '2022-05-22 16:00:00.000');


INSERT INTO public.ticket (show_id, place_id, cost, sold) VALUES(1, 2, 100, true);
INSERT INTO public.ticket (show_id, place_id, cost, sold) VALUES(1, 3, 100, true);
INSERT INTO public.ticket (show_id, place_id, cost, sold) VALUES(1, 4, 100, true);
INSERT INTO public.ticket (show_id, place_id, cost, sold) VALUES(1, 5, 100, true);

INSERT INTO public.user_ticket (user_id, ticket_id) VALUES(1, 3);
INSERT INTO public.user_ticket (user_id, ticket_id) VALUES(2, 2);
INSERT INTO public.user_ticket (user_id, ticket_id) VALUES(3, 1);
INSERT INTO public.user_ticket (user_id, ticket_id) VALUES(1, 4);
