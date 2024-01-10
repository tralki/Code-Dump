import math

#Henrique Ribeiro nº25382
#Bruno Roque nº25391
#Rafael Sousa Nº25518
#Rafael Gaspar Nº24058

# Exercicio 1
exponente = 247
resto = exponente % 4

if resto == 0:
    resultado = 1
elif resto == 1:
    resultado = "i"
elif resto == 2:
    resultado = "-1"
else:
    resultado = "-i"

print(resultado)

# Exercicio 2
num = 17
for i in range(1, 11):
   print(num, 'x', i, '=', num*i)

# Exercicio 3

print('A quantidade de aulas que os alunos podem faltar é ',(4 * ( 4 * 5) * 3 ) - 0.9 * (4 * ( 4 * 5) * 3 ),"\n")

# Exercicio 4

d = float(input('Diâmetro do círculo: '))
r=(d/2)**2
pi=math.pi
area=pi*r
print("\nA área do círculo é: ", area)

# Exercicio 5
raiz = math.sqrt(500)

print(" \n raiz quadrada de ",raiz," \n ")

