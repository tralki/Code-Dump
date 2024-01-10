# C:\Users\torad\Desktop\python311\python.exe rvtools_processing.py
#**********************************************************************************
'''

Package                Version

---------------------- -----------

et-xmlfile             1.1.0

greenlet               2.0.1

mariadb                1.1.5.post3

mysql-connector-python 8.0.31

numpy                  1.23.4

openpyxl               3.0.10

packaging              21.3

pandas                 1.5.1

pip                    22.3.1

protobuf               3.20.1

pygame                 2.1.2

PyMySQL                1.0.2

pyparsing              3.0.9

python-dateutil        2.8.2

PythonTurtle           0.3.2

pytz                   2022.5

setuptools             63.2.0

six                    1.16.0

SQLAlchemy             1.4.44

wheel                  0.37.1



python.exe -m pip install mariadb pymysql sqlalchemy openpyxl pygame PythonTurtle mysql-connector-python numpy pandas



'''

import sys

from myModule import *
import pandas as pd

import logging 


from sqlalchemy import create_engine

from sqlalchemy import inspect

from sqlalchemy import MetaData

from sqlalchemy.ext.declarative import declarative_base

from sqlalchemy import Table

from myDB_MYSQL import *


# ************************************************************************
_function_name = __name__
# ************************************************************************

def main():



    # ***************************************************************************

    # logging configuration

    setLogging( logging.ERROR )

    printSplash()



   
    # sheetnames = [ 'vInfo' , 'vDisk' , 'vPartition' , 'vNetwork' , 'vCluster' , 'vHost' , 'vHealth' ]
    sheetnames = [ 'vInfo' , 'vDisk' , 'vHost' ]


    pathToProcess = "C:\\Users\\torad\\Desktop\\importante\\programação\\"

    # dialect[+driver]://user:password@host/dbname
    # engine = create_engine('postgresql://datawarehouse:datawarehouse@localhost:5432/datawarehouse')
    engine = create_engine("mysql+pymysql://datawarehouse:datawarehouse@localhost:3306/datawarehouse?charset=utf8mb4")


    option_load_all_files = 0
    option_process_data = 1 

    if option_load_all_files == 1:
        
        files = getListOfFiles(pathToProcess)

        for f1 in files:

            if "Rvtools.xlsx" in f1:
                print ( "found file " + f1 )
                    
                for sn in sheetnames:
                    
                    sheetName = sn

                    df = pd.read_excel(f1, sheet_name=sheetName,engine='openpyxl')

                    # number_of_rows = len(df)
                    # number_of_columns = len(df.columns)

                    #logging.debug(f'{_function_name} size of sheet is # rows = {str(number_of_rows)} and # columns = {str(number_of_columns)} ')
            
                    table_name = sn.lower()

                    logging.debug(f'{_function_name} table name is {table_name}')

                    df.to_sql(table_name,engine,if_exists='replace')


                    # destinationFileName = pathFilesProcessed + "/" + f1
                    # moveStatus, myError = moveFile(complete_file_name, destinationFileName)

                    # if (moveStatus > 0):

                        # logging.error(f'{_function_name} Moving files went wrong !!' )
                        # logging.error(f'{_function_name} Error is : {myError}' )

    if option_process_data == 1:



        logging.debug(f'[{_function_name}] processing data in database ')

        connectDB ( '127.0.0.1' , 3306 , 'datawarehouse' , 'datawarehouse' , 'datawarehouse' )



        data = cursorDB( "select VM , CPUs , Memory , `Provisioned MB` from vinfo limit 5 "  )



        for row in data:



            vm = row[0]

            cpus = row[1]

            memory = row[2]

            provisionedMB = row[3]



            s = "vm = " + str(vm) + " cpus = " + str(cpus) + " memory = " + str(memory) + " privioned MB = " + str(provisionedMB)



            print (s)



        disconnectDB()



# main code

if __name__ == "__main__":

    main()



# ************************************************************************

# ************************************************************************