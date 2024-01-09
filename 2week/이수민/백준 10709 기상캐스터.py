import sys

input = sys.stdin.readline

h, w = map(int, input().split())

a = [list(' '.join(input()).split()) for _ in range(h + 1)]

a_num = [[-1] * (w) for _ in range(h)]

for i in range(h):
    for j in range(w):
        if a[i][j] == "c":
            a_num[i][j] = 0
            if (j+1) < w: 
                if a[i][j + 1] == ".":
                    a_num[i][j + 1] = a_num[i][j] + 1
        elif a[i][j] == "." and a_num[i][j - 1] >= 0:
            a_num[i][j] = a_num[i][j- 1] + 1

for i in range(h):  
    for j in range(w):
         print(a_num[i][j], end = " ")
    print()