create table if not exists cats
(
    cat_id  serial primary key,
    cat_name varchar(100) unique not null,
    age integer not null
);