create table if not exists users(
    user_id  serial primary key,
    login    varchar(100) unique not null,
    password varchar(255)  not null,
    role     varchar(50)  not null,
    username varchar(100)  not null
);