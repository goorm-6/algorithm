import sys

input = sys.stdin.readline

a, b, c = map(int, input().split())

A = [list(map(int, input().split())) for _ in range(3)]

maxnum = max(A[0][1], A[1][1], A[2][1])

p = [0] * (maxnum-1)

result = 0

for i in A:
    for j in range(i[0] - 1, i[1] - 1):
        p[j] += 1


for i in p:
        if i == 1:
            result += i * a
        elif i == 2:
            result += i * b
        elif i == 3:
            result += i * c      
              
print(result)        