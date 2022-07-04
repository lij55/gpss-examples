drop table if exists vehicles_sensor_data;

CREATE TABLE vehicles_sensor_data (
    device text,
    humidity double precision,
    temperature double precision,
    experiment smallint DEFAULT 1,
    "time" timestamp without time zone
) DISTRIBUTED BY (device);


