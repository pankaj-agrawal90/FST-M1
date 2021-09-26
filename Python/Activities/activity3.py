p1_name = input("Player 1, Enter your name: ")
p2_name = input("Player 2, Enter your name: ")

p1_move = input(p1_name + " Enter your move from Rock, Paper and Scissors: ").lower()
p2_move = input(p2_name + " Enter your move from Rock, Paper and Scissors: ").lower()

if (p1_move == p2_move):
    print("It's a tie")
elif (p1_move == 'rock'):
    if (p2_move == 'paper'):
        print(p2_name + " wins the game")
    elif (p2_move == 'scissors'):
        print(p1_name + " wins the game")
    else:
        print(p2_name + " You have entered the invalid input")
elif (p1_move == 'paper'):
    if (p2_move == 'rock'):
        print(p1_name + " wins the game")
    elif (p2_move == 'scissors'):
        print(p2_name + " wins the game")
    else:
        print(p2_name + " You have entered the invalid input")
elif (p1_move == 'scissors'):
    if (p2_move == 'rock'):
        print(p2_name + " wins the game")
    elif ((p2_move == 'paper')):
        print(p1_name + " wins the game")
    else:
        print(p2_name + " You have entered the invalid input")
else:
    print(p1_name + " You have entered the invalid input")