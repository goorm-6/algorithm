import sys
N, S = map(int, input().split())
array = [int(x) for x in sys.stdin.readline().rstrip().split()]

left = 0 # 현재 누적 합이 S보다 클경우 움직일 포인터
right = 0 # 현재 누적 합이 S보다 작을경우 움직일 포인터
length = 100000 # 배열의 누적합을 해서 S의 합과 동일했을때의 최소길이를 구하는 변수(문제에서 정의한 배열의 최대 길이값을 초기화)
temp_sum = array[0] # 배열의 0번째 index값 초기화(누적합을 구할 변수)


while True:
    if temp_sum >= S: # 누적합이 S보다 같거나 클경우
        length = min(length, right - left + 1) # min함수를 이용해 length변수와 right - left + 1 의 최소값을 length에 초기화
        temp_sum -= array[left] # 누적합 변수에 현재 위치의 값을 빼준다
        left += 1 # left포인터값 증가
    else : # 그 외의 경우
        right += 1 # right포인터값 증가
        if right < N: # 만약 배열의 길이보다 right의 포인터값이 더 클경우
            temp_sum += array[right] # 누적합 배열에 현재 포인터위치의 값을 더해줌   
        else : # 배열의 length값보다 right의 값이 더 크거나 같아질 경우 while문 종료
            break 

if length == 100000: # 조건중 누적합의 합을 구했을때의 최소 길이값이 최대 길이값과 일치할때 누적합을 구할 수 없음으로 0으로 출력
        print(0)
else : print(length)  # 위 조건에 해당하지 않을경우 최소값으로 출력


