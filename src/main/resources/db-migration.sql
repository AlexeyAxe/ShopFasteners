CREATE SCHEMA fasteners

    create table if not exists fasteners.fastener (
    id_fastener serial primary key,
    name_fastener varchar(20) not null unique
    );

create table if not exists fasteners.brand (
                                               id_brand        serial     primary key,
                                               name_brand       varchar(10) not null
    );

create table if not exists fasteners.user (
                                              id_user  serial      primary key,
                                              first_name   varchar(10) not null,
    last_name   varchar(20) not null,
    email   varchar(30) not null
    );
create table if not exists fasteners.order (
                                               id_order        serial     primary key,
                                               date_order      date not null,
                                               status          varchar(14) not null,
    quantity        integer not null,
    id_user   serial references fasteners.user (id_user),
    id_fastener serial references fasteners.fastener (id_fastener)
    );

create table fasteners.fastener_brand (
                                          id_fastener integer not null references fasteners.fastener (id_fastener),
                                          id_brand   integer not null references fasteners.brand(id_brand),
                                          primary key (id_fastener, id_brand)
);

insert into fasteners.fastener (name_fastener)
values ('anchor'),
       ('dowel'),
       ('rivet'),
       ('bolt'),
       ('nut'),
       ('nail');

insert into fasteners.brand (name_brand)
values ('Hilti'),
       ('Fischer'),
       ('Bosch'),
       ('Sormat');

insert into fasteners.user (first_name, last_name, email)
values ('Varvara', 'Vinogradova', 'varv_emo25@hotmail.com'),
       ('Dmitry', 'Vysotsky', 'relex-uyine17@bk.ru'),
       ('Alexander', 'Grigoriev', 'mus_epuvido43@list.ru'),
       ('Daniil', 'Lukyanov', 'rubil-ojepa35@yandex.ru'),
       ('Ivan', 'Mikhailov', 'lumo_didopo26@inbox.ru'),
       ('Sofia', 'Petukhova', 'row-utewofa32@inbox.ru');

insert into fasteners.order (date_order, status, quantity, id_user, id_fastener)
values ('2024-04-18', 'PLACED', 10, 6, 1),
       ('2024-04-16', 'PLACED', 100, 3, 3),
       ('2024-04-16', 'PAID', 42, 4, 2),
       ('2024-04-14', 'COMPLETED', 11, 5, 1),
       ('2024-04-11', 'CANCELED', 35, 6, 3),
       ('2024-04-09', 'COMPLETED', 13, 2, 4),
       ('2024-04-08', 'COMPLETED', 50, 1, 4),
       ('2024-04-08', 'COMPLETED', 13, 2, 5);

insert into fasteners.fastener_brand (id_fastener, id_brand)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 4),
       (3, 1),
       (3, 2),
       (3, 3),
       (3, 4),
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 4),
       (5, 1),
       (5, 2),
       (5, 3),
       (5, 4),
       (6, 1),
       (6, 2),
       (6, 3),
       (6, 4);