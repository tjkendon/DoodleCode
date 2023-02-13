sum = 0
count = 0

numbers = {}

median_list = []

minimum = -1 
maximum = -1


value = int(input())
while value >= 0:
	sum += value;
	count += 1;
	print("Mean is: %f" % (sum / count))
	
	if minimum >= 0 :
		minimum = min(minimum, value)
		maximum = max(maximum, value)
	else:
		minimum = value
		maximum = value

#	print("Minimum %d, Maximum %d" % minimum, maximum)
	print('Range: {0} .. {1}'.format(minimum, maximum))

	median = 0
	median_list.append(value)
	median_list.sort()
	if len(median_list) % 2 == 1:
		median = median_list[len(median_list)//2]
	else:
		median = (median_list[len(median_list)//2] + median_list[len(median_list)//2 - 1]) / 2
	print("Median is: %f" % median)	
	
	if not (value in numbers):
		numbers.update({value: 0})
	numbers.update({value: (numbers[value] + 1)})
	mode = []
	for x in numbers:
		if len(mode) == 0 or (numbers[x] > numbers[mode[0]]):
			mode = [x]
		elif (numbers[x] == numbers[mode[0]]):
			mode.append(x)
	print("Mode is: %s" % mode)
	value = int(input())
