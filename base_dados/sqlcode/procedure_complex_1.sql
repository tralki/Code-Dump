
https://www.softwaretestinghelp.com/mysql-stored-procedure/
 
-- table creation
CREATE TABLE studentMarks (
    stud_id SMALLINT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    total_marks INT, 
    grade VARCHAR(5)
    
    );
 
 
-- insert sample data
INSERT INTO studentMarks(total_marks, grade) VALUES(450, 'A'), (480, 'A+'), (490, 'A++'), (440, 'B+'),(400, 'C+'),(380,'C')
,(250, 'D'),(200,'E'),(100,'F'),(150,'F'),(220, 'E');


select * from studentMarks;



-- ***************************************************************************************
drop procedure spGetStudentData;

DELIMITER $$
CREATE PROCEDURE spGetStudentData()
BEGIN
    SELECT * FROM studentMarks;
END$$
DELIMITER ;

CALL spGetStudentData();


-- ***************************************************************************************
drop procedure spGetDetailsByStudentName;

DELIMITER //
CREATE PROCEDURE spGetDetailsByStudentName(IN studentId INT)
BEGIN
    SELECT * FROM studentMarks where stud_id = studentId;
END //
DELIMITER ;

call spGetDetailsByStudentName(1);

-- ***************************************************************************************

drop procedure spGetAverageMarks;

DELIMITER //
CREATE PROCEDURE spGetAverageMarks(OUT average DECIMAL(5,2))
BEGIN
    SELECT AVG(total_marks) INTO average FROM studentMarks;
END //
DELIMITER ;


CALL spGetAverageMarks(@average_marks);
SELECT @average_marks;



-- ***************************************************************************************
drop procedure spUpdateCounter;

DELIMITER //
CREATE PROCEDURE spUpdateCounter(INOUT counter INT, IN increment INT)
BEGIN
    SET counter = counter + increment;
END //
DELIMITER ;


SET @counter=10;
CALL spUpdateCounter(@counter,3);
SELECT @counter;

-- ***************************************************************************************

drop procedure spCountOfBelowAverage;


DELIMITER //
CREATE PROCEDURE spCountOfBelowAverage(OUT countBelowAverage INT)
BEGIN
    DECLARE avgMarks DECIMAL(5,2) DEFAULT 0;
    SELECT AVG(total_marks) INTO avgMarks FROM studentMarks;
    SELECT COUNT(*) INTO countBelowAverage FROM studentMarks WHERE total_marks < avgMarks;
END //
DELIMITER ;


CALL spCountOfBelowAverage(@countBelowAverage);
SELECT @countBelowAverage;



-- ***************************************************************************************
SHOW PROCEDURE STATUS WHERE name LIKE 'sp%';





-- ***************************************************************************************
drop procedure spGetIsAboveAverage;

DELIMITER $$
CREATE PROCEDURE spGetIsAboveAverage(IN studentId INT, OUT isAboveAverage BOOLEAN)
BEGIN
    DECLARE avgMarks DECIMAL(5,2) DEFAULT 0;
    DECLARE studMarks INT DEFAULT 0;
    SELECT AVG(total_marks) INTO avgMarks FROM studentMarks;
    SELECT total_marks INTO studMarks FROM studentMarks WHERE stud_id = studentId; 
    IF studMarks > avgMarks THEN
        SET isAboveAverage = TRUE;
    ELSE
        SET isAboveAverage = FALSE;
    END IF;
END$$
DELIMITER ;


drop procedure spGetStudentResult;

DELIMITER $$
CREATE PROCEDURE spGetStudentResult(IN studentId INT, OUT result VARCHAR(20))
BEGIN
      -- nested stored procedure call
    CALL spGetIsAboveAverage(studentId,@isAboveAverage);
    IF @isAboveAverage = 0 THEN
        SET result = "FAIL";
    ELSE
        SET result = "PASS";
    END IF;
END$$
DELIMITER ;

CALL spGetStudentResult(2,@result);
SELECT @result;

CALL spGetStudentResult(10,@result);
SELECT @result;



-- ***************************************************************************************
drop procedure spGetStudentClass;

DELIMITER $$
CREATE PROCEDURE spGetStudentClass(IN studentId INT, OUT class VARCHAR(20))
BEGIN
    DECLARE marks INT DEFAULT 0;
    SELECT total_marks INTO marks FROM studentMarks WHERE stud_id = studentId;
        IF marks >= 400 THEN
        SET class = "First Class";
    ELSEIF marks >=300 AND marks < 400 THEN
        SET class = "Second Class";
    ELSE
        SET class = "Failed";
    END IF;
END$$
DELIMITER ;

CALL spGetStudentClass(1,@class);
SELECT @class;

CALL spGetStudentClass(6,@class);
SELECT @class;

CALL spGetStudentClass(11,@class);
SELECT @class;



-- ***************************************************************************************
drop procedure spInsertStudentData;

DELIMITER $$
CREATE PROCEDURE spInsertStudentData(IN studentId INT, 
IN total_marks INT, 
IN grade VARCHAR(20),
OUT rowCount INT)
BEGIN
 
-- error Handler declaration for duplicate key
DECLARE EXIT HANDLER FOR 1062
    BEGIN
    SELECT 'DUPLICATE KEY ERROR' AS errorMessage;
    END;
 
-- main procedure statements
INSERT INTO studentMarks(stud_id, total_marks, grade) VALUES(studentId,total_marks,grade);
    SELECT COUNT(*) FROM studentMarks INTO rowCount;
END$$
DELIMITER ;

CALL spInsertStudentData(1,450,'A+',@rowCount);


