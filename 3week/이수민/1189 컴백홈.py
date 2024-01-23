r, c, K = map(int, input().split())
graph = [list(input()) for _ in range(r)]
answer = 0

def rec_fun(x, y, k): # x:행 y:열 k:거리누적변수
    global answer
    if k == K: # 누적된 거리가 K와 동일할 경우
        if (x, y) == (0, c - 1): answer += 1 # 현재의 행열이 우측 상단에 위치하고 있다면 거리가 K인 가짓수 누적
    else:
        for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)): # 상 하 좌 우 좌표값 초기화
            nx, ny = x + dx, y + dy # 현재 행 과 열에 이동할 좌표값을 더해준다
            if 0 <= nx < r and 0 <= ny < c and graph[nx][ny] != 'T': # 그래프를 벗어나지 않는 경우 && 현재 위치에서 이미 방문한 곳이 아닐경우만 통과
                graph[nx][ny] = 'T' # 방문한곳을 T로 치환
                rec_fun(nx, ny, k + 1) # 재귀함수를 통해 현재 위치에서 다음 위치로 이동하면서 탐색 이때 이동 거리를 누적하기위해 k+1한값을 넘겨줌
                graph[nx][ny] = '.' # 재귀함수 종료 후 재탐색을 위해 다시 .으로 변경

graph[r - 1][0] = 'T' # 시작점 부터 T로 값 치환
rec_fun(r - 1, 0, 1) # 함수 호출 첫 시작 위치는 왼쪽 맨아래 이기에 행은 (r - 1) 열은 0부터시작 k는 시작점이기에 1
print(answer)