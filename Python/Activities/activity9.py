listOne = [10, 20, 23, 11, 17, 31, 34, 97]
listTwo = [13, 43, 24, 36, 12, 44, 59, 80]

third_list = []

for items in listOne:
    if (items % 2 !=0):
        third_list.append(items)

for item in listTwo:
    if (item % 2 == 0):
        third_list.append(item)
    

print("Items in the third list is: ", third_list)