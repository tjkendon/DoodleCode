

def print_chars(letters):

	for char in sorted(letters):
		print(char, letters[char])

value = input()

letters = {}


while len(value) > 0:
	for char in value:
		if not (char in letters) :
			letters.update({char: 0})
		letters.update({char: letters[char] + 1})	
	print(letters)
	print_chars(letters)
	value = input()
