#***********************************************************************
# C:\Users\torad\Desktop\python311\python.exe fastcalc.py 2 + 4



from myModule import *

#limpa e mete as coisas mais bonitas
printSplash()

#dizer para o programa não ler o argomento 0 que é o fastcalc.py
arguments = len(sys.argv) - 1

#defenição de dos valores previamente dados
num1 = sys.argv[1]
op = sys.argv[2]
num2 = sys.argv[3]

#diferentes operações face a escolha 
if op == '+':
  Total = int(num1) + int(num2)
elif op == '-': 
  Total = int(num1) - int(num2)
elif op == '/':
  Total = int(num1) / int(num2)
elif op == '*':
  Total = int(num1) * int(num2)
else:
  print ('esta operação não é valida')

#resultado da conta
print ('o resultado é = ' + str(Total) )
