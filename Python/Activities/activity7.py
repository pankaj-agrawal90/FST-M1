from functools import total_ordering


count = int(input("Enter the number of elements you want to enter in the list for addition: "))

i = 0
sum_list = list('')
sum_total = 0

while i < count:
    num = input("Enter the number in list: ")
    sum_list.append(num)
    i+=1

print("Elements in the list are: ", sum_list)

for item in sum_list:
    sum_total += int(item)

print("The sum of all the elements in the list is: ", sum_total)