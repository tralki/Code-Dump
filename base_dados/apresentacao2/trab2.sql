--****************************************************************************************************************
-- projeto 2

-- CRIACAO DE TABELAS
drop table if exists cmdb;

create table if not exists cmdb(
    origin_scope varchar(100),
    cross_image_service varchar(100),
    site_location varchar(100),
    hw_serial_number varchar(100),
    image_hostname varchar(100),
    image_type varchar(100),
    cpu_resources int,
    memory_resources int,
    provisioned_MB bigint
);

--***********************************************

drop table if exists historic;

create table if not exists historic(
    origin_scope varchar(100),
    cross_image_service varchar(100),
    site_location varchar(100),
    hw_serial_number varchar(100),
    image_hostname varchar(100),
    image_type varchar(100),
    cpu_resources int,
    memory_resources int,
    provisioned_MB bigint,
    modifed_accion varchar(100),
    modifed_time TIMESTAMP
);

--***********************************************

drop table if exists unity_resources;

create table if not exists unity_resources(
    cpu_resources_total int,
    memory_resources_total int,
    provisioned_MB_total bigint
);

insert into unity_resources values ( 0 , 0 , 0 );

--***********************************************

drop table if exists all_origin;

create table if not exists all_origin(
    ph_cms_cpu int,
    ph_cms_memory int,
    ph_cms_MB bigint,
    ibm_cpu int,
    ibm_memory int,
    ibm_MB bigint,
    nb_cloud_cpu int,
    nb_cloud_memory int,
    nb_cloud_MB bigint,
    not_manage_cpu int,
    not_manage_memory int,
    not_manage_MB bigint,
    ph_cms_not_manage_cpu int,
    ph_cms_not_manage_memory int,
    ph_cms_not_manage_MB bigint
);

insert into all_origin values ( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

PH CMS
IBM
NB Cloud
Not Manage
PH CMS Not Manage

--***********************************************


drop table if exists all_cross;

create table if not exists all_cross(
    application_cpu int,
    application_memory int,
    application_MB bigint,
    infrastructure_cpu int,
    infrastructure_memory int,
    infrastructure_MB bigint,
    database_cpu int,
    database_memory int,
    database_MB bigint
);

insert into all_cross values ( 0, 0, 0, 0, 0, 0, 0, 0, 0);

APPLICATION
Infrastructure
DATABASE

--***********************************************

drop table if exists all_site;

create table if not exists all_site(
    alf_cpu int,
    alf_memory int,
    alf_MB bigint,
    nci_cpu int,
    nci_memory int,
    nci_MB bigint
);

insert into all_site values ( 0, 0, 0, 0, 0, 0);

ALF
NCI


--***********************************************

drop table if exists all_image;

create table if not exists all_image(
    fisica_cpu int,
    fisica_memory int,
    fisica_MB bigint,
    virtual_cpu int,
    virtual_memory int,
    virtual_MB bigint
);

insert into all_image values ( 0, 0, 0, 0, 0, 0);

Fisica
Virtual

--***********************************************

--INFORMACAO PARA AS TABELAS

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\BASELINE_COMERCIAL_01.03.2020.csv'
INTO TABLE cmdb
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


INSERT INTO cmdb (origin_scope, cross_image_service, site_location, hw_serial_number, image_hostname, image_type, cpu_resources, memory_resources, provisioned_MB) 
VALUES ('PH CMS','APPLICATION','ALF','DEH451561F','gbes03','Fisica',2,6144,0);

DELETE FROM cmdb 
where origin_scope = 'PH CMS'
and cross_image_service = 'APPLICATION'
and site_location = 'ALF'
and hw_serial_number = 'DEH451561F'
and image_hostname = 'gbes03'
and image_type = 'Fisica'
and cpu_resources = 2
and memory_resources = 6144
and provisioned_MB = 0;



UPDATE cmdb 
set cpu_resources = 3, memory_resources = 614, provisioned_MB = 4 
where origin_scope = 'PH CMS'
and cross_image_service = 'APPLICATION'
and site_location = 'ALF'
and hw_serial_number = 'DEH451561F'
and image_hostname = 'gbes03'
and image_type = 'Fisica'
and cpu_resources = 2
and memory_resources = 6144
and provisioned_MB = 0;

--************

--STORE PROCESURES/TRIGGERS


--historic // trigger
DROP TRIGGER IF EXISTS historic_in;
DELIMITER //

CREATE TRIGGER historic_in AFTER INSERT ON cmdb
FOR EACH ROW 
BEGIN
    INSERT INTO historic (origin_scope, cross_image_service, site_location, hw_serial_number, image_hostname, image_type, cpu_resources, memory_resources, provisioned_MB, modifed_accion, modifed_time) 
    VALUES (NEW.origin_scope, NEW.cross_image_service, NEW.site_location, NEW.hw_serial_number, NEW.image_hostname, NEW.image_type, NEW.cpu_resources, NEW.memory_resources, NEW.provisioned_MB, 'insert', CURRENT_TIMESTAMP);
END //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

DROP TRIGGER IF EXISTS historic_del;
DELIMITER //

CREATE TRIGGER historic_del AFTER DELETE ON cmdb
FOR EACH ROW 
BEGIN
    INSERT INTO historic (origin_scope, cross_image_service, site_location, hw_serial_number, image_hostname, image_type, cpu_resources, memory_resources, provisioned_MB, modifed_accion, modifed_time) 
    VALUES (OLD.origin_scope, OLD.cross_image_service, OLD.site_location, OLD.hw_serial_number, OLD.image_hostname, OLD.image_type, OLD.cpu_resources, OLD.memory_resources, OLD.provisioned_MB, 'delete', CURRENT_TIMESTAMP);
END //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

DROP TRIGGER IF EXISTS historic_up;
DELIMITER //

CREATE TRIGGER historic_up AFTER UPDATE ON cmdb
FOR EACH ROW 
BEGIN
    INSERT INTO historic (origin_scope, cross_image_service, site_location, hw_serial_number, image_hostname, image_type, cpu_resources, memory_resources, provisioned_MB, modifed_accion, modifed_time) 
    VALUES (NEW.origin_scope, NEW.cross_image_service, NEW.site_location, NEW.hw_serial_number, NEW.image_hostname, NEW.image_type, NEW.cpu_resources, NEW.memory_resources, NEW.provisioned_MB, 'update', CURRENT_TIMESTAMP);
END //

DELIMITER ;

--resorce uniti calculate // trigger

DROP TRIGGER IF EXISTS resourc_in;
DELIMITER //

CREATE TRIGGER resourc_in AFTER INSERT ON cmdb
FOR EACH ROW
BEGIN
    update unity_resources set cpu_resources_total = cpu_resources_total + new.cpu_resources;
    update unity_resources set memory_resources_total = memory_resources_total + new.memory_resources;
    update unity_resources set provisioned_MB_total = provisioned_MB_total + new.provisioned_MB;
END; //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

DROP TRIGGER IF EXISTS resourc_del;
DELIMITER //

CREATE TRIGGER resourc_del AFTER DELETE ON cmdb
FOR EACH ROW
BEGIN
    update unity_resources set cpu_resources_total = cpu_resources_total - old.cpu_resources;
    update unity_resources set memory_resources_total = memory_resources_total - old.memory_resources;
    update unity_resources set provisioned_MB_total = provisioned_MB_total - old.provisioned_MB;
END; //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

DROP TRIGGER IF EXISTS resourc_up;
DELIMITER //

CREATE TRIGGER resourc_up AFTER UPDATE ON cmdb
FOR EACH ROW
BEGIN
    update unity_resources set cpu_resources_total = cpu_resources_total - old.cpu_resources;
    update unity_resources set cpu_resources_total = cpu_resources_total + new.cpu_resources;
    update unity_resources set memory_resources_total = memory_resources_total - old.memory_resources;
    update unity_resources set memory_resources_total = memory_resources_total + new.memory_resources;
    update unity_resources set provisioned_MB_total = provisioned_MB_total - old.provisioned_MB;
    update unity_resources set provisioned_MB_total = provisioned_MB_total + new.provisioned_MB;
END; //

DELIMITER ;


--call resources();
--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- origin trigger
--input
DROP TRIGGER IF EXISTS origin_in;

DELIMITER // 
 
CREATE TRIGGER origin_in AFTER INSERT ON cmdb
FOR EACH ROW
BEGIN

IF (new.origin_scope = 'PH CMS')
THEN 
UPDATE all_origin set ph_cms_cpu = ph_cms_cpu + new.cpu_resources ,
ph_cms_memory = ph_cms_memory + new.memory_resources ,
ph_cms_MB = ph_cms_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'IBM')
THEN 
UPDATE all_origin set ibm_cpu = ibm_cpu + new.cpu_resources ,
ibm_memory = ibm_memory + new.memory_resources ,
ibm_MB = ibm_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'NB Cloud')
THEN 
UPDATE all_origin set nb_cloud_cpu = nb_cloud_cpu + new.cpu_resources ,
nb_cloud_memory = nb_cloud_memory + new.memory_resources ,
nb_cloud_MB = nb_cloud_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'Not Manage')
THEN 
UPDATE all_origin set not_manage_cpu = not_manage_cpu + new.cpu_resources ,
not_manage_memory = not_manage_memory + new.memory_resources ,
not_manage_MB = not_manage_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'PH CMS Not Manage')
THEN 
UPDATE all_origin set ph_cms_not_manage_cpu = ph_cms_not_manage_cpu + new.cpu_resources ,
ph_cms_not_manage_memory = ph_cms_not_manage_memory + new.memory_resources ,
ph_cms_not_manage_MB = ph_cms_not_manage_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--delete

DROP TRIGGER IF EXISTS origin_del;

DELIMITER // 
 
CREATE TRIGGER origin_del AFTER DELETE ON cmdb
FOR EACH ROW
BEGIN

IF (old.origin_scope = 'PH CMS')
THEN 
UPDATE all_origin set ph_cms_cpu = ph_cms_cpu - old.cpu_resources ,
ph_cms_memory = ph_cms_memory - old.memory_resources ,
ph_cms_MB = ph_cms_MB - old.provisioned_MB;
END IF;

IF (old.origin_scope = 'IBM')
THEN 
UPDATE all_origin set ibm_cpu = ibm_cpu - old.cpu_resources ,
ibm_memory = ibm_memory - old.memory_resources ,
ibm_MB = ibm_MB - old.provisioned_MB;
END IF;

IF (old.origin_scope = 'NB Cloud')
THEN 
UPDATE all_origin set nb_cloud_cpu = nb_cloud_cpu - old.cpu_resources ,
nb_cloud_memory = nb_cloud_memory - old.memory_resources ,
nb_cloud_MB = nb_cloud_MB - old.provisioned_MB;
END IF;

IF (old.origin_scope = 'Not Manage')
THEN 
UPDATE all_origin set not_manage_cpu = not_manage_cpu - old.cpu_resources ,
not_manage_memory = not_manage_memory - old.memory_resources ,
not_manage_MB = not_manage_MB - old.provisioned_MB;
END IF;

IF (old.origin_scope = 'PH CMS Not Manage')
THEN 
UPDATE all_origin set ph_cms_not_manage_cpu = ph_cms_not_manage_cpu - old.cpu_resources ,
ph_cms_not_manage_memory = ph_cms_not_manage_memory - old.memory_resources ,
ph_cms_not_manage_MB = ph_cms_not_manage_MB - old.provisioned_MB;
END IF;

END; //

DELIMITER ;

-- update

DROP TRIGGER IF EXISTS origin_up;

DELIMITER // 
 
CREATE TRIGGER origin_up AFTER UPDATE ON cmdb
FOR EACH ROW
BEGIN

IF (new.origin_scope = 'PH CMS')
THEN 
UPDATE all_origin set ph_cms_cpu = ph_cms_cpu - old.cpu_resources + new.cpu_resources ,
ph_cms_memory = ph_cms_memory - old.memory_resources + new.memory_resources ,
ph_cms_MB = ph_cms_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'IBM')
THEN 
UPDATE all_origin set ibm_cpu = ibm_cpu - old.cpu_resources + new.cpu_resources ,
ibm_memory = ibm_memory - old.memory_resources + new.memory_resources ,
ibm_MB = ibm_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'NB Cloud')
THEN 
UPDATE all_origin set nb_cloud_cpu = nb_cloud_cpu - old.cpu_resources + new.cpu_resources ,
nb_cloud_memory = nb_cloud_memory - old.memory_resources + new.memory_resources ,
nb_cloud_MB = nb_cloud_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'Not Manage')
THEN 
UPDATE all_origin set not_manage_cpu = not_manage_cpu - old.cpu_resources + new.cpu_resources ,
not_manage_memory = not_manage_memory - old.memory_resources + new.memory_resources ,
not_manage_MB = not_manage_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.origin_scope = 'PH CMS Not Manage')
THEN 
UPDATE all_origin set ph_cms_not_manage_cpu = ph_cms_not_manage_cpu - old.cpu_resources + new.cpu_resources ,
ph_cms_not_manage_memory = ph_cms_not_manage_memory - old.memory_resources + new.memory_resources ,
ph_cms_not_manage_MB = ph_cms_not_manage_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
--cross image trigger
--input
DROP TRIGGER IF EXISTS cross_in;

DELIMITER // 
 
CREATE TRIGGER cross_in AFTER INSERT ON cmdb
FOR EACH ROW
BEGIN

IF (new.cross_image_service = 'APPLICATION')
THEN 
UPDATE all_cross  set application_cpu = application_cpu + new.cpu_resources ,
application_memory = application_memory + new.memory_resources ,
application_MB = application_MB + new.provisioned_MB;
END IF;

IF (new.cross_image_service = 'Infrastructure')
THEN 
UPDATE all_cross  set infrastructure_cpu = infrastructure_cpu + new.cpu_resources ,
infrastructure_memory = infrastructure_memory + new.memory_resources ,
infrastructure_MB = infrastructure_MB + new.provisioned_MB;
END IF;

IF (new.cross_image_service = 'DATABASE')
THEN 
UPDATE all_cross  set database_cpu = database_cpu + new.cpu_resources ,
database_memory = database_memory + new.memory_resources ,
database_MB = database_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--delete

DROP TRIGGER IF EXISTS cross_del;

DELIMITER // 
 
CREATE TRIGGER cross_del AFTER DELETE ON cmdb
FOR EACH ROW
BEGIN

IF (old.cross_image_service = 'APPLICATION')
THEN 
UPDATE all_cross  set application_cpu = application_cpu - old.cpu_resources ,
application_memory = application_memory - old.memory_resources ,
application_MB = application_MB - old.provisioned_MB;
END IF;

IF (old.cross_image_service = 'Infrastructure')
THEN 
UPDATE all_cross  set infrastructure_cpu = infrastructure_cpu - old.cpu_resources ,
infrastructure_memory = infrastructure_memory - old.memory_resources ,
infrastructure_MB = infrastructure_MB - old.provisioned_MB;
END IF;

IF (old.cross_image_service = 'DATABASE')
THEN 
UPDATE all_cross  set database_cpu = database_cpu - old.cpu_resources ,
database_memory = database_memory - old.memory_resources ,
database_MB = database_MB - old.provisioned_MB;
END IF;

END; //

DELIMITER ;

-- update

DROP TRIGGER IF EXISTS cross_up;

DELIMITER // 
 
CREATE TRIGGER cross_up AFTER UPDATE ON cmdb
FOR EACH ROW
BEGIN

IF (new.cross_image_service = 'APPLICATION')
THEN 
UPDATE all_cross  set application_cpu = application_cpu - old.cpu_resources + new.cpu_resources ,
application_memory = application_memory - old.memory_resources + new.memory_resources ,
application_MB = application_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.cross_image_service = 'Infrastructure')
THEN 
UPDATE all_cross  set infrastructure_cpu = infrastructure_cpu - old.cpu_resources + new.cpu_resources ,
infrastructure_memory = infrastructure_memory - old.memory_resources + new.memory_resources ,
infrastructure_MB = infrastructure_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.cross_image_service = 'DATABASE')
THEN 
UPDATE all_cross set database_cpu = database_cpu - old.cpu_resources + new.cpu_resources ,
database_memory = database_memory - old.memory_resources + new.memory_resources ,
database_MB = database_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- site locaticion trigger
--input
DROP TRIGGER IF EXISTS site_in;

DELIMITER // 
 
CREATE TRIGGER site_in AFTER INSERT ON cmdb
FOR EACH ROW
BEGIN

IF (new.site_location = 'ALF')
THEN 
UPDATE all_site set alf_cpu = alf_cpu + new.cpu_resources ,
alf_memory = alf_memory + new.memory_resources ,
alf_MB = alf_MB + new.provisioned_MB;
END IF;

IF (new.site_location = 'NCI')
THEN 
UPDATE all_site set nci_cpu = nci_cpu + new.cpu_resources ,
nci_memory = nci_memory + new.memory_resources ,
nci_MB = nci_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--delete

DROP TRIGGER IF EXISTS site_del;

DELIMITER // 
 
CREATE TRIGGER site_del AFTER DELETE ON cmdb
FOR EACH ROW
BEGIN

IF (old.site_location = 'ALF')
THEN 
UPDATE all_site set alf_cpu = alf_cpu - old.cpu_resources ,
alf_memory = alf_memory - old.memory_resources ,
alf_MB = alf_MB - old.provisioned_MB;
END IF;

IF (old.site_location = 'NCI')
THEN 
UPDATE all_site set nci_cpu = nci_cpu - old.cpu_resources ,
nci_memory = nci_memory - old.memory_resources ,
nci_MB = nci_MB - old.provisioned_MB;
END IF;

END; //

DELIMITER ;

-- update

DROP TRIGGER IF EXISTS site_up;

DELIMITER // 
 
CREATE TRIGGER site_up AFTER UPDATE ON cmdb
FOR EACH ROW
BEGIN

IF (new.site_location = 'ALF')
THEN 
UPDATE all_site set alf_cpu = alf_cpu - old.cpu_resources + new.cpu_resources ,
alf_memory = alf_memory - old.memory_resources + new.memory_resources ,
alf_MB = alf_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.site_location = 'NCI')
THEN 
UPDATE all_site set nci_cpu = nci_cpu - old.cpu_resources + new.cpu_resources ,
nci_memory = nci_memory - old.memory_resources + new.memory_resources ,
nci_MB = nci_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
--all image trigger

--input
DROP TRIGGER IF EXISTS image_in;

DELIMITER // 
 
CREATE TRIGGER image_in AFTER INSERT ON cmdb
FOR EACH ROW
BEGIN

IF (new.image_type = 'Fisica')
THEN 
UPDATE all_image  set fisica_cpu = fisica_cpu + new.cpu_resources ,
fisica_memory = fisica_memory + new.memory_resources ,
fisica_MB = fisica_MB + new.provisioned_MB;
END IF;

IF (new.image_type = 'Virtual')
THEN 
UPDATE all_image  set virtual_cpu = virtual_cpu + new.cpu_resources ,
virtual_memory = virtual_memory + new.memory_resources ,
virtual_MB = virtual_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--delete

DROP TRIGGER IF EXISTS image_del;

DELIMITER // 
 
CREATE TRIGGER image_del AFTER DELETE ON cmdb
FOR EACH ROW
BEGIN

IF (old.image_type = 'Fisica')
THEN 
UPDATE all_image  set fisica_cpu = fisica_cpu - old.cpu_resources ,
fisica_memory = fisica_memory - old.memory_resources ,
fisica_MB = fisica_MB - old.provisioned_MB;
END IF;

IF (old.image_type = 'Virtual')
THEN 
UPDATE all_image  set virtual_cpu = virtual_cpu - old.cpu_resources ,
virtual_memory = virtual_memory - old.memory_resources ,
virtual_MB = virtual_MB - old.provisioned_MB;
END IF;

END; //

DELIMITER ;

-- update

DROP TRIGGER IF EXISTS image_up;

DELIMITER // 
 
CREATE TRIGGER image_up AFTER UPDATE ON cmdb
FOR EACH ROW
BEGIN

IF (new.image_type = 'Fisica')
THEN 
UPDATE all_image  set fisica_cpu = fisica_cpu - old.cpu_resources + new.cpu_resources ,
fisica_memory = fisica_memory - old.memory_resources + new.memory_resources ,
fisica_MB = fisica_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

IF (new.image_type = 'Virtual')
THEN 
UPDATE all_image  set virtual_cpu = virtual_cpu - old.cpu_resources + new.cpu_resources ,
virtual_memory = virtual_memory - old.memory_resources + new.memory_resources ,
virtual_MB = virtual_MB - old.provisioned_MB + new.provisioned_MB;
END IF;

END; //

DELIMITER ;

--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

--procedure to see all 4 table in 1 command

DROP PROCEDURE IF EXISTS foursee;

DELIMITER //

CREATE PROCEDURE foursee()
BEGIN
SELECT *  FROM all_origin;
SELECT *  FROM all_cross;
SELECT *  FROM all_site;
SELECT *  FROM all_image;
END //

DELIMITER ;


--procedure to see the stroric

DROP PROCEDURE IF EXISTS history;

DELIMITER //

CREATE PROCEDURE  history()
BEGIN
	SELECT *  FROM historic;
END //

DELIMITER ;

--procedure do see the cmdb

DROP PROCEDURE IF EXISTS cmdb;

DELIMITER //

CREATE PROCEDURE cmdb()
BEGIN
	SELECT *  FROM cmdb;
END //

DELIMITER ;

-- procedure to see the resources

DROP PROCEDURE IF EXISTS resources;

DELIMITER //

CREATE PROCEDURE  resources()
BEGIN
	SELECT *  FROM unity_resources;
END //

DELIMITER ;
