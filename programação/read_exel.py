#**********************************************************************************************************************

# C:\Users\torad\Desktop\python311\python.exe read_exel.py

from myModule import *


import pandas 


printSplash()




inputFileName = "Alunos.xlsx"

#abre o exel
xl = pandas.read_excel(inputFileName)

print("\n ******************************************")

print(xl)
print("\n*******************************************")

print(xl.index)
print("\n*******************************************")

print(xl.columns)
print("\n*******************************************")

print(xl.shape)
print("\n*******************************************")

print(xl['Nome'])
print("\n*******************************************")

print(xl['Disciplina'])
print("\n*******************************************")

print(xl['Numero Aluno'])
print("\n*******************************************")

print(xl[['Disciplina' , 'Numero Aluno' , 'Nome' ]])
print("\n*******************************************")

print(xl.loc[0,'Nome'])
print("\n*******************************************")

print(xl.loc[2])
print("\n*******************************************")

print(xl['Disciplina'][2])
print("\n*******************************************")

salario_total = 0


for numero in range(0,4):
    salario = xl['Numero Aluno'][numero]
    salario_total = salario_total + salario 

print(salario_total)
