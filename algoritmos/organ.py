# C:\Users\torad\Desktop\python311\python.exe
import math
x = [72, 29, 38, 22, 60, 2]
i = int  (0)
j = int  (1)
for num in range(0,2) :
    for numa in range(0,5) , x[i] > x[j]:
        x[i] = x[j]
        j = j+1
        if x[i] > x[j]:
            break
        i = i+1
    j = 1
    if i == 3:
        break


for i in range(0,6) :
    print(x[i])
    i = i+1
    if i == 6:
        break

 