#*********************************************************************
# C:\Users\torad\Desktop\python311\python.exe Faturas.py
'''python.exe -m pip install pandas
   python.exe -m pip install datetime
   python.exe -m pip install fpdf2'''
 

import pandas as pd
from fpdf import FPDF
from datetime import datetime
now = datetime.now() # current date and time
date_time = now.strftime("%d/%m/%Y")
   
#igualamos uma variavel a ao ficheiro exel
inputFileName = "Trabalho_programação_I.xlsx"
count = 0
#premite que o python lêa o ficheiro exel
xl = pd.read_excel(inputFileName)
print("\n ******************************************")
#print(xl) #ele vai imprimir o ficheiro

for count in range(0,5):
   
   def faturas():
      pdf = FPDF()
      for count in range(0,5):
         Name=(xl.loc[count,'Nome'])
         Loc=(xl.loc[count,'Localização'])
         Con=(xl.loc[count,'Consumos de serviços'])
         Valcn=(xl.loc[count,'Valor dos consumos internet (MB)'])
         Valct=(xl.loc[count,'Valor dos consumos Telefone (min)'])
         Valan=float(xl.loc[count,'Valores associados internet'])
         Valat=float(xl.loc[count,'Valores associados Telefone'])
         Nconta = 123456789
         Ncontribo = 213545308
         pdf.add_page()
         pdf.set_font("helvetica","B", size=40)
         #pdf.image('gigachad.jpg', 10, 8, 39)
         pdf.image('gigachad.jpg', 125,50,70)
         pdf.image('a.jpg', 125,150,70)
         pdf.cell(200,30,txt='GigaNet and TV',ln=1 ,align="C")
         #pdf.cell(100, 20, txt='gigachad image', ln=1, align="L")
         #pdf.set_fill_color(255, 0, 0)
         #pdf.ellipse(10, 10, 10, 100, 'D')
         pdf.set_line_width(1)
         pdf.set_fill_color(100, 100, 0,)
         pdf.rect(10, 50, 190, 70)
         pdf.set_fill_color(0,0,0)
         pdf.rect(115, 50, 2, 70,"F")
         pdf.set_font("helvetica","B", size=20)
         pdf.cell(90,30, txt= 'Dados pessoais:',ln=1,align="L")
         pdf.set_font("helvetica", size=16)
         pdf.cell(62,7,txt= 'Nome: '+ Name , ln=1 , align="L")
         pdf.cell(62,7,txt= 'Plano: '+ Con , ln=1 , align="L")
         pdf.cell(62,7,txt= 'N Contribuite: '+ str(Nconta + count) , ln=1 , align="L")
         pdf.cell(62,7,txt= 'Localização: '+ Loc, ln=1 , align="L")
         pdf.cell(62,7,txt= 'N Conta: '+ str(Ncontribo + count), ln=1 , align="L")
         pdf.cell(62,7,txt= 'Data de Emição: '+ date_time , ln=1 , align="L")
         pdf.cell(62,7,txt= 'Data limite de pagamento: 25 Dezembro' , ln=1 , align="L")
         pdf.cell(62,14,txt= '', ln=1 , align="L")
         pdf.cell(62,0,txt= '**************************************************************************************', ln=1 , align="L")
         pdf.cell(62,1,txt= '**************************************************************************************', ln=1 , align="L")
         pdf.cell(62,7,txt= '' , ln=1 , align="L")
         pdf.cell(62,7,txt= '' , ln=1 , align="L")
         pdf.set_font("helvetica","B", size=20)
         pdf.cell(62,7,txt='Quantidade consumida:',ln=1 ,align="L")
         pdf.rect(10, 147, 85, 30)
         pdf.rect(10, 207, 85, 30)
         pdf.set_font("helvetica", size=18)
         #o que foi consumido
         pdf.cell(70,12,txt= ('Min consumidos: ' + str(Valct)) , ln=1 , align="L")
         pdf.cell(70,12,txt= ('MB consumidos: ' + str(Valcn)) , ln=1 , align="L")
         pdf.cell(62,28,txt= '' , ln=1 , align="L")
         pdf.set_font("helvetica","B", size=20)
         pdf.cell(62,9,txt= 'Valor a pagar:' , ln=1 , align="L")
         pdf.set_font("helvetica", size=20)
         #variavel do valor a pagar
         pdf.cell(62,6,txt=(str(Valan * Valcn) + '$' + ' + ' + str(Valat * Valct) + '$') , ln=1 , align="L")
         pdf.cell(62,6,txt= '--------------' , ln=1 , align="L")
         pdf.cell(62,7,txt=(str(Valan * Valcn + Valat * Valct) + '$') , ln=1 , align="L")
         pdf.set_font("helvetica","B", size=20)
         pdf.cell(62,40,txt= '*******************************************************************', ln=1 , align="L")
      pdf.output('recibo.pdf')
   
   Name=(xl.loc[count,'Nome'])
   Loc=(xl.loc[count,'Localização'])
   Con=(xl.loc[count,'Consumos de serviços'])
   Valcn=float(xl.loc[count,'Valor dos consumos internet (MB)'])
   Valct=float(xl.loc[count,'Valor dos consumos Telefone (min)'])
   Valan=float(xl.loc[count,'Valores associados internet'])
   Valat=float(xl.loc[count,'Valores associados Telefone'])
   print(Valcn)
   count += 1

if __name__ == '__main__':
   faturas()


#print(xl['Nome'])

