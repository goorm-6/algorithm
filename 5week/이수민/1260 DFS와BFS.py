import sys
from collections import deque

input = sys.stdin.readline

n, m, v = map(int, input().split())

g = [[0] * (n+1) for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    g[x][y] = 1
    g[y][x] = 1
    
vis1 = [False] * (n+1)
vis2 = [False] * (n+1)

def dfs(v):
    vis1[v] = True
    print(v, end=" ")

    for i in range(1, n+1):
        if not vis1[i] and g[v][i] == 1:
            dfs(i)

# print(g)


def bfs(v):
    q = deque([v])

    vis2[v] = True

    while q:
        v = q.popleft()
        print(v, end=" ")

        for i in range(1, n+1):
            if not vis2[i] and g[v][i] == 1:
                q.append(i)
                vis2[i] = True


dfs(v)
print()
bfs(v)

