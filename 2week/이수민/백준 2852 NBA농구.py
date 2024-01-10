
n = int(input()) # 경기의 총 득점수

sc = {1: 0, 2: 0} 
time = {1: 0, 2: 0} # 각팀의 최초 득점 시간
ans = {1: 0, 2: 0} # 각팀의 득점 시간

state = 0 # 0 - 동점자 없음, 1 - 1팀 리드중, 2 - 2팀 리드중

for _ in range(n):
    
    tnum, t = input().split()
    m, s = map(int, t.split(":"))
    tnum = int(tnum)
    t = m*60+s
    sc[tnum] += 1
    
    if state == 0:
        time[tnum] = t
        state = tnum
    elif state != 0 and sc[1] == sc[2]:
        ans[state] += t - time[state]
        state = 0

if state != 0:        
    ans[state] += 60*48-time[state]

print('{:0>2}:{:0>2}'.format(ans[1]//60, ans[1]%60))
print('{:0>2}:{:0>2}'.format(ans[2]//60, ans[2]%60))
