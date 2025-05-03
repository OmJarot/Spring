create database belajar_spring_restful_api;

use belajar_spring_restful_api;

create table users(
    username VARCHAR(100) not null ,
    password varchar(100) not null ,
    name varchar(200) not null ,
    token varchar(100),
    token_expired_at BIGINT,
    primary key (username),
    unique (token)
)engine InnoDB;

create table contacts(
    id varchar(100) not null,
    username varchar(100) not null,
    first_name varchar(100) not null,
    last_name varchar(100),
    phone varchar(100),
    email varchar(100),
    primary key (id),
    foreign key fk_users_contacts (username) references users(username)
)engine InnoDB;

create table addresses(
    id varchar(100) not null,
    contact_id varchar(100) not null,
    street varchar(200),
    city varchar(100),
    province varchar(100),
    country varchar(100) not null,
    postal_code varchar(10),
    primary key (id),
    foreign key fk_contact_address (contact_id) references contacts(id)
)engine InnoDB;

select * from users;

select * from contacts;

select * from addresses;

desc users;
desc contacts;
desc addresses;

delete from addresses;

delete from contacts;

delete from users;