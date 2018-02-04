"""
ID: cty
LANG: PYTHON3
TASK: wormhole
"""
import math
import itertools
fin = open('wormhole.in', 'r')
fout = open('wormhole.out', 'w')

n = int(fin.readline().strip())
point = [0]*n
combine = []
total = []
pair = []
for i in range(n):
    x, y = map(int,fin.readline().split())
    point[i] = (x,y)
# print(point)
for subset in itertools.combinations(point,2):
    pair.append(subset)
# pair = [[0 for i in range(n - 1)] for j in range(n - 1)]

print(pair)
print(len(pair))

for subset in itertools.combinations(pair,n // 2):
    combine.append(subset)
print(combine)
for a in combine:
    repet = False
    for b in range(n // 2):
        if not repet:
            for c in range(b+1,n // 2):
                print(a[b])
                print(a[c])
                if (a[b][1] == a[c][1])|(a[b][0] == a[c][1])|(a[b][1] == a[c][0])|(a[b][0] == a[c][0]):
                    repet = True
                    break
        else:
            break
    if repet:
        combine[combine.index(a)] = ""


print(len(combine))
print(combine)


# print(count)
# fout.write(str(count)+'\n')
fout.close()






