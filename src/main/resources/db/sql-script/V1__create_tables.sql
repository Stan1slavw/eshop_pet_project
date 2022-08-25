create database eshop;
use.eshop;

create table hibernate_sequence
(
    next_val bigint
) engine=InnoDB;
insert into hibernate_sequence values ( 1 );

create table images
(
    id                 bigint not null,
    bytes              longblob,
    content_type       varchar(255),
    is_preview_image   bit,
    name               varchar(255),
    original_file_name varchar(255),
    size               bigint,
    product_id         bigint,
    primary key (id)
) engine=InnoDB;

create table products
(
    id               bigint not null,
    city             varchar(255),
    date_of_created  datetime(6),
    description      text,
    preview_image_id bigint,
    price            integer,
    title            varchar(255),
    user_id          bigint,
    primary key (id)
) engine=InnoDB;

create table user_role
(
    user_id bigint not null,
    roles   varchar(255)
) engine=InnoDB;

create table users
(
    id              bigint not null auto_increment,
    active          bit,
    date_of_created datetime(6),
    email           varchar(255),
    name            varchar(255),
    password        varchar(1000),
    phone_number    varchar(255),
    image_id        bigint,
    primary key (id)
) engine=InnoDB;


alter table users
    add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
alter table images
    add constraint FKghwsjbjo7mg3iufxruvq6iu3q foreign key (product_id) references products (id);
alter table products
    add constraint FKdb050tk37qryv15hd932626th foreign key (user_id) references users (id);
alter table user_role
    add constraint FKj345gk1bovqvfame88rcx7yyx foreign key (user_id) references users (id);
alter table users
    add constraint FK17herqt2to4hyl5q5r5ogbxk9 foreign key (image_id) references images (id);