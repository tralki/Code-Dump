

drop table if exists product;

create table if not exists product ( 

    pname varchar(100),
    qty int,
    value dec(7,3)
);

drop table if exists product_qty ;

create table if not exists product_qty (
    qty_apple int,
    qty_orange int,
    qty_lemon int,
    qty_all int
);


describe product;
describe product_qty;

select * from product;
select * from product_qty;



insert into product_qty values ( 0 , 0 , 0 , 0 );




select * from product;
select * from product_qty;






drop trigger if exists upd_product;

delimiter //

CREATE TRIGGER upd_product after insert ON product
       FOR EACH ROW
       BEGIN

       if ( new.pname = "apple") 
       then
            update product_qty set qty_apple = qty_apple + new.qty;
        end if;
        
       if ( new.pname = "orange") 
       then
            update product_qty set qty_orange = qty_orange + new.qty;
        end if;

       if ( new.pname = "lemon") 
       then
            update product_qty set qty_lemon = qty_lemon + new.qty;
        end if;

    update product_qty set qty_all = qty_all + new.qty;

       END; //

delimiter ;


insert into product values ( "orange" , 12 , 3.4 );







show triggers;




insert into product values ( "orange" , 12 , 3.4 );
insert into product values ( "orange" , 12 , 3.4 );

insert into product values ( "lemon" , 8 , 5.4 );

insert into product values ( "apple" , 7 , 1.43 );

insert into product values ( "banana" , 4 , 2.98 );

insert into product values ( "apple" , 100 , 1.43 );


insert into product values ( "apple" , -20 , 1.43 );



select 
sum(qty) as "total quantity"
from product;


select pname as "product name",
sum(qty) as "total quantity"
from product
group by pname;






select * from product;
select * from product_qty;



