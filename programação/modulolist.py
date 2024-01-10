#************************************************************
#C:\Users\torad\Desktop\python311\python.exe modulolist.py
#************************************************************

#começei por importar os modulos necessarios
import subprocess
import sys
from pprint import pprint

#após isso eu defeni a variavel ip onde usei o modulo para fazer com que o comando -m pip freeze fosse executado 
ip = reqs = subprocess.check_output([sys.executable, '-m', 'pip', 'freeze']).decode('utf-8')

#de seguida eu eleminei umas letras desnecessarias que apareciam ao correr este codigo
ip = ip.split('\r\n')

#por fim a demonstração dos modulos com as suas respetivas verções
pprint(ip)














