import sys
import copy

sys.setrecursionlimit(10**6) 

input = sys.stdin.readline

n = int(input())

g = [list(input().strip()) for _ in range(n)]

rl = [[1, 0], [-1, 0], [0, -1], [0, 1]] # 상하좌우

# 재귀함수를 통해서 구역의 총개수를 구한다
def cal(x,y):
    eq = g[x][y] # 현재 위치의 요소를 변수에 담아서 비교
    g[x][y] = 0  # 방문한 위치를 재방문 하지 않기위해 요소를 0으로 초기화
    for i in range(4): 
        # x, y 좌표의 상하좌우를 계산
        newX = x + rl[i][0] 
        newY = y + rl[i][1]

        # if를 통해서 상하좌우를 계산할때 그래프의 범위를 벗어나지 않기위한 조건
        if 0 <= newX < n and 0 <= newY < n and g[newX][newY] != 0:
            # 만약 현재 위치의 요소가 방문한 위치의 요소와 같으면 함수 호출
            if g[newX][newY] == eq :
                cal(newX, newY)

            
p1, p2 = 0, 0

g1 = copy.deepcopy(g) # 기존 배열의 값이 변경되지 않게 하기위해 깊은복사

# 색약이 아닌 경우의 수
for i in range(n):
    for j in range(n):
        if g[i][j] != 0:
            cal(i,j)
            p1 += 1 

g = g1

# 색약일 경우 빨강과 초록을 같은 색으로 보기때문에 빨간색으로 변경
for i in range(n):
    for j in range(n):
        if g[i][j] == "G":
            g[i][j] = "R"

# 색약이 있는경우의 수
for i in range(n):
    for j in range(n):
        if g[i][j] != 0:
            cal(i,j)
            p2 += 1 
            
print(p1, p2)   
      