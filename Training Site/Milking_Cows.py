"""
ID: devaggarwal
LANG: PYTHON3
TASK: milk2
"""

from operator import truediv
from readline import set_completion_display_matches_hook


dict = {} #every second milked: number of farmers at that second
# if dictionary doesn't work, use parallel arrays
with open('milk2.in', 'r') as fin:
    inp = fin.read().strip().split('\n')

min = 1000000
max = 0
for x in range(1,len(inp)):
    start = int(inp[x].split()[0])
    end = int(inp[x].split()[1])
    if start < min:
        min = start
    if end > max:
        max = end
for x in range(min, max + 1): # create a second for all seconds between beginning and ending milking time
    dict[x] = 0

for x in range(1, len(inp)):
    start = int(inp[x].split()[0])
    end = int(inp[x].split()[1])
    for y in range(start, end + 1):
        dict[y] += 1
# all farmers in dictionary
print(dict)
cows = 0
noCows = 0
interval = 0



for second, numFarmer in dict.items():
    if interval > cows:
        cows = interval
    if numFarmer > 0:
        interval +=1
    if numFarmer == 0:
        if interval > cows:
            cows = interval
        else:
            interval = 0
    for x in range(1, len(inp)):
        if int(inp[x].split()[1]) == second and int(inp[x].split()[1]) != max:
            if numFarmer <= 1:
                if interval > cows:
                    cows = interval
                interval = 0
                continue

if interval > cows:
    cows = interval
else:
    interval = 0

interval = 0

for second, numFarmer in dict.items():
    if numFarmer == 0:
        interval += 1
    if interval > cows:
        cows = interval
    if numFarmer > 0:
        if interval > noCows:
            noCows = interval
        else:
            interval = 0
    for x in range(1, len(inp)):
        if int(inp[x].split()[1]) == second and int(inp[x].split()[1]) != max:
            print(inp[x].split()[1])
            if numFarmer <= 1:
                interval += 1
                if interval > noCows:
                    print(interval, second, max)
                    noCows = interval
                interval = 0
                continue
cows -=1
if len(inp) == 2: # check if there is just one farmer
    cows = max - min
    noCows = 0
fout = open('milk2.out', 'w')
fout.write(str(cows) + " " + str(noCows) + '\n')
fout.close()