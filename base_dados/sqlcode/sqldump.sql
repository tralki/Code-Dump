

https://dev.mysql.com/doc/refman/8.0/en/privileges-provided.html




Granting the PROCESS privilege for the user is perhaps the simplest option for fixing the mysqldump process privilege error. Keep in mind that this option presents security issues. You should therefore really only use this option for your own local development server installation.

To grant the PROCESS privilege, log in as an administrator user and run the following query:

GRANT PROCESS ON *.* TO user@localhost;

Note that PROCESS is a global level privilege. It can’t apply to individual databases. Global privileges are either administrative or apply to all databases on your MySQL server. Trying to grant them on individual databases deplays the following error:

ERROR 1221 (HY000): Incorrect usage of DB GRANT and GLOBAL PRIVILEGES

To grant the privilege to all databases you must use the ON *.* ... syntax.



"C:\Program Files\MySQL\MySQL Server 8.0\bin\"mysqldump.exe --host=127.0.0.1 --port=3306  -uroot --routines --events -ppro45cat --result-file=tt.sql datawarehouse




-- DUMP - backup - exportar dados + DDL

"C:\Program Files\MySQL\MySQL Server 8.0\bin\"mysqldump.exe 
--host=127.0.0.1 
--port=3306  
-uroot 
--routines 
--events 
-ppro45cat 
--result-file=tt.sql 
datawarehouse


-- Import dados + DDL

 mysql.exe --defaults-file="C:\Users\JOSEAL~1\AppData\Local\Temp\tmpxltfdq2f.cnf"  
 --protocol=tcp --host=localhost 
 --user=root --port=3306 --default-character-set=utf8 
 --comments --database=recovery  < "C:\\Users\\jose almeida\\Downloads\\export_datawarehouse (2).sql"








