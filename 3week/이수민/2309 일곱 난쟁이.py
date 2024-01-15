import sys

input = sys.stdin.readline

a = []

while True:
    temp = input().strip()
    if not temp: 
        break
    a.append(int(temp))

t = sum(a)
c, d = 0,0
for i in range(len(a)):
    for j in range(i+1, len(a)):
        if t - (a[i] + a[j]) == 100:
            c, d = a[i], a[j]
            break

a.remove(c)
a.remove(d)
a.sort()
for i in a:
    print(i)
        


