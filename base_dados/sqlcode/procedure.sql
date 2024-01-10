


DROP PROCEDURE IF EXISTS Get_List_Of_Products;

DELIMITER //

CREATE PROCEDURE  Get_List_Of_Products()
BEGIN
	SELECT *  FROM product;
END //

DELIMITER ;



SHOW PROCEDURE STATUS;

SHOW PROCEDURE STATUS WHERE db = 'datawarehouse';

call Get_List_Of_Products();






DROP PROCEDURE IF EXISTS Get_Average_Value_Of_Products;

DELIMITER //

CREATE PROCEDURE  Get_Average_Value_Of_Products( in product_type varchar(100) )
BEGIN
	SELECT avg(value) as "average value"
    from product 
    where pname = product_type;
END //

DELIMITER ;


call Get_Average_Value_Of_Products ( 645 );










