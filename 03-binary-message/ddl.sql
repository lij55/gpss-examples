drop table if exists binary_message;

CREATE TABLE binary_message(
    len int,
    content bytea,
    time timestamp default now()
) DISTRIBUTED randomly;


