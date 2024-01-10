--Apaga a tabela clubs_p
drop table clubs_p;

--Cria a tabela clubs_p
create table clubs_p (
    posicao int,
    club_p varchar(100)
);

--insere os dados na tabela clubs_p
insert into clubs_p values (1,"Flamengo");
insert into clubs_p values (4,"Real Madri");
insert into clubs_p values (7,"Sporting");

--Apaga a tabela clubs_t
drop table clubs_t;

--Cria a tabela clubs_t
create table clubs_t (
    tamanho int,
    club_t varchar(100)
);

--insere os dados na tabela clubs_t
insert into clubs_t values (15,"Flamengo");
insert into clubs_t values (13,"Sporting");
insert into clubs_t values (20,"Benfica");


--left join
SELECT
 posicao,
 club_p,
 tamanho,
 club_t
FROM
 clubs_p
LEFT JOIN
 clubs_t
ON club_p = club_t;

--inner join
SELECT
 posicao,
 club_p,
 tamanho,
 club_t
FROM
 clubs_p
INNER JOIN
 clubs_t
ON club_p = club_t;
