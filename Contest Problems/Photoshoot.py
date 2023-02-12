import sys
def photoshoot():
    n = int(sys.stdin.readline().split()[0])
    given = [int(x) for x in sys.stdin.readline().split()]
    goal = [int(x) for x in sys.stdin.readline().split()]
    count = 0
    for x in range(n):
        if given[x] != goal[x]:
            index = given.index(goal[x])
            given.insert(x+1, given[x])
            given[x] = given.pop(index+1)
            count += 1

    sys.stdout.write(str(count))

photoshoot()