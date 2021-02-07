drop table if exists merge_test;

CREATE TABLE merge_test(
    col1 int,  -- match columns
    col2 int,  -- match columns
    col3 int,  -- update_condition
    col4 int, -- to update
    col5 text, -- to update
    col6 text
) DISTRIBUTED randomly;

insert into merge_test values 
    (1,1,0,1,'old1','old1'),
    (2,2,0,2,'old2','old2'),
    (3,3,0,3,'old3','old3'),
    (4,4,0,4,'old4','old4'),
    (5,5,0,5,'old5','old5'),
    (6,6,0,6,'old6','old6'),
    (7,7,0,7,'old7','old7'),
    (8,8,0,8,'old8','old8');