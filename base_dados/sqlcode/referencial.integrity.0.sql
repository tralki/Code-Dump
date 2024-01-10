--******************************************************++
drop table if exists persons;

create table if not exists persons (
person_id int,
last_name varchar(100),
first_name varchar(100),
age int
);


insert into persons values ( 1 , "Pereira" , "Luis" , 50 );
insert into persons values ( 2 , "Almeida" , "Ana" , 45 );
insert into persons values ( 3 , "Ribeiro" , "Paulo" , 23 );
insert into persons values ( 4 , "Santos" , "Pedro" , 44 );
insert into persons values ( 5 , "Costa" , "Luisa" , 32 );




drop table if exists orders;

create table if not exists orders (
    order_id int,
    order_number int,
    person_id int
);

insert into orders values ( 1 , 773782 , 2 );
insert into orders values ( 2 , 3563456 , 1 );
insert into orders values ( 3 , 234245 , 2 );
insert into orders values ( 4 , 772334 , 3 );



insert into orders values ( 5 , 883445 , 7 );

--*************************************************************************

drop table if exists persons;

create table if not exists persons (
person_id int,
last_name varchar(100),
first_name varchar(100),
age int,
primary key (person_id)
) engine = InnoDB;


insert into persons values ( 1 , "Pereira" , "Luis" , 50 );
insert into persons values ( 2 , "Almeida" , "Ana" , 45 );
insert into persons values ( 3 , "Ribeiro" , "Paulo" , 23 );
insert into persons values ( 4 , "Santos" , "Pedro" , 44 );
insert into persons values ( 5 , "Costa" , "Luisa" , 32 );




drop table if exists orders;

create table if not exists orders (
    order_id int,
    order_number int,
    person_id int,
    primary key ( order_id),
    FOREIGN key (person_id) references persons(person_id) on delete cascade
) engine = InnoDB;

insert into orders values ( 1 , 773782 , 2 );
insert into orders values ( 2 , 3563456 , 1 );
insert into orders values ( 3 , 234245 , 2 );
insert into orders values ( 4 , 772334 , 3 );
insert into orders values ( 5 , 883445 , 7 );


