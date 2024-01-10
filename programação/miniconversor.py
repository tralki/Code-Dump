#************************************************************
#C:\Users\torad\Desktop\python311\python.exe miniconversor.py
#************************************************************

#primeiro transformo o meu ficheiro txt em uma variavel 
fileToOpen = 'input.txt'

#criei uma defenição para no fim poder criar um ficheiro output.txt
def lowercase():
    #criei um ciclo with para ele ler me o input,txt
    with open(fileToOpen, 'r') as x: 
        text = x.read() 
    #aqui passei o texto do input.txt para lower case
    text = text.lower()
    #aqui estou a mandar o codigo criar e escrever o texto em lower case no output.txt
    x= open("output.txt","w+")
    x.write(text)


#aqui eu mando ele correr a minha defenição
if __name__ == "__main__":
    lowercase()












