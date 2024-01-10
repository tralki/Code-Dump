

drop table if exists `Python_Employee`;


CREATE TABLE if not exists `Python_Employee` ( 
    `id` INT NOT NULL , 
    `name` TEXT NOT NULL , 
    `photo` BLOB NOT NULL , 
    `biodata` LONGBLOB NOT NULL , 
    PRIMARY KEY (`id`));

