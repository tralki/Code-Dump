
drop table if exists mytable23;


create table if not exists mytable23 (
    name varchar(100),
    age int,
    salary dec(10,3)
) engine = InnoDB;



insert into mytable23 values ( "joao" , 45 , 1254.67 );

select * from mytable23;

START TRANSACTION;
update mytable23 set age = age + 12 where name = "joao";

commit;

select * from mytable23;



rollback;


SET autocommit=0;

SELECT @@TX_ISOLATION;
SELECT @@transaction_ISOLATION;



-- na primeira sessão
lock tables mytable23 read;

insert into mytable23 values ( "luis" , 45 , 1254.67 );

unlock tables;








