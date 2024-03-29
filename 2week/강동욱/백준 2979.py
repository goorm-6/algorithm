import sys
from collections import defaultdict

input = sys.stdin.readline

def sol(parking_price, parking_time):
    counter = defaultdict(int)
    total_price = 0
    
    for x,y in parking_time:
        for i in range(x, y):
            counter[i] += 1
    for value in counter.values():
        if value == 1:
            total_price += parking_price[0]
        elif value == 2:
            total_price += parking_price[1] * 2
        else:
            total_price += parking_price[2] * 3
            
    return total_price

if __name__ == '__main__':
    parking_price = list(map(int, input().split()))
    parking_time = [list(map(int, input().split())) for _ in range(3)]
    
    print(sol(parking_price, parking_time))