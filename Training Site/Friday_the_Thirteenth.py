"""
ID: devaggarwal
LANG: PYTHON3
TASK: friday
"""

n = int(open('friday.in','r').read())

days = ['saturday', 'sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday']
score = {'saturday':0,'sunday':0, 'monday':0, 'tuesday':0, 'wednesday': 0,'thursday': 0,'friday': 0}
dayName = 'monday'
months = {'January':31, 'February':28, 'March':31, 'April':30, "May":31, 'June':30, "July": 31, "August": 31, "September":30, "October": 31, "November":30, "December":31}

for x in range(1900, 1900+n):
    if x % 4 == 0:
            months['February'] = 29
    else:
        months['February'] = 28
    
    if x % 100 == 0 and x % 400 != 0:
        months['February'] = 28
    
    if x == 0:
        months['February'] = 28
    
    for month in months:
        day = 1

        while day <= months[month]:                
            if day == 13:
                score[dayName] += 1
            for i in range(len(days)):
                if dayName == 'friday':
                    dayName = days[0]
                    break
                elif dayName == days[i]:
                    dayName = days[i+1]
                    break
            day+=1

for monthx in months:print(months[monthx])
fout = open('friday.out', 'w')
for x in score:
    fout.write(str(score[x]))
    if x == 'friday':
        pass
    else:
        fout.write(' ')
fout.write("\n")
fout.close()


    
