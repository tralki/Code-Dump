-- ******************************************************************************


select 
customerNumber as "customer number",
customerName as "customer name",
creditLimit as "credit limit"
from customers

limit 10;

-- ******************************************************************************


select 
a.customerNumber as "customer number",
customerName as "customer name",
creditLimit as "credit limit",

checkNumber as "check number",
paymentDate as "payment date",
amount as "amount"

from customers a, payments b

where a.customerNumber = b.customerNumber

limit 10;

-- ******************************************************************************

select 
a.customerNumber as "customer number",
customerName as "customer name",
creditLimit as "credit limit",

orderNumber as "order number",
orderDate as "order date",
status as "status",
comments as "comments"

from customers a, orders b

where a.customerNumber = b.customerNumber

limit 10;

-- ******************************************************************************


select 
a.customerNumber as "customer number",
customerName as "customer name",
creditLimit as "credit limit",

b.orderNumber as "order number",
orderDate as "order date",
status as "status",
comments as "comments",

productCode as "product code",
quantityOrdered as "quantity ordered",
priceEach as "price each",
orderLineNumber as "line order"

from customers a, orders b , orderdetails c

where 
a.customerNumber = b.customerNumber
and b.orderNumber = c.orderNumber 

limit 10;
















1 - lista de pagamentos com detalhes do pedido
2 - lista de clientes e escritórios que lhes dão serviço
3 - inventário de peças por tipos de produtos
4 - lista de pedidos em espera e valor associado a esses pedidos
5 - valores de pedidos por escritório

6 - fazer um query que ligue todas as tabelas



























-- *************************************************************************

SELECT
    TABLE_NAME,
    TABLE_ROWS
FROM
    `information_schema`.`tables`
WHERE
    `table_schema` = 'datawarehouse';


SELECT
    TABLE_NAME,
    TABLE_ROWS
FROM
    `information_schema`.`tables`
WHERE
    `table_name` in ( 
        "offices" ,  
        "employees",
        "customers",
        "payments",
        "orders",
        "orderdetails",
        "products",
        "productlines"
    );

+--------------+------------+
| TABLE_NAME   | TABLE_ROWS |
+--------------+------------+
| customers    |        122 |
| employees    |         23 |
| offices      |          7 |
| orderdetails |       2996 |
| orders       |        326 |
| payments     |        273 |
| productlines |          7 |
| products     |        110 |
+--------------+------------+



select * from mysql.innodb_table_stats;


grant select on mysql.* to "datawarehouse"@"localhost" with grant option;
grant select on mysql.* to "datawarehouse"@"%";




optimize table employees , customers , offices , orderdetails , orders, payments, productlines , products;
analyze table employees , customers , offices , orderdetails , orders, payments, productlines , products;


drop table t1;

CREATE TABLE `t1` (
`id` int(8) NOT NULL auto_increment,
`data` varchar(255),
`date` datetime,
PRIMARY KEY  (`id`),
INDEX `DATE_IX` (`date`)
) ENGINE=InnoDB,

  STATS_PERSISTENT=1,
  STATS_AUTO_RECALC=1,
  STATS_SAMPLE_PAGES=25;















SELECT index_name, stat_name, stat_value, stat_description
       FROM mysql.innodb_index_stats where   
       `table_name` in ( 
        "offices" ,  
        "employees",
        "customers",
        "payments",
        "orders",
        "orderdetails",
        "products",
        "productlines"
    );





customers c
employees e
offices of
orderdetails od
orders o
payments p
productlines pl
products pd




select count(*) from offices;

select 
o.orderNumber, 
o.orderDate,
o.status,

c.customerName , 
p.checkNumber ,
p.paymentDate,
p.amount ,
od.quantityOrdered,
od.priceEach,
pd.productName,
pl.productline,
e.firstName,
e.lastName,
oc.city,
oc.phone,
oc.state


from 
payments p ,  -- 1
customers c , -- 2
orders o , -- 3
orderdetails od , -- 4 
products pd , -- 5
productlines pl, -- 6
employees e, -- 7
offices oc -- 8


where 
c.customerNumber = p.customerNumber
and 
c.customerNumber = o.customerNumber
and
o.orderNumber = od.orderNumber
and
od.productCode = pd.productCode
and
pd.productline = pl.productline
and 
c.salesRepEmployeeNumber = e.employeeNumber
and
e.officeCode = oc.officeCode

order by o.orderNumber

limit 100;




select count(*) 

from payments p , customers c , orders o , orderdetails od , products pd

where 
c.customerNumber = p.customerNumber
and 
c.customerNumber = o.customerNumber
and
o.orderNumber = od.orderNumber
and
od.productCode = pd.productCode;







select count(distinct customerNumber) 
from payments p ;

select count(distinct customerNumber) 
from customers p ;

select count(distinct customerNumber) 
from orders o ;




select count(*)
from customers c , payments p
where 
c.customerNumber = p.customerNumber;





-- clientes que não têm pagamentos
select customerNumber , customerName
from customers c
where customerNumber not in ( select customerNumber from payments p );



-- clientes que têm pagamentos
select customerNumber , customerName
from customers c
where customerNumber in ( select customerNumber from payments p );








-- clientes com encomendas
select customerNumber , customerName
from customers c
where customerNumber in ( select customerNumber from orders o );

-- clientes sem encomendas
select customerNumber , customerName
from customers c
where customerNumber not in ( select customerNumber from orders o );





-- lista completa de clientes com pagamentos
select c.customerNumber , c.customerName , p.customerNumber , p.checkNumber , p.paymentDate , p.amount
from customers c left join payments p
on c.customerNumber = p.customerNumber;




select c.customerNumber , c.customerName , p.customerNumber , p.checkNumber , p.paymentDate , p.amount
from customers c left join payments p
on c.customerNumber = p.customerNumber
where p.customerNumber is null;








