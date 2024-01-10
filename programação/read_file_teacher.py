
# localizacao do python:
# D:\python\python3108\python.exe

# localização do código python
# D:\TeSP\programming\python

# executar com 
# D:\python\python3108\python.exe variaveis.py

opcao1 = 0
opcao2 = 1




if opcao1 == 1:

    fileToOpen = "file_to_read.txt"

    # Using readline()
    file1 = open(fileToOpen, 'r')

    count = 0
    
    while True:
        count += 1

        # Get next line from file
        line = file1.readline()

        # if line is empty
        # end of file is reached
        if not line:
            break

        print("Line {}: {}".format(count,line.strip()))

        # print("esta é a linha " + str(count) )
        # print ( line.strip() )
    
    file1.close()




# segunda parte do program que vai calcular média e total


if opcao2 == 1:

    fileToOpen = "employee.csv"


    count = 0
    count_dados = 0

    salario_total = 0
    idade_total = 0


    # Using readline()
    file2 = open(fileToOpen, 'r')
    while True:
        count += 1
        
        # Get next line from file
        line = file2.readline()

        # if line is empty
        # end of file is reached
        if not line:
            break

        if count == 1:
            pass
            # print(line)

        if count > 1:
            # print(line) 

            count_dados += 1
            items = line.split(",") 

            nome = items[0]
            idade = items[1]
            salario = items[2]

            if int(idade) <= 0:
                print ( "ERRRO - Idade não válida na linha  " + str(count))
                quit()

            salario_total += int(salario)
            idade_total += int(idade)

            # print("nome = " + nome + " idade = " + idade + " salario = " + salario )  



        # print(line)


    idade_media = idade_total / count_dados
    print ( "salario total = " + str(salario_total) )
    print ( "idade media = " + str(idade_media))
    print ( "total de linhas a contabilizar = " + str(count_dados) )


    file2.close()
