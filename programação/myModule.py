#*****************************************************
# myModule code
import os
import sys 
from datetime import datetime 
import logging


# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
def getDateTime():
    now = datetime.now() # current date and time
    date_time = now.strftime("%d/%m/%Y %H:%M:%S.%f")[:-3]
    return date_time

# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
# *************************************************************** START BLOCK

def getNowDate():

    myDate = datetime.today().strftime('%Y-%m-%d')

    return myDate

# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
# *************************************************************** START BLOCK

def printSplash():



    _function_name = "[fn]" + "[printSplash]"



    os.system('cls' if os.name == 'nt' else 'clear')




    print ( "\n\n" )

    printString ( _function_name,"***********************************************************************" )

    printString ( _function_name,"system version is : " + sys.version )

    nowDateTime = getDateTime()

    printString ( _function_name,"date and time is :" + nowDateTime )

    printString ( _function_name,"***********************************************************************" )

    print ( "\n\n" )


# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
def printString( functionName , stringToPrint ):
    myString = "[" + getDateTime() + "]" + functionName + " " + stringToPrint
    print (myString)
# ***************************************************************   END BLOCK







# *************************************************************** START BLOCK
# *************************************************************** START BLOCK
# *************************************************************** START BLOCK

def getname():
    print(__name__)



# ***************************************************************   END BLOCK


# *************************************************************** START BLOCK

# *************************************************************** START BLOCK

# *************************************************************** START BLOCK

def setLogging( loglevel ):



    loglevel = logging.DEBUG



    # ***************************************************************************

    # logging configuration



    # coloredlogs.install(level=logging.DEBUG, logger=logger)

    logging.basicConfig (

                            level=loglevel,

                            format="%(asctime)s - %(levelname)s - %(message)s",

                            handlers=[

                                logging.FileHandler("debug.log",mode='w'),

                                logging.StreamHandler(sys.stdout)

                                ]

                        )




# ***************************************************************   END BLOCK

# *************************************************************** START BLOCK

# *************************************************************** START BLOCK

# *************************************************************** START BLOCK

def getListOfFiles ( dirToList ):



    _function_name = "[" + getListOfFiles.__name__ + "]"



    files = []

    for path in os.listdir(dirToList):

        # check if current path is a file

        if os.path.isfile(os.path.join(dirToList, path)):

            files.append(path)



    # print ( files )

    return files



# ***************************************************************   END BLOCK


# *************************************************************** START BLOCK

# *************************************************************** START BLOCK

# *************************************************************** START BLOCK

def moveFile ( inputFileName , destinationFileName ):



    _function_name = "[" + moveFile.__name__ + "]"



    status = 0

    errorMsg = ""



    logging.info(f'{_function_name} Input is : {inputFileName}')

    logging.info(f'{_function_name} Destination is : {destinationFileName}')



    try:

        os.rename( inputFileName , destinationFileName )

    except os.error as e:

        status = 1

        errorMsg = e

        return status , errorMsg

    finally:

        status = 0

        errorMsg = ""

        return status , errorMsg



# ***************************************************************   END BLOCK




