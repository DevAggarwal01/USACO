n = int(input())
letters = [list(input())]
letters.append(list(input()))
letters.append(list(input()))
letters.append(list(input()))
print(letters)

print(letters)
words = []
for x in range(n):
    words.append(list(input()))

for word in words:
    used = [False, False, False, False]
    yes = True
    for letter in word:
        for block in range(len(letters)):
            if used[block]:
                continue
            if letters[block].count(letter) >= 1:
                used[block] = True
                break
            else:
                yes = False
                break
    if yes:
        print('YES')
    else:
        print('NO')