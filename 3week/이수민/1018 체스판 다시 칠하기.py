n, m = map(int, input().split())

a = [input() for _ in range(n)]
r = []
for i in range(n - 7):
    for j in range(m - 7):
        w_i = 0
        b_i = 0
        
        for bi in range(i, i+8):
            for bj in range(j, j+8):
                if (bi + bj) % 2 == 0:
                    if a[bi][bj] != "W":
                        w_i += 1
                    else:
                        b_i += 1    
                else:
                    if a[bi][bj] != "W":
                        b_i += 1
                    else:
                        w_i += 1    
        r.append(w_i)
        r.append(b_i)

print(min(r))

