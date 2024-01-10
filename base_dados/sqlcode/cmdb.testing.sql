--*********************************************************************


drop table if exists cmdb_testing;



create table if not exists cmdb_testing (
    origin_scope varchar(100),
    cross_image_service varchar(100),
    site_location varchar(100),
    rua varchar(100),
    codigo_postal varchar(100),
    localidade varchar(100),
    hw_serial_number varchar(100),
    image_hostname varchar(100),
    image_type varchar(100),
    cpu_resources int,
    memory_resources int,
    provisioned_MB bigint
);

--***********************

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\BASELINE_COMERCIAL_TESTING.csv'
INTO TABLE cmdb_testing
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--************************

drop table if exists cmdb_locations;

create table if not exists cmdb_locations (
location_id varchar(100),
address varchar(100),
postal_code varchar(100),
location varchar(100)
);

insert into cmdb_locations values ( "ALF" , "Rua Oliveira Cardoso , N. 43" , "2445-675" , "LISBOA"  );
insert into cmdb_locations values ( "NCI" , "Avenida dos Mares da China" , "3665-872" , "PORTO"  );
insert into cmdb_locations values ( "TAG" , "Praceta António Paulo Dias" , "4000-765" , "FARO"  );
insert into cmdb_locations values ( "SEDE" , "Praça Pedro Cardoso, Lote 23" , "1254-876" , "COIMBRA"  );




























