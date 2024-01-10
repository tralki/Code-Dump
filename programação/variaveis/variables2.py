# ****************************************************************************
# my code 
# from myModule import *

import myConstants as mc
import math

print ( mc.PI ) 
print ( mc.GRAVITY ) 





# printSplash()



print( "********************************************************************************" )
print ( "Variables 2 - example 1\n" )

a,b,c = 5,3.2,"Hello"

print ( "a = " + str(a))
print ( "b = " + str(b))
print ( "c = " + str(c))

print ( "a is " + str(type(a)) )
print ( "b is " + str(type(b)) )
print ( "c is " + str(type(c)) )


print( "a = " + str(a) + "b = " + str(b) + "c = " + c  ) # variante do JCA
print( "a = " + str(a) + " b = " + str(b) + " c = " + c  ) # variante do JCA

print( "a = " + str(a), "b = " + str(b), "c = " + str(c)) # variante do Carlos

# quit()


print( "********************************************************************************")
print ( "Variables 2 - example 2\n")

a = b = c = "carro"

print ( "a = " + str(a))
print ( "b = " + str(b))
print ( "c = " + str(c))

print ( "a is " + str(type(a)) )
print ( "b is " + str(type(b)) )
print ( "c is " + str(type(c)) )



print( "a = " + str(a) + "b = " + str(b) + "c = " + c  ) # variante do JCA
print( "a = " + str(a) + " b = " + str(b) + " c = " + c  ) # variante do JCA

print( "a = " + str(a), "b = " + str(b), "c = " + str(c)) # variante do Carlos





print( "********************************************************************************")
print ( "Variables 2 - example 3\n")

PI = 3.1415926535897932384
GRAVITY = 9.80665 #  m/s2

print ( "PI = " + str(PI))
print ( "GRAVITY = " + str(GRAVITY))

print ( "PI is " + str(type(PI)) )
print ( "GRAVITY is " + str(type(GRAVITY)) )



print( "********************************************************************************")
print ( "Variables 2 - example 4\n")

print ( "mc.PI = " + str(mc.PI))
print ( "mc.GRAVITY = " + str(mc.GRAVITY))

print ( "mc.PI is " + str(type(mc.PI)) )
print ( "mc.GRAVITY is " + str(type(mc.GRAVITY)) )




print( "********************************************************************************")
print ( "Variables 2 - example 5\n")

# Area of a circle is circleArea = PI * square ( radius ) 
# hipotenusa = squareroot ( base2 + altura2 )

radius = 2

radiusSquare = radius * radius
print ( "1 - radiusSquare = " + str(radiusSquare))
print ( "1 - radiusSquare is " + str(type(radiusSquare)) )

radiusSquare = radius**2
print ( "2 - radiusSquare = " + str(radiusSquare))
print ( "2 - radiusSquare is " + str(type(radiusSquare)) )


radiusSquare = pow(radius, 2)
print ( "3 - radiusSquare = " + str(radiusSquare))
print ( "3 - radiusSquare is " + str(type(radiusSquare)) )


radiusSquareRoot = radius**(0.5)
print ( "4 - radiusSquareRoot = " + str(radiusSquareRoot))
print ( "4 - radiusSquareRoot is " + str(type(radiusSquareRoot)) )


radiusSquareRoot = math.sqrt(radius)
print ( "5 - radiusSquareRoot = " + str(radiusSquareRoot))
print ( "5 - radiusSquareRoot is " + str(type(radiusSquareRoot)) )

