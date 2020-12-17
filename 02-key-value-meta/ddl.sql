drop table if exists demo_meta;

CREATE TABLE demo_meta(
    key varchar(8),
    value json,
    meta json
) DISTRIBUTED randomly;


