from fpdf import FPDF  # C:\Users\torad\Desktop\python311\python.exe try.py
pato = 'Marcos'
money = 'Fatura: ' + pato 

pdf = FPDF(orientation='P', unit='mm', format='A4')
pdf.add_page()
pdf.set_font("helvetica", size=12)
pdf.cell(200, 200, txt="Welcome to Python!", ln=1, align="C")
pdf.output("simple_demo.pdf")
'''
def draw_lines():
    pdf = FPDF()
    pdf.add_page()
    pdf.line(10, 10, 10, 100)
    pdf.set_line_width(10)
    pdf.set_draw_color(255, 0, 0)
    pdf.line(20, 20, 100, 20)
    pdf.output('draw_lines.pdf')
    
if __name__ == '__main__':
    draw_lines()
'''
def draw_shapes():
    pdf = FPDF()
    pdf.add_page()
    pdf.set_font("helvetica","B", size=40)
    #pdf.image('gigachad.jpg', 10, 8, 39)
    pdf.image('gigachad.jpg', 125,50,70)
    pdf.cell(200,30,txt='GigaNet and TV',ln=1 ,align="C")
    #pdf.cell(100, 20, txt='gigachad image', ln=1, align="L")
  #  pdf.set_fill_color(255, 0, 0)
    # pdf.ellipse(10, 10, 10, 100, 'D')
    pdf.set_line_width(1)
    pdf.set_fill_color(100, 100, 0,)
    pdf.rect(10, 50, 190, 70)
    pdf.set_fill_color(0,0,0)
    pdf.rect(115, 50, 2, 70,"F")
    pdf.set_font("helvetica","B", size=20)
    pdf.cell(90,30, txt= 'Dados pessoais:',ln=1,align="L")
    pdf.set_font("helvetica", size=16)
    pdf.cell(62,7,txt= 'Nome: '+ pato , ln=1 , align="L")
    pdf.cell(62,7,txt= 'Plano: '+ pato , ln=1 , align="L")
    pdf.cell(62,7,txt= 'N Contribuite: '+ pato , ln=1 , align="L")
    pdf.cell(62,7,txt= 'N Referencia: '+ pato , ln=1 , align="L")
    pdf.cell(62,7,txt= 'N Conta: '+ pato , ln=1 , align="L")
    pdf.cell(62,7,txt= 'Data de Emição: '+ pato , ln=1 , align="L")
    pdf.cell(62,7,txt= 'Data limite de pagamento: '+ pato , ln=1 , align="L")
    pdf.cell(62,14,txt= '', ln=1 , align="L")
    pdf.cell(62,0,txt= '**************************************************************************************', ln=1 , align="L")
    pdf.cell(62,1,txt= '**************************************************************************************', ln=1 , align="L")
    pdf.cell(62,7,txt= '' , ln=1 , align="L")
    pdf.cell(62,7,txt= '' , ln=1 , align="L")
    pdf.set_font("helvetica","B", size=20)
    pdf.cell(62,7,txt='Quantidade consumida:',ln=1 ,align="L")
    pdf.rect(10, 147, 85, 30)
    pdf.rect(10, 207, 85, 30)
    pdf.set_font("helvetica", size=16)
    #o que foi consumido
    pdf.cell(62,14,txt= 'DATAERROR' , ln=1 , align="L")
    pdf.cell(62,7,txt= 'DATAERROR' , ln=1 , align="L")
    pdf.cell(62,30,txt= '' , ln=1 , align="L")
    pdf.set_font("helvetica","B", size=20)
    pdf.cell(62,10,txt= 'Valor a pagar:' , ln=1 , align="L")
    pdf.set_font("helvetica", size=20)
    #variavel do valor a pagar
    pdf.cell(62,7,txt= 'Valor a pagar:' , ln=1 , align="L")
    pdf.cell(62,7,txt= '--------------' , ln=1 , align="L")
    pdf.cell(62,7,txt= 'Valor a pagar:' , ln=1 , align="L")
    pdf.set_font("helvetica","B", size=20)
    pdf.cell(62,40,txt= '*******************************************************************', ln=1 , align="L")
    pdf.output('draw_shapes.pdf')

if __name__ == '__main__':
    draw_shapes()
'''
class PDF(FPDF):
    def lines(self):
        self.set_line_width(0.0)
        self.line(0,pdf_h/2,210,pdf_h/2)
#default
pdf = PDF(orientation='P', unit='mm', format='A4')

pdf.add_page()

pdf_w=210
pdf_h=297



pdf.output('test.pdf','')'''

