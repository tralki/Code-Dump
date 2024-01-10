-- trabalho feito por bruno roque e rafael gaspar

drop table if exists fornecedor; --DDL

create table if not exists fornecedor ( --DDL
    fornecedor varchar(100) primary key
)engine = InnoDB;

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\apresentacao1\\fornecedoures.csv' --DML
INTO TABLE fornecedor
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--****************
drop table if exists materiais; --DDL

create table if not exists materiais ( --DDL
    pecas varchar(100), 
    preco float primary key,
    tabela_de_desconto varchar(100)
)engine = InnoDB;

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\apresentacao1\\pecas.csv' --DML
INTO TABLE materiais
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--*****************
drop table if exists carros; --DDL

create table if not exists carros ( --DDL
    matricula_de_carro varchar(100) , 
    carro varchar(100) ,
    problema varchar(100),
    primary key (matricula_de_carro)
)engine = InnoDB;

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\apresentacao1\\carros.csv' --DML
INTO TABLE carros
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--*****************
drop table if exists clientes; --DDL

create table if not exists clientes( --DDL
    nome_cliente varchar(100),
    numero_cliente int,
    carro varchar(100),
    matricula_de_carro varchar(100),
    primary key (numero_cliente),
    FOREIGN key (matricula_de_carro) references carros(matricula_de_carro) on delete cascade
)engine = InnoDB;

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\apresentacao1\\cliente.csv' --DML
INTO TABLE clientes
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--******************

drop table if exists encomendas; --DDL

create table if not exists encomendas ( --DDL
    fornecedor varchar(100),
    pecas varchar(100),
    nome_cliente varchar(100),
    numero_cliente int,
    preco_de_custo float,
    pvp float,
    pvp_com_IVA float,
    FOREIGN key (fornecedor) references fornecedor(fornecedor) on delete cascade,
    FOREIGN key (preco_de_custo) references materiais(preco) on delete cascade,
    FOREIGN key (numero_cliente) references clientes(numero_cliente) on delete cascade
)engine = InnoDB;

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\apresentacao1\\encomendas.csv' --DML
INTO TABLE encomendas
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;
