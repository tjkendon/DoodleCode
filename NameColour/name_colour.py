

def hex_str(colour):
        return ''.join('{:02X}'.format(a) for a in colour)


name = input("Enter Name: ")
ident = 1 
print(name)
for c in name:
	ident *= ord(c)
r = int((ident / 31) % 255)
b = int((ident / 7) % 255)
g = int((ident / 255) % 255)
print(hex_str((r, g, b)))
