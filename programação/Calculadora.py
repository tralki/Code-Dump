#tentativa de calculadora pelo aluno Rafael Nº25518

# C:\Users\torad\Desktop\python311\python.exe Calculadora.py

#defenir as variaveis nessessarias
from myModule import *

printSplash()

numero1 = 0
numero2 = 0
# op = 0


#inserção das variaveis pelo utilizador
numero1 = input('calculadora simples por favor insira um valor ')

numero2 = input('agora insira outro valor ')
# defenição das operações permitidas 
op = None
while     op != 'soma'     and  op != 'sub'       and        op != 'vezes'      and      op != 'div':

    op = input('escolha uma operação (soma, sub, vezes, div) ')
# maneira de escolha de operação
if op == 'soma' :
    resultado = int(numero1) + int(numero2)
elif op == 'sub' :
    resultado = int(numero1) - int(numero2)
elif op == 'vezes' :
    resultado = int(numero1) * int(numero2)
else:
    resultado = int(numero1) / int(numero2)

# demontração do resultado    
print('o resultado é igual = ' + str(resultado) )


       

