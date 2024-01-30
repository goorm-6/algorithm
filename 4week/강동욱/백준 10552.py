n, m, p = map(int, input().split())

hateDic = {}
visitDic = {}
visit = [0 for i in range(n)]
board = []
for i in range(n):
    loveC, hateC = map(int, input().split())
    hateP = hateDic.get(hateC, -1)
    if hateP == -1:
        hateDic[hateC] = i
    board.append([loveC, hateC])

move = 0
while True:
    hatePerson = hateDic.get(p, -1)

    if hatePerson == -1:
        print(move)
        break


    if visit[hatePerson]:
        print('-1')
        break
    else:
        visit[hatePerson] = 1
    p = board[hatePerson][0]

    move+=1