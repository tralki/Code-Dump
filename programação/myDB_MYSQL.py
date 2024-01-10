#*********************************************************************************
import logging
import mysql.connector


db = ""

#*********************************************************************************
#*********************************************************************************
#*********************************************************************************
def connectDB ( _host , _port , _databaseName , _user , _password ):



    _function_name = "connectDB"



    logging.debug(f'[{_function_name}] connect to database ')



    global db



    config = {

    'user': _user,

    'password': _password,

    'host': _host,

    'database': _databaseName,

    'raise_on_warnings': True

    }



    db = mysql.connector.connect(**config)   
#*********************************************************************************

#*********************************************************************************
#*********************************************************************************
def disconnectDB( ):

    _function_name = "disconnectDB"



    logging.debug(f'[{_function_name}] disconnect from database ')



    global db



    db.close
#*********************************************************************************

#*********************************************************************************
#*********************************************************************************
def cursorDB ( sqlStatement ):



    _function_name = "cursorDB"



    logging.debug(f'[{_function_name}] cursor execution {sqlStatement} ')



    global db



    cursor = db.cursor()

    cursor.execute(sqlStatement)

    records = cursor.fetchall()



    return records

#*******************************************************************************
















