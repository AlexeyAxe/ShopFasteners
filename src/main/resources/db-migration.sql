create sequence fasteners_id_fasteners_seq
    as integer;

alter sequence fasteners_id_fasteners_seq owner to postgres;

create sequence brand_id_brand_seq
    as integer;

alter sequence brand_id_brand_seq owner to postgres;

create sequence orders_id_order_seq
    as integer;

alter sequence orders_id_order_seq owner to postgres;

create table "User"
(
    first_name varchar(10) not null,
    last_name  varchar(20) not null,
    id_user    serial
        constraint user_pk
            primary key
        constraint user_pk_2
            unique,
    email      varchar(30) not null
        constraint user_pk_e
            unique
);

alter table "User"
    owner to postgres;

create table "Fastener"
(
    id_fasteners integer default nextval('fasteners.fasteners_id_fasteners_seq'::regclass) not null
        constraint fasteners_pk
            primary key,
    name         varchar(20)                                                               not null,
    price        numeric                                                                   not null
);

alter table "Fastener"
    owner to postgres;

alter sequence fasteners_id_fasteners_seq owned by "Fastener".id_fasteners;

create table "Brand"
(
    id_brand   integer default nextval('fasteners.brand_id_brand_seq'::regclass) not null
        constraint brand_pk
            primary key,
    brand_name varchar(10)                                                       not null
);

alter table "Brand"
    owner to postgres;

alter sequence brand_id_brand_seq owned by "Brand".id_brand;

create table "Order"
(
    id_order   integer default nextval('fasteners.orders_id_order_seq'::regclass) not null
        constraint orders_pk
            primary key,
    date_order date                                                               not null,
    status     varchar(14)                                                        not null,
    id_user    integer                                                            not null
        constraint orders_user_id_user_fk
            references "User"
);

alter table "Order"
    owner to postgres;

alter sequence orders_id_order_seq owned by "Order".id_order;

create table fastenerbrand
(
    id_fastener integer not null
        constraint fastenerbrand_fastener_id_fasteners_fk
            references "Fastener",
    id_brand    integer not null
        constraint fastenerbrand_brand_id_brand_fk
            references "Brand",
    constraint fastenerbrand_pk
        primary key (id_fastener, id_brand)
);

alter table fastenerbrand
    owner to postgres;

