

-- triggers examples




drop table if exists decimals;

create table if not exists decimals (
name varchar(100),
age int,
salary dec(7,3)
) engine=innodb ;

drop table if exists total_salary;

create table if not exists total_salary (
salary_sum dec(10,3)
) engine = innodb ;

select * from decimals;
select * from total_salary;

insert into total_salary values (0.0);

\s








drop trigger if exists add_salary;

delimiter |

create trigger add_salary after insert
on decimals 
for each row 
begin
update total_salary set salary_sum = salary_sum + new.salary;
end; |

delimiter ;





insert into decimals values ( "antonio" , 10 , 100.5 );

insert into decimals values ( "paula" , 23 , 200.5 );






insert into decimals values ( "antonio" , 10 , 897.876 );

insert into decimals values ( "antonio" , 10 , 10.00 );

insert into decimals values ( "luis" , 45 , 100.00 );

update total_salary set salary_sum = salary_sum +  1000;






select * from decimals;
select * from total_salary;



select 
sum(salary) as "total salary"
from decimals;





