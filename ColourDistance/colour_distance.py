
def colour_value ( name ):
	"Split name into 3 hex tuples"
	return (int(colour_name_1[0:2], 16), int(colour_name_1[2:4], 16), int(colour_name_1[4:6], 16))

colour_name_1 = input("Colour 1: ")
colour_name_2 = input("Colour 2: ")

colour_1 = colour_value( colour_name_1 )
colour_2 = colour_value( colour_name_2 )

print(f'Colour 1: {colour_1} Colour 2: {colour_2}')
