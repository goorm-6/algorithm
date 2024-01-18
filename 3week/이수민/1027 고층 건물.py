import sys

# v1: 내빌딩 층수 v2: 바라볼 빌딩 층수 i1: 내빌딩 위치 i2: 바라볼 빌딩 위치
def cal(v1, v2, i1, i2 ):
    return (v1 - v2)/(i1 - i2)
    
input = sys.stdin.readline

n = int(input())

b = [i for i in list(map(int,input().strip().split()))]

result = 0

for bx, v in enumerate(b): # 현재 존재하는 빌딩의 위치값과 빌딩의 층수를 반복
    vpoint = 0  # 현재 위치에서 좌우로 빌딩을 봤을때의 갯수누적 변수
    lm = float('inf') # 현재까지 탐색한 건물의 기울기가 최솟값보다 기울기가 더 작아질 경우(왼쪽) 바라보는 건물이 뒤에 건물보다 더 크면 뒤에 건물이 안보임
    rm = -float('inf') # 현재까지 탐색한 건물의 기울기가 최대값보다 기울기가 더 커질 경우(오른쪽) 건물이 더 크면 뒤에 건물이 안보임

    for i in range(bx-1,-1,-1): # 왼쪽 방향의 빌딩 갯수
        c = cal(v, b[i], bx+1, i+1)
        if c < lm:
            lm = c
            vpoint += 1

    for i in range(bx+1, n): # 우측 방향의 빌딩 갯수
        c = cal(v, b[i], bx+1, i+1)
        if c > rm:
            rm = c
            vpoint += 1
    result = max(result, vpoint) # for문이 반복될때마다 좌우측으로 바라본 빌딩의 최대갯수를 초기화
print(result)                        





