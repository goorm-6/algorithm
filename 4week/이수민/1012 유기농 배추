import sys
sys.setrecursionlimit(10**6) # 재귀함수 범위 설정

input = sys.stdin.readline

t = int(input())

rl = [[1, 0], [-1, 0], [0, -1], [0, 1]]

def dfs(x, y): # 재귀 함수
    g[x][y] = 0 # 배추가 있는 위치를 방문하여 0으로 초기화
    for cl in range(4): # 현 위치에 상하좌우를 확인 하여 있다면 호출 없다면 종료
        newX = x + rl[cl][0]
        newY = y + rl[cl][1]
        if 0 <= newX < m and 0 <= newY < n and g[newX][newY] == 1: #조건으로 indexException이 뜨지않게함
            dfs(newX, newY)

for _ in range(t): # 테스트 케이스 만큼 반복
    m, n, k = map(int, input().split()) # 행, 열, 배추의 수
    g = [[0] * n for _ in range(m)] # 

    for _ in range(k): # 심어진 배추의 수 만큼 배추의 위치값을 입력받아 1로 초기화
        x, y = map(int, input().split())
        g[x][y] = 1

    ans = 0 # 출력

    for i in range(m):
        for j in range(n):
            if g[i][j] == 1: # 현위치에 배추가 있다면 재귀함수 호출
                dfs(i, j)
                ans += 1 # 빠져나오면 1을 누적

    print(ans)
