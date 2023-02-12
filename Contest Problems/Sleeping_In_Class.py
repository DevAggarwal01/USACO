import sys
def x():
    t = int(input())

    ans = []
    for x in range(t):
        n = int(input())
        a = list(map(int, sys.stdin.readline().split()))

        if sum(a) == 0:
            print(0)
            continue
        ans = 0
        for i in range(1,n):
            for y in range(1,sum(a)+1):
                #goal = [y] * i
                if sum(a) == y * i: # if sum(a) == sum(goal)
                    ans = max(i, ans) # ans = min(len(a) - len(goal), ans)
        
        print(len(a) - ans)
    
    
        
x()


