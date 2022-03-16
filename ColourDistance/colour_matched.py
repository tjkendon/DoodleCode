import math

def colour_value ( name ):
	"Split name into 3 hex tuples"
	return (int(name[0:2], 16), int(name[2:4], 16), int(name[4:6], 16))

def colour_distance ( colour_1, colour_2 ):
	"Find the distance between these 2 colours (as points)"
	return math.sqrt( (colour_2[0]-colour_1[0])*(colour_2[0]-colour_1[0]) + 
			(colour_2[1]-colour_1[1])*(colour_2[1]-colour_1[1]) + 
			(colour_2[2]-colour_1[2])*(colour_2[2]-colour_1[2]) )

def readfile ( filename ):
	"Reads colour hex / name pairs from the file"
	colours = {}
	with open(filename) as colour_file:
		lines = colour_file.readlines()
		print(lines)
		for x in lines:
			s = x.split(",")
			colours[s[0].strip()] = s[1].strip()
	
	print(colours)

readfile('data/colours.csv')

