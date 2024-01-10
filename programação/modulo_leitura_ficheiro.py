
# módulo para ler ficheiros

# ****************************** START BUILD
def printLine ( texto  ):
    print ( texto )


# ****************************** END BUILD


# ****************************** START BUILD
def leitura_de_ficheiro_de_texto ( nome_de_ficheiro_a_ler ):

    fileToOpen = nome_de_ficheiro_a_ler




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
            print("Line {}: {}".format(count, line.strip()))

    file1.close()

# ****************************** END BUILD

# ****************************** START BUILD 

def leitura_de_ficheiro_csv (nome_do_ficheiro_a_ler):

    fileToOpen = nome_do_ficheiro_a_ler

    count = 0
    count_dados = 0
    salario_total = 0
    idade_total = 0

    file2 = open(fileToOpen, 'r')

    while True:

            count += 1

            line = file2.readline()

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
                    print( "ERRO - Idade não valida na linha " + str(count))
                    quit()
                salario_total += int(salario)
                idade_total += int(idade)

                #print("nome =" + nome + " idade = " + idade + " salario = " + salario)


                print(items)

    idade_media = idade_total / count_dados 
    print( "salario total =" + str(salario_total ))
    print( idade_total )
    print( "idade media =" + str(idade_media ))
    print( count_dados )

    file2.close() 


# ****************************** END BUILD

# ****************************** START BUILD

def leitura_de_ficheiro_distrital (nome_do_ficheiro_a_ler):

    fileToOpen = nome_do_ficheiro_a_ler

    count = 0
    count_dados = 0

    salario_total = 0
    idade_total = 0

    total_salarios_lisboa = 0
    total_idade_lisboa = 0
    quantidade_lisboa = 0
    media_idade_lisboa = 0
    total_salarios_faro = 0
    total_idade_faro = 0
    quantidade_faro = 0
    media_idade_faro = 0
    total_salarios_porto = 0
    total_idade_porto = 0
    quantidade_porto = 0
    media_idade_porto = 0 
    total_salario_resto = 0
    total_idade_resto = 0
    quantidade_resto = 0
    media_idade_resto = 0


    file2 = open(fileToOpen, 'r')

    while True:

            count += 1

            line = file2.readline()
            line = line.strip()

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
                distritos = items[3]

                    
                    #se for lisboa x , se for porto x , se for faro x
                if int(idade) <= 0:
                    print( "ERRO - Idade não valida na linha " + str(count))
                    quit()
                    salario_total += int(salario)
                    idade_total += int(idade)

                match distritos:
                    case 'porto':
                        total_salarios_porto += int(salario)
                        total_idade_porto += int(idade)
                        quantidade_porto += 1
                        media_idade_porto = total_idade_porto/quantidade_porto
                    case 'lisboa':
                        total_salarios_lisboa += int(salario)
                        total_idade_lisboa += int(idade)
                        quantidade_lisboa += 1
                        media_idade_lisboa = total_idade_lisboa/quantidade_lisboa
                    case 'faro':
                        total_salarios_faro += int(salario)
                        total_idade_faro += int(idade)
                        quantidade_faro += 1
                        media_idade_faro = total_idade_faro/quantidade_faro
                    case other:
                        total_salario_resto += int(salario)
                        total_idade_resto += int(idade)
                        quantidade_resto += 1
                        media_idade_resto = total_idade_resto/quantidade_resto


                #print("nome =" + nome + " idade = " + idade + " salario = " + salario)



                #print(items)

  #  idade_media = idade_total / count_dados 
   # print( "salario total =" + str(salario_total ))
    #print( idade_total )
    #print( "idade media =" + str(idade_media ))
    #print( count_dados )

    file2.close() 

    print('-------------------------------------------')
    print('salario total de porto = ' + str(total_salarios_porto ))
    print('-------------------------------------------')
    print('salario total de lisboa = ' + str(total_salarios_lisboa))
    print('-------------------------------------------')
    print('salario total de faro = ' + str(total_salarios_faro))
    print('-------------------------------------------')
    print('salario total de outros distritos = ' + str(total_salario_resto))
    print('-------------------------------------------')
    print('-------------------------------------------')
    print('media de idades de porto = ' + str(media_idade_porto))
    print('-------------------------------------------')
    print('media de idades de lisboa = ' + str(media_idade_lisboa))
    print('-------------------------------------------')
    print('media de idades de faro = ' + str(media_idade_faro))
    print('-------------------------------------------')
    print('media de idades de outros distritos = ' + str(media_idade_resto))
    print('-------------------------------------------')
# ****************************** END BUILD

# ****************************** START BUILD

def leitura_de_ficheiro_dicionario ( nome_do_ficheiro_a_ler ):



    # fileToOpen = "employee.csv"



    fileToOpen = nome_do_ficheiro_a_ler




    myIdade = { }

    mySalario = { }

    count = 0
    count_dados = 0
    salario_total = 0
    idade_total = 0

    file2 = open(fileToOpen, 'r')

    while True:

            count += 1

            line = file2.readline()
            line = line.strip()

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
                regiao = items[3]

                    
                    #se for lisboa x , se for porto x , se for faro x
                if int(idade) <= 0:
                    print( "ERRO - Idade não valida na linha " + str(count))
                    quit()
                    salario_total += int(salario)
                    idade_total += int(idade)

                if regiao in myIdade:

                # key already exists

                    value = myIdade.get(regiao)

                    value = value + int(idade)

                    myIdade.update({regiao:value})



                else:

                # add new key

                    myIdade[regiao] = int(idade)






                if regiao in mySalario:

                # key already exists

                    value = mySalario.get(regiao)

                    value = value + int(salario)

                    mySalario.update({regiao:value})



                else:

                    # add new key

                    mySalario[regiao] = int(salario)
    print(myIdade)
    print(mySalario)





