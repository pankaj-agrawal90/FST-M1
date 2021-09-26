count = int(input("Enter the number of elements you want to enter in the list for addition: "))

i = 0
sum_list = list('')
sum_total = 0

while i < count:
    num = input("Enter the number in list: ")
    sum_list.append(num)
    i+=1

print("Elements in the list are: ", sum_list)

print(sum_list[0] == sum_list[-1])