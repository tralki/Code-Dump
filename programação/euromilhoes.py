#*****************************************************
# C:\Users\torad\Desktop\python311\python.exe euromilhoes.py

from myModule import *
import random

printSplash()

x= random.sample(range(1,51),5)
y= random.sample(range(1,13),2)

#mostrar resultados
print('as bolas seram : ' , x )
print('as estrelas seram: ' , y )
x.sort()
print('as bolas seram : ' , x )
y.sort()
print('as estrelas seram: ' , y )