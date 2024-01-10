import mysql.connector



# executar com 
# D:\python\python3108\python.exe blob_retrieve.py
# deve estar instalado este módulo ..... mysql-connector-python





def write_file(data, filename):
    # Convert binary data to proper format and write it on Hard Disk
    with open(filename, 'wb') as file:
        file.write(data)


def readBLOB(emp_id, photo, bioData):
    print("Reading BLOB data from python_employee table")

    try:
        connection = mysql.connector.connect(host='localhost',
                                             database='datawarehouse',
                                             user='datawarehouse',
                                             password='datawarehouse')

        cursor = connection.cursor()
        sql_fetch_blob_query = """SELECT * from python_employee where id = %s"""

        cursor.execute(sql_fetch_blob_query, (emp_id,))
        record = cursor.fetchall()
        for row in record:
            print("Id = ", row[0], )
            print("Name = ", row[1])
            image = row[2]
            file = row[3]
            print("Storing employee image and bio-data on disk \n")
            write_file(image, photo)
            write_file(file, bioData)

    except mysql.connector.Error as error:
        print("Failed to read BLOB data from MySQL table {}".format(error))

    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")


readBLOB(1, "D:\\TeSP\\programming\\python\\cat1_retrieve.jpeg",
         "D:\\TeSP\\programming\\python\\text_retrieve_1.txt")


readBLOB(2, "D:\\TeSP\\programming\\python\\cat2_retrieve.jpeg",
         "D:\\TeSP\\programming\\python\\text_retrieve_2.txt")



readBLOB(3, "D:\\TeSP\\programming\\python\\gatinhos_fofinhos.mp4",
         "D:\\TeSP\\programming\\python\\text_retrieve_3.txt")





