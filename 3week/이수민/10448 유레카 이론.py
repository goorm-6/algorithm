t = int(input())

tri = [i * (i+1)//2 for i in range(1, 45)]

print(tri)
def find(k):
    for one in tri:
        for two in tri:
            for three in tri:
                if one + two + three == k:
                    return 1
    return 0
    
for _ in range(t):
    k = int(input())
    print(find(k))
