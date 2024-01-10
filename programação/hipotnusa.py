#*********************************************************************
# C:\Users\torad\Desktop\python311\python.exe hipotnusa.py


from myModule import *

printSplash()


#defenimos as variaveis
h = 0 #altura
b = 0 #base 
total = 0 #hipotnusa 

#inserção das variaveis pelo utilizador
h = input('escolha a altura do seu triangulo ')
b = input('escolha o tamanho da base do seu triangulo ')

#calculo da hipotnusa
total = (int(h)*int(h) + int(b)*int(b)) ** 0.5

#texto final
print('\n**************************************************************************')
print('a hipotnusa do triangulo de altura ' + str(h) + ' e de base ' + str(b) + ' é igual a '  + str(total))

