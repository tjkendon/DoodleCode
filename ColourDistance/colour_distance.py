

colour_name_1 = input("Colour 1: ")
colour_name_2 = input("Colour 2: ")

print("Colours are ", colour_name_1, colour_name_2)
print("Colour 1 Text: ", colour_name_1[0:2], colour_name_1[2:4], colour_name_1[4:6])
red_1 = int(colour_name_1[0:2], 16)
blue_1 = int(colour_name_1[2:4], 16)
green_1 = int(colour_name_1[4:6], 16)
print("Colour 1 Numbers: ", red_1, blue_1, green_1)
