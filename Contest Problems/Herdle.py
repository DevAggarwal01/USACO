
grid = list(input() + input() + input())
print(grid)
guesses = list(input() + input() + input())
green = []
for x in range(len(grid)):
    if grid[x] == guesses[x]:
        green.append(True)
    else:
        green.append(False)

yellow = 0
yellows = [False]*9
for answer in range(len(grid)):
    if green[answer]:
        continue
    for guess in range(len(guesses)):
        if green[guess]:#+yellow]:
            continue
        if grid[answer] == guesses[guess] and yellows[guess] != True:
            #del guesses[guess]
            yellows[guess] = True
            yellow += 1
            break
greenNum = 0
for x in green:
    if x == True:
        greenNum+=1

print(greenNum)
print(yellow)