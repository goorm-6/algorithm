import sys

from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())

a = [list(map(int, input().split())) for _ in range(n)]

h = []
c = []

result = 99999

for i in range(n):
    for j in range(n):
        if a[i][j] == 1:
            h.append([i,j])
        elif a[i][j] == 2:
            c.append([i,j])

# print(h)
# print(c)

# clist = []
# if m == len(c):
#     for i in c:
#         clist.append(c[:])
# elif m < len(c):
#     for i in range(len(c)):
#         for j in range(i+1,len(c)):
#             clist.append([c[i],c[j]])

# for l in clist:

#     temp = 0
#     for hs in h:
#         c_len = 999
#         for i in range(len(l)):                     
#             c_len = min(c_len, abs(hs[0] - l[i][0]) + abs(hs[1] - l[i][1]))
#         temp += c_len
#     result = min(result, temp)

# print(result)    

        
for chi in combinations(c, m):
    print(chi)
    temp = 0
    print(chi)
    for hs in h:
        c_len = 999
        print(hs[0] , "hs")
        for j in range(m):           
            c_len = min(c_len, abs(hs[0] - chi[j][0]) + abs(hs[1] - chi[j][1]))
        temp += c_len
    result = min(result, temp)

print(result)    

