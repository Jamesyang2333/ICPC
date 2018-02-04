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


for x in range(0,M+1):
    for y in range(x,M+1):
        bisquare[x**2+y**2] = True

have = False
for z in range(1,int(2*M*M/(N-1))+1):
    for a in range(0, 2 * M * M - (N - 1) * z + 1):
        acopy = a
        can = True
        for i in range(0, N):
            if bisquare[acopy] != True:
                can = False
                break
            acopy = acopy + z
        if can:
            have = True
            fout.write(str(a) + ' ' + str(z) + '\n')
if not have:
    fout.write('NONE'+'\n')