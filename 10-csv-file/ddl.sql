drop table if exists binary_files;

CREATE TABLE binary_files(
    len int,
    content bytea,
    time timestamp default now()
) DISTRIBUTED randomly;


