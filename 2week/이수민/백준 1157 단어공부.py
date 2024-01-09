from collections import Counter

str = input().lower()

count = Counter(str)

maxnum = 0
num = 0

result = ''

for p, k in count.items():
    maxnum = max(maxnum, k)

if len(str) > 1:
    for p, k in count.items():
        if maxnum == k:
            num += 1
            if num > 1:
                result = "?"
            elif num == 1:
                result =  p.upper()   
elif len(str) == 1:
    result = str.upper()   
print(result)