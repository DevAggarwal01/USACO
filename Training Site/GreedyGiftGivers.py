"""
ID: devaggarwal
LANG: PYTHON3
TASK: gift1
"""
inp = open('gift1.in').read().strip().split('\n')
lineCount = 0

np = int(inp[0])

#np = int(fin.readline().split()[0])
money = {}
for x in range(1, np+1):
    #money[fin.readline().split()[0]] = int(0)
    money[inp[x]] = 0

#giver = fin.readline().split()[0]

#list = fin.readline().split()
#list = lines[np+2].split()
#amount = int(list[0])
#ng = int(list[1])

lineCount = np + 1

while lineCount < len(inp):
    giver = inp[lineCount]
    list = inp[lineCount+1].split()
    lineCount+=2
    amount = int(list[0])
    ng = int(list[1])
    print(list)
    if ng == 0:
        print(lineCount)
        continue
    money[giver] += amount % ng
    money[giver] -= amount
    for x in range(ng):
        #money[fin.readline().split()[0]] += amount / ng
        money[inp[lineCount]] += int(amount/ng)
        lineCount+=1
    #giver = fin.readline().split()[0]

fout = open('gift1.out', 'w')
for x in money:
    fout.write(x + " " + str(int(money[x])) + '\n')
fout.close()

            

