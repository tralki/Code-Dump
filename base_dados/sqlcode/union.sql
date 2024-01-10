drop table basket_a;

create table basket_a (
    a int,
    fruit_a varchar(100)
);


insert into basket_a values ( 1 , "Apple" );
insert into basket_a values ( 2 , "Orange" );
insert into basket_a values ( 3 , "Banana" );
insert into basket_a values ( 4 , "Cucumber" );


drop table basket_b;

create table basket_b (
    b int,
    fruit_b varchar(100)
);

insert into basket_b values ( 1 , "Orange" );
insert into basket_b values ( 1 , "Apple" );
insert into basket_b values ( 1 , "Watermelon" );
insert into basket_b values ( 1 , "Pear" );

select * from basket_a;
select * from basket_b;


-- INNER JOIN
SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
INNER JOIN basket_b
    ON fruit_a = fruit_b;

-- LEFT OUTER JOIN
SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
LEFT JOIN basket_b 
   ON fruit_a = fruit_b;

-- -- LEFT OUTER JOIN - only rows from left table
SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
LEFT JOIN basket_b 
    ON fruit_a = fruit_b
WHERE b IS NULL;

-- RIGHT OUTER JOIN
SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
RIGHT JOIN basket_b 
ON fruit_a = fruit_b;

-- RIGHT OUTER JOIN - only rows from right table
SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
RIGHT JOIN basket_b 
   ON fruit_a = fruit_b
WHERE a IS NULL;

-- FULL OUTER JOIN

SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
LEFT  JOIN basket_b 
   ON fruit_a = fruit_b

union 

SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_b
LEFT  JOIN basket_a 
   ON fruit_a = fruit_b
   where fruit_a is null;


SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_a
LEFT  JOIN basket_b 
   ON fruit_a = fruit_b

union all

SELECT
    a,
    fruit_a,
    b,
    fruit_b
FROM
    basket_b
LEFT  JOIN basket_a 
   ON fruit_a = fruit_b;


