-- cria uma tabela pequena onde metemos alguns dados

-- drop table empregados;


drop table if exists teste; --DDL



create table if not exists teste (   --DDL

    name varchar(50)

);



insert into teste ( name ) values ( "joao "); --DML

insert into teste values ( "joao "); --DML




select * from teste; --DML
delete from teste;  --DML
select count(*) from teste;  --DML


-- DDL data defenicion language
-- DML data manipulacion language


