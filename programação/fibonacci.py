#*********************************************************************
# C:\Users\torad\Desktop\python311\python.exe fibonacci.py
from myModule import *

# fibonacci sequencia
# 0 1 1 2 3 5 8 13 21 34 55 89 144 233 ....





printSplash()

'''

n1,n2 = 0,1
count = 0
nterms=100

if nterms <= 0:
    print('please enter a positive integer')
elif nterms == 1:
    print('fibonacci sequence upto',nterms,':')
    print(n1)
else:
    print('fibonacci sequence:')
    while count<nterms:
        print(n1)
        nth=n1+n2
        n1=n2
        n2=nth
        count +=1 

'''

# Python program to display the Fibonacci sequence



def recur_fibo(n):

   if n <= 1:

       return n

   else:

       return(     recur_fibo(n-1)      +     recur_fibo(n-2)      )



nterms = 10



# check if the number of terms is valid

if nterms <= 0:

   print("Plese enter a positive integer")

else:

   print("Fibonacci sequence:")

   for i in range(nterms):

       print(recur_fibo(i))

