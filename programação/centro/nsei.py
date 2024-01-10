# C:\Users\torad\Desktop\python311\python.exe nsei.py
results = input('Enter the marks seperated by space ')
lista = []
i = 0
q = "true"
for result in results:
    
    if results[i] != " ":
        lista.append(int(results[i]))

    i = int(i) + 1
i = 0
for result in lista:
    
    if i == len(lista) - 1:
        break
    if lista[i] > lista[i+1]:
        q = "false" 
    i = int(i) + 1

if q == "false":
    print("No stable product")
else:
    print("Stable product")
