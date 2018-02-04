"""
ID: jamesya4
LANG: PYTHON3
TASK: ariprog
"""

fin = open('ariprog.in','r')
fout = open('ariprog.out','w')
N_str = fin.readline()
N = int(N_str)
M_str = fin.readline()
M = int(M_str)
bisquare = [False]*(2*M*M+1)
have = False
all = []
result = []
for x in range(0,M+1):
    for y in range(x,M+1):
        bisquare[x**2+y**2] = True
        all.append(x**2+y**2)

allSet = set(all)
distinct = []
for x in allSet:
    distinct.append(x)
distinct.sort()

have = False
for a in range(0, len(distinct)):
    for k in range(a + 1, len(distinct)):
        z = distinct[k] - distinct[a]
        if distinct[a] > 2 * M * M - (N - 1) * z:
            break
        acopy = distinct[a]
        can = True
        for i in range(0, N):
            if bisquare[acopy] != True:
                can = False
                break
            acopy = acopy + z
        if can:
            have = True
            result.append([z, distinct[a]])
result.sort();
if not have:
    fout.write('NONE'+'\n')
else:
    for x in result:
        fout.write(str(x[1]) + ' ' + str(x[0]) + '\n')