sum = 0

product = 1;

numbers = {}

values = []
median_list = []

minimum = -1 
maximum = -1


value = int(input())
while value >= 0:

	values.append(value)

	if not (value in numbers):
		numbers.update({value: 0})
	numbers.update({value: (numbers[value] + 1)})


	print("Values: %s" % values)
	print("Unique values: %s" % list(numbers.keys()))

	sum += value
	print("Arethmetic Mean is: %f" % (sum / len(values)))

	product *= value	
	print("Geometric Mean is: %f" % pow(product, 1 / len(values)))
	
	
	if minimum >= 0 :
		minimum = min(minimum, value)
		maximum = max(maximum, value)
	else:
		minimum = value
		maximum = value

	print('Range: {0} .. {1}'.format(minimum, maximum))

	median = 0
	median_list = values;
	median_list.sort()
	if len(median_list) % 2 == 1:
		median = median_list[len(median_list)//2]
	else:
		median = (median_list[len(median_list)//2] + median_list[len(median_list)//2 - 1]) / 2
	print("Median is: %f" % median)	
	
	mode = []
	for x in numbers:
		if len(mode) == 0 or (numbers[x] > numbers[mode[0]]):
			mode = [x]
		elif (numbers[x] == numbers[mode[0]]):
			mode.append(x)
	print("Mode is: %s" % mode)
	value = int(input())
