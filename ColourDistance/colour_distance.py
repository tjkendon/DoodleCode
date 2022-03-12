import math

def colour_value ( name ):
	"Split name into 3 hex tuples"
	return (int(name[0:2], 16), int(name[2:4], 16), int(name[4:6], 16))

def colour_distance ( colour_1, colour_2 ):
	"Find the distance between these 2 colours (as points)"
	return math.sqrt( (colour_2[0]-colour_1[0])*(colour_2[0]-colour_1[0]) + (colour_2[1]-colour_1[1])*(colour_2[1]-colour_1[1]) + (colour_2[2]-colour_1[2])*(colour_2[2]-colour_1[2]) )

colour_name_1 = input("Colour 1: ")
colour_name_2 = input("Colour 2: ")

colour_1 = colour_value( colour_name_1 )
colour_2 = colour_value( colour_name_2 )

distance = colour_distance(colour_1, colour_2)

print(f'Colour 1: {colour_1} Colour 2: {colour_2} Distance: {distance:.3f}')
