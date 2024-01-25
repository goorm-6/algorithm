import sys

sys.setrecursionlimit(10**6)

input = sys.stdin.readline

n, m, k = map(int, input().split())

g = [[0] * m for _ in range(n)]

rl = [[-1, 0], [1, 0], [0, -1], [0, 1]] # 상하좌우(인접한 음식물은 커지게된다)

def cal(x, y): # 재귀함수를 통해 인접한 현 위치에 있는 음식물을 포함하여 카운트
    eq = g[x][y]
    g[x][y] = 0
    cnt = 1  # 현재 위치 카운트
    for i in range(4):
        newX = x + rl[i][0]
        newY = y + rl[i][1]
        if 0 <= newX < n and 0 <= newY < m and g[newX][newY] == eq:
            cnt += cal(newX, newY) # 재귀함수가 반복 될때마다 cnt를 return해서 증가시켜줌
    return cnt

                             
for _ in range(k):
    y, x = map(int, input().strip().split())
    g[y - 1][x - 1] = "F"

result = 0

for i in range(n):
    for j in range(m):
        if g[i][j] != 0:
            result = max(result, cal(i,j)) # 각 재귀함수가 반복될때마다 카운트된 값의 최대값을 담아줌

print(result)