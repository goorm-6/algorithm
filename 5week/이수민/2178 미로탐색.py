from collections import deque #큐 로 구현

n, m = map(int, input().split())
g = [list(map(int, input().strip())) for _ in range(n)]

rl = [[1, 0], [-1, 0], [0, -1], [0, 1]]

def bfs(): 
    queue = deque() # 큐 선언
    queue.append((0, 0)) # 시작은 0,0부터

    while queue: # 큐가 null이 아닐 경우 반복
        x, y = queue.popleft() # 요소로 추출과 동시에 큐 요소 삭제

        for i in range(4): # 상하좌우의 조건확인
            newX = x + rl[i][0]
            newY = y + rl[i][1]

            if 0 <= newX < n and 0 <= newY < m and g[newX][newY] == 1: # 한번도 방문 하지 않았다면 1 이다.(거리 누적 조건)
                queue.append((newX, newY)) # 현위치를 큐에 삽입
                g[newX][newY] = g[x][y] + 1 # 방문한곳 1씩 누적

bfs()
print(g)
print(g[n-1][m-1])
