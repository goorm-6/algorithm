import sys

n, m = map(int, sys.stdin.readline().split(" "))
a = list(map(int, sys.stdin.readline().split(" ")))
print(a)

total = [0]
for i in range(n):
    total.append(total[i] + a[i])

for _ in range(m):
    num1, num2 = map(int, sys.stdin.readline().split(" "))
    result = total[num2] - total[num1 - 1]
    print(result)
