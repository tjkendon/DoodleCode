
vowels = 'aeiou'

def num_to_range(num, inMin, inMax, outMin, outMax):
  return outMin + (float(num - inMin) / float(inMax - inMin) * (outMax
                  - outMin))

def count_vowel(word):
  vowel_count = 0

  for vowel in vowels:
    vowel_count += word.lower().count(vowel)
  return vowel_count


name = input ("Enter Name: ")


print (name)
vowel_count = count_vowel(name)
vowel_ratio = vowel_count / len(name)
print (vowel_count, " ", vowel_ratio, " ", num_to_range(vowel_ratio, 0, 1, 0, 100))
  

midpoint = 0; 
pos = 1;
for c in name:
  if c.lower() in vowels:
    print (c, ' at ', pos)
    midpoint += pos
  pos+=1

midpoint /= vowel_count;

print (midpoint, " ", midpoint / len(name), " ", num_to_range(midpoint / len(name), 0, 1, 0, 100))

char_depth = 0;
for c in name:
  char_depth += ord(c)

print (char_depth, " ", char_depth / len(name), num_to_range(char_depth / len(name), 90, 110, 0, 360))
