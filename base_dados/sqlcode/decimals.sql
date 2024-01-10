


drop table if exists decimals;

create table if not exists decimals (
name varchar(100),
age int,
salary dec(7,3)
);


insert into decimals values ( "antonio" , 10 , 897.876 );

insert into decimals values ( "antonio" , 10 , 8983.879 );




LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\example2.csv' 
INTO TABLE decimals
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;




select 
name as "employee name",
age as "employee age",
floor(salary) as "integer part of salary"
from decimals;

-- The FLOOR() function returns the largest integer value that is smaller than or equal to a number.
-- The CEIL() function returns the smallest integer value that is bigger than or equal to a number.
-- The CEILING() function returns the smallest integer value that is bigger than or equal to a number.

-- Modulo operation. Returns the remainder of N divided by M.


select 
name as "employee name",
age as "employee age",
salary as "salary full number",
floor(salary) as "integer part of salary",
mod(salary , 1 ) as "decimal part of salary"
from decimals;





