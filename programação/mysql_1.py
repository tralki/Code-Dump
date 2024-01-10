# C:\Users\torad\Desktop\python311\python.exe mysql_1.py
import mysql.connector

config = {
    'user': 'datawarehouse',
    'password': 'datawarehouse',
    'host': '127.0.0.1',
    'database': 'datawarehouse',
    'raise_on_warnings': True
}

cnx = mysql.connector.connect(**config)

cnx.close()

