

#**************************************************************************
# C:\Users\torad\Desktop\python311\python.exe loops.py


#my code
from myModule import *

def main():
    printSplash()
    getname()    

    fruits = ['apple . banana . cherry']
    for x in fruits:
        print(x)
    print('**********************************')

    for p in 'banana':
        print(p)
    print('**********************************')

    fruits = ['apple' , 'banana' , 'cherry']
    for p in fruits:
        print(p)
        if p == 'banana':
            break
    print('*********************************')

    fruits = ['apple' , 'banana' , 'cherry']
    for p in fruits:
        if p == 'banana':
            continue
        print(p)
    print('*********************************')

    for p in range (6):
        print(p)
    print('********************************')

    for p in range (2,6):
        print(p)
    print('**********************************')

    for p in range (2,30,3):
        print(p)
    print('***********************************')

    adj = ['red','big','tasty']
    fruits = ['apple','banana','cherry']

    for p in adj:
        for y in fruits:
            print(p,y)

if __name__ == '__main__':
    main() 

    print(__name__)
