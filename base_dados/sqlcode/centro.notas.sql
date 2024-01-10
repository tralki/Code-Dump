--***************************************************
drop table if exists 5nomes;

create table if not exists 5nomes(
    nomes varchar(100)
);

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\centro5.csv'
INTO TABLE 5nomes
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

ENCLOSED BY '"'

insert into Nomes values LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\centro5.csv';


        

drop table if exists 5disciplinas;

create table if not exists 5disciplinas(
    disciplinas varchar(100),
    nomes varchar(100),
    FOREIGN key (nomes) references 5nomes(nomes) on delete cascade
);

drop table if exists 5Datas;

create table if not exists 5Datas(
    Datas varchar(100),
    Notas FLOAT(100,100)
);

drop table if exists 5Notas;

create table if not exists 5Notas(
    FOREIGN key (Nomes) references 5disciplinas(Nomes) on delete cascade,
    FOREIGN key (Disciplinas) references 5disciplinas(Disciplinas),
    FOREIGN key (Notas) references 5Datas(Notas) on delete cascade,
    FOREIGN key (Datas) references 5Datas(Datas) on delete cascade
);