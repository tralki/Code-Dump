

# localização do python:
# D:\python\python3108\python.exe

# localização do código python
# D:\TeSP\programming\python

# executar com 
# D:\python\python3108\python.exe variaveis.py


print("hello today")




a = 1
b = 2

c = a * b 


print(c)

# ************************************************************
# parte 3 - variávies de texto e operação sobre elas

texto_1 = "hello"
texto_2 = "amanhã vai chover"

# print(texto_1)
# print(texto_2)

# print(texto_1 + " ***** " + texto_2)

texto_final = texto_1 + " " + texto_2
print(texto_final)


# print("o resultado é = " + str(c) )

ttt = "o resultado é = " + str(c)

print ( ttt)

# passo 4 - loop em string

i = 0

for letter in ttt: 
    i = i + 1  
    print("\nletra " + str(i) + " " + letter + "\n\n" )



x = 2
y = 2

z = x*y
print( "z = " + str(z) + " e a variável é do tipo " + str(type(z)) )


x = 2.6287346823
y = 2

z = x*y
print( "z = " + str(z) + " e a variável é do tipo " + str(type(z)) )

