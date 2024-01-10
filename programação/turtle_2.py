import turtle
import math

mars = turtle.Turtle()
earth = turtle.Turtle()

def way_to_orbit(x,y, object, colors):
    object.dot(50, "yellow")
    object.color("white")
    object.fillcolor(colors)
    object.shape("circle")
    object.penup()
    object.setposition(x, y)
    object.pendown()

def ellipse(object1, object2):

    loop = True
    object2_xvel = 0
    object2_yvel = 1
    object1_xvel = 0
    object1_yvel = 1

    while loop:
        object2_xvel += math.cos(math.radians(object2.towards(0, 0))) * (1000 / (object2.xcor() ** 2 + object2.ycor() ** 2))
        object2_yvel += math.sin(math.radians(object2.towards(0, 0))) * (1000 / (object2.xcor() ** 2 + object2.ycor() ** 2))
        object2.setposition(object2.xcor() + object2_xvel, object2.ycor() + object2_yvel)

        object1_xvel += math.cos(math.radians(object1.towards(0, 0))) * (1000 / (object1.xcor() ** 2 + object1.ycor() ** 2))
        object1_yvel += math.sin(math.radians(object1.towards(0, 0))) * (1000 / (object1.xcor() ** 2 + object1.ycor() ** 2))
        object1.setposition(object1.xcor() + object1_xvel, object1.ycor() + object1_yvel)

way_to_orbit(620, 0, mars, "red")
way_to_orbit(375, 0, earth, "blue")

ellipse(mars, earth)

turtle.done()


