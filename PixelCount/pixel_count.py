
from PIL import Image
import sys

def hex_str(colour):
	return ''.join('{:02X}'.format(a) for a in colour)

def print_colours(colours):
	
	for colour in sorted(colours):
		print('{},{},{},{},{}'.format(hex_str(colour), colour[0], colour[1], colour[2], colours[colour]))



if not len(sys.argv) == 2:
	print('Usage {} <file>'.format(sys.argv[0]))
	sys.exit(1)
print('Counting Pixels in: {}'.format(sys.argv[1]))
input_image = Image.open(sys.argv[1])

map = input_image.load()

colours = {}

for x in range(input_image.width):
	for y in range(input_image.height):
		colour = map[x, y]
		if not colour[3] == 0:
			colour = (colour[0], colour[1], colour[2])
			if not (colour in colours):
				colours.update({colour: 0})
			colours.update({colour: colours[colour] + 1})
print_colours(colours)





