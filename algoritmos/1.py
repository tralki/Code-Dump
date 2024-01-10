# C:\Users\torad\Desktop\python311\python.exe 1.py

import math
import timeit

print("hello world")

print(2+3 , 2*3 , 2/3 ,2-3 , 10//3 , 10%2 , 4**0.5 , math.sqrt(9) )

print('A quantidade de aulas que os alunos podem faltar é ',(4 * ( 4 * 5) * 3 ) - 0.9 * (4 * ( 4 * 5) * 3 ),"\n")


def save (x,L=[]):
    L.append(x)
    print *L
    return L
def union (*args):
    res = []
    for seq in args:
        for x in seq:
            if x not in res:
                res.append(x)
    return res

#_______________________--
'''
a = 0
b = 0
c = 0
print('Quais são os numeros da sua função quadratica')

a = input('1º termo ')
b = input('2º termo ')
c = input('3º termo ')

alpha = (int(b)**2 - 4 * int(a) * int(c)) ** 0.5
xplus = (-int(b) + alpha) / (2*int(a))
xminus = (-int(b) - alpha) / (2*int(a))

print ('Os zeros da sua expreçãos são ' , xplus , xminus,"\n\n\n")
'''
#_______________________--


def faturial1 (n):
    if (n==0):
        y=1
    else :
        y = faturial1 (n-1) * n
    return y

start = timeit.timeit()
print ('temp1 ',faturial1(996))
end = timeit.timeit()
print(end - start)

def faturial2 (n):
    y = 1
    for i in range (1,n+1):
        y=y*i
    return y

start1 = timeit.timeit()
print ('temp2 ',faturial2(996))
end1 = timeit.timeit()
print(end1 - start1)

#_______________________--

import cmath

def simplificar_numero_complexo(base, expoente):
    # Calcula o resto da divisão do expoente por 4
    resto = expoente % 4
    
    # Aplica as propriedades dos números complexos para simplificar o número
    if resto == 0:
        resultado = 1
    elif resto == 1:
        resultado = base
    elif resto == 2:
        resultado = -1
    else:
        resultado = -base
    
    return resultado

# Exemplo de uso
base = complex(0, 1)  # Representa o número complexo i
expoente = 247

resultado = simplificar_numero_complexo(base, expoente)
print(resultado)