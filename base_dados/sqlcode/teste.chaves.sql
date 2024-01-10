--*******************************************
drop table if exists chave;

create table if not exists chave (

    numero_cliente int,
    nome varchar(100),
    primary key ( numero_cliente , nome)

);

insert into chave values ( 1 , "luis");
insert into chave values ( 2 , "ana" );
insert into chave values ( 3 , "pedro");
insert into chave values ( 4 , "pedro" );
insert into chave values ( 3 , "antonio" );

alter table chave
MODIFY column numero_cliente int primary key;

select * from chave;

delete from chave
where numero_cliente = 3 and nome = "ana";