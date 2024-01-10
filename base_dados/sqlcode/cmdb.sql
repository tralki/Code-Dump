--***************************************************

drop table is exists cmdb;

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

--***********************

LOAD DATA LOCAL INFILE 'C:\\Users\\torad\\Desktop\\importante\\base_dados\\BASELINE_COMERCIAL_01.03.2020.csv'
INTO TABLE cmdb
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

--************************

select distinct origin_scope from cmdb;

select count( distinct origin_scope ) from cmdb;

select distinct cross_image_service from cmdb;

select distinct origin_scope , cross_image_service from cmdb;

select count( distinct origin_scope,cross_image_service ) from cmdb;

select distinct origin_scope , cross_image_service from cmdb
order by origin_scope , cross_image_service ;

select count( distinct origin_scope,cross_image_service ) from cmdb
order by origin_scope , cross_image_service ;

select *
from cmdb
where cross_image_service = 'APPLICATION'
and origin_scope = 'NB CLOUD'
and cpu_resources = 6
order by image_hostname;

select origin_scope,  count(*)
from cmdb
group by 1
order by 1;

select sum(origin_scope),   sum(cpu_resources),sum(memory_resources),sum(provisioned_MB)
from cmdb
where cross_image_service = 'APPLICATION'
and origin_scope = 'NB CLOUD';

select site_location,
sum(cpu_resources),sum(memory_resources),sum(provisioned_MB)
from cmdb
group by site_location;

delete from cmdb
where cross_image_service = 'APPLICATION'
and origin_scope = 'NB CLOUD';

select image_hostname,   origin_scope,cross_image_service, cpu_resources,memory_resources,provisioned_MB
from cmdb
where image_hostname like "SW_______"; -- % 

select
image_hostname as "outro nome qualquer para esta coluna"  ,
origin_scope as "coluna 25",
cross_image_service as "outra",
cpu_resources,
memory_resources,
provisioned_MB
from cmdb
where image_hostname like "SW_______"
limit 5;

select
a.cmdb.origin_scope , a.cmdb.cross_image_service , a.cmdb.image_hostname , a.cmdb.site_location,
b.address , b.postal_code,location
from cmdb , cmdb_locations b
where cmdb.site_location = b.location_id
limit 10;



