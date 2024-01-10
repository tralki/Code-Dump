
drop table if exists teste;



create table if not exists teste (

    name varchar(50),

   

    number_of_hours tinyint,

    number_of_days smallint,

    number_of_weeks int,

    some_other_int integer,

    number_of_stars bigint,



    price_of_fruit dec(15,3)

);


insert into teste values ( "joao" , 12.07 , 53, 534, 56 , 1542413 , 5.054 );

insert into teste

(number_of_hours , number_of_days , number_of_weeks , some_other_int , number_of_stars , name , price_of_fruit  )

values (  5 , 5 , 5 , 5 , 5 , "joao" , 5.0 );



-- **************************************


drop table if exists teste;

create table if not exists teste (
    name varchar(50),
    date_of_birth date,
    time_of_birth time
);

insert into teste values ( "joao" , '2012-12-28' , '08:07:54' ); -- OK

insert into teste values ( '2012-12-28' , "joao" , '08:07:54' ); -- NOK

insert into teste
( date_of_birth , name , time_of_birth )
values ( '2012-12-28' , "joao" , '08:07:54' ); -- OK


-- ******************************************

select time_of_birth,name,date_of_birth from teste;

select name from teste;

select

name as "Employee Name",

date_of_birth as "data de nascimento",

time_of_birth as "hora de nascimento"

from teste;


select name as "Employee Name",

month(date_of_birth) as "month of birth",

day(date_of_birth) as "day of birth",

year(date_of_birth) as "year of birth"

from teste;





