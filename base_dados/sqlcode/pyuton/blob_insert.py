import mysql.connector


# executar com 
# D:\python\python3108\python.exe blob_insert.py
# deve estar instalado este módulo ..... mysql-connector-python




def convertToBinaryData(filename):
    # Convert digital data to binary format
    with open(filename, 'rb') as file:
        binaryData = file.read()
    return binaryData


def insertBLOB(emp_id, name, photo, biodataFile):
    print("Inserting BLOB into python_employee table")
    try:


        connection = mysql.connector.connect(host='localhost',
                                             database='datawarehouse',
                                             user='datawarehouse',
                                             password='datawarehouse')




        cursor = connection.cursor()


        sql_insert_blob_query = """ INSERT INTO python_employee
                          (id, name, photo, biodata) VALUES (%s,%s,%s,%s)"""

        empPicture = convertToBinaryData(photo)
        file = convertToBinaryData(biodataFile)

        # Convert data into tuple format
        insert_blob_tuple = (emp_id, name, empPicture, file)
        result = cursor.execute(sql_insert_blob_query, insert_blob_tuple)
        connection.commit()
        print("Image and file inserted successfully as a BLOB into python_employee table", result)

    except mysql.connector.Error as error:
        print("Failed inserting BLOB data into MySQL table {}".format(error))

    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")



insertBLOB(3, "gatos video", "D:\\TeSP\\programming\\python\\gatos.mp4",
           "D:\\TeSP\\programming\\python\\sample-2mb-text-file.txt")





# insertBLOB(2, "Cat 2", "D:\\TeSP\\programming\\python\\cat2.jpeg",
#            "D:\\TeSP\\programming\\python\\sample-2mb-text-file.txt")





