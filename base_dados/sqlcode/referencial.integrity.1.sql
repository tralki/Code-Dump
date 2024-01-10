


drop table if exists customer;

create table if not exists customer (
cus_code int,
cus_name varchar(100),
cus_fname varchar(100),
cus_initial varchar(100),
cus_renew_date varchar(100),
agent_code int
);



drop table if exists agent;

create table if not exists agent (
    agent_code int,
    agent_areacode int,
    agent_phone varchar(100),
    agent_name varchar(100),
    agent_ytd_sls dec(12,3)
);





-- ************************************************************



drop table if exists agent;

create table if not exists agent (
    agent_code int primary key,
    agent_areacode varchar,
    agent_phone varchar(100),
    agent_name varchar(100),
    agent_ytd_sls dec(12,3)
);


drop table if exists customer;

create table if not exists customer (
cus_code int primary key,
cus_name varchar(100),
cus_fname varchar(100),
cus_initial varchar(100),
cus_renew_date varchar(100),
agent_code int,
FOREIGN key(agent_code) references agent(agent_code)
);


LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\agent.csv'
INTO TABLE agent
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;



LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\customer.csv'
INTO TABLE customer
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;



select cus_name , cus_fname, agent_name , agent_phone 
from customer , agent;


select a.cus_name , a.cus_fname, b.agent_name , b.agent_phone 
from customer a, agent b;






select a.cus_name , a.cus_fname, b.agent_name , b.agent_phone 
from customer a, agent b
where a.agent_code = b.agent_code;






select a.cus_name , a.cus_fname,a.cus_fname,a.cus_initial, b.agent_name , b.agent_phone , b.agent_ytd_sls
from customer a, agent b
where a.agent_code = b.agent_code
order by a.cus_name ,  b.agent_name;


drop view customer_agent;

create view customer_agent as

select 
a.cus_name as "customer name",
a.cus_fname as "customer first name", 
b.agent_name as "agent name", 
b.agent_phone as "agent phone" 
from customer a, agent b
where a.agent_code = b.agent_code
order by 1 , 2;



select `a`.`cus_name` AS `customer name`,
`a`.`cus_fname` AS `customer first name`,
`b`.`agent_name` AS `agent name`,
`b`.`agent_phone` AS `agent phone` from `datawarehouse`.`customer` `a` join `datawarehouse`.`agent` `b` where (`a`.`agent_code` = `b`.`agent_code`) 
order by `a`.`cus_name`,`a`.`cus_fname`

select * from customer_agent;









SELECT TABLE_SCHEMA, TABLE_NAME, VIEW_DEFINITION 
FROM information_schema.VIEWS 
WHERE TABLE_SCHEMA LIKE 'datawarehouse';










