"""
ID: devaggarwal
LANG: PYTHON3
TASK: ride
"""

fin = open ('ride.in', 'r')
fout = open ('ride.out', 'w')
comet = fin.readline().split()
group = fin.readline().split()

abc = ['A','B','C','D','E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

cometVal = 1
for x in comet[0]:
    value = abc.index(x) + 1
    cometVal *= value

groupVal = 1
for x in group[0]:
    value = abc.index(x) + 1
    groupVal *= value

if cometVal%47 == groupVal%47:
    fout.write ("GO\n")
else:
    fout.write("STAY\n")
fout.close()