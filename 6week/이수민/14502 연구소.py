from sys import stdin
from collections import deque
from copy import deepcopy
from itertools import combinations

def bfs(graph):
    q = deque([(j, i) for i in range(N) for j in range(M) if graph[i][j] == 2])
    while q:
        x, y = q.popleft()
        for nx, ny in zip([x+1, x-1, x, x], [y, y, y+1, y-1]):
            if 0 <= nx < M and 0 <= ny < N and not graph[ny][nx]:
                graph[ny][nx] = 2
                q.append((nx, ny))
    
    global answer
    count = sum([i.count(0) for i in graph])
    answer = max(answer, count)


N, M = map(int, stdin.readline().split())
graph = [list(map(int, stdin.readline().split())) for _ in range(N)]
x_y = [(x, y) for x in range(M) for y in range(N) if not graph[y][x]]
answer = 0

for c in combinations(x_y, 3):
    tmp_graph = deepcopy(graph)
    for x, y in c:
        tmp_graph[y][x] = 1
    bfs(tmp_graph)

print(answer)