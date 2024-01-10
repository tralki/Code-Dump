#*******************************************************
# C:\Users\torad\Desktop\python311\python.exe turtle_1.py


import turtle
'''
polygon_ = turtle.Turtle()
for i in range(6):
    polygon_.forward(100)
    polygon_.right(300)
turtle.done()
'''
star = turtle.Turtle()

num_of_sides = 5

length_of_side = 50

each_angle = 720.0 / num_of_sides

for i in range(num_of_sides):

    star.forward(length_of_side)

    star.right(each_angle)

turtle.done()
