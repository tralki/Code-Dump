# ****************************************************************************
# my code 

# exemplos de numeração binária em python

num1 = "0b100"

print ( "num1 = " + str(num1))
print ( "num1 is " + str(type(num1)) )


num1 = 0b100

print ( "num1 = " + str(num1))
print ( "num1 is " + str(type(num1)) )

num1 = 0b100 # em decimal = 4
num2 = 0b110 # em decimal = 6

mySum = num1 * num2

print ( "mySum = " + bin(mySum))
print ( "mySum is " + str(type(mySum)) )



# exemplos de numeração binária em hexadecimal
hnum1 = 0xF0
hnum2 = 0x10

sumHnum = hnum1 * hnum2
print ( "sumHnum = " + hex(sumHnum))
print ( "sumHnum is " + str(type(sumHnum)) )


# exemplos de numeração binária em octal


onum1 = 0o10
onum2 = 0o10

sumOnum = onum1 * onum2
print ( "sumOnum = " + oct(sumOnum))
print ( "sumOnum is " + str(type(sumOnum)) )


print(hex(255))  # decimal
print(hex(0b111))  # binary
print(hex(0o77))  # octal
print(hex(0XFF))  # hexadecimal


print(bin(256))
print(bin(0b111))  # binary
print(bin(0o77))  # octal
print(bin(0XFF))  

print(oct(256))
print(oct(0b111))  # binary
print(oct(0o77))  # octal
print(oct(0XFF))  
