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


for z in range(1,int(2*M*M/(N-1))+1):
    canbefirst = bisquare[:]
    for a in range(2 * M * M - (N - 1) * z + 1):
        if canbefirst[a]:
            count = 1
            b = a
            while (b+(N-count)*z <= 2*M*M):
                if count<N:
                    next = b+z
                    if bisquare[next] == True:
                        count+=1
                        b = next
                        if count == 2:
                            c2 = b
                        elif count == 3:
                            c3 = b
                        elif count == 4:
                            c4 = b

                    else:
                        if count == 2:
                            canbefirst[c2] = False
                        if count == 3:
                            canbefirst[c2] = canbefirst[c3] = False
                        if count == 4:
                            canbefirst[c3] = canbefirst[c4] = False
                        break
                else:
                    fout.write(str(b-(N-1)*z)+' '+str(z)+'\n')
                    have = True
                    break

if not have:
    fout.write('NONE'+'\n')
