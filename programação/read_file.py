
from modulo_leitura_ficheiro import *




# C:\Users\torad\Desktop\python311\python.exe read_file.py


printLine ( "imprime lá isto")

opcao1 = 0

opcao2 = 0

opcao3 = 0

opcao4 = 0

opcao5 = 1

if opcao3 == 1:

    nome_do_ficheiro_a_ler = input("diga o nome do ficheiro, sff    ")

    print( nome_do_ficheiro_a_ler )



if opcao1 == 1:

   leitura_de_ficheiro_de_texto("file_2_read.txt")

if opcao2 == 1:

    leitura_de_ficheiro_csv(nome_do_ficheiro_a_ler)
   

if opcao4 == 1:

    leitura_de_ficheiro_distrital(nome_do_ficheiro_a_ler)

# segunda parte do program que vai calcular média e total
if opcao5 == 1:

    nome_do_ficheiro_a_ler = "employee.csv"

    leitura_de_ficheiro_dicionario(nome_do_ficheiro_a_ler)

