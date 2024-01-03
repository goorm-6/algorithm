N, S = map(int, input().split())
nums = list(map(int, input().split()))
lp, rp = 0, 0
s = nums[0]
ans = 100001

while True:
  if s >= S:
    s -= nums[lp]
    ans = min(ans, rp-lp+1)
    lp+=1
  else:
    rp+=1
    if rp == N:
        break
    s += nums[rp]
    
print(0) if ans == 100001 else print(ans)