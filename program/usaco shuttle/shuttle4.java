//using bfs without hash and dp could actually get this problem aced
/*
ID: jamesya4
LANG: JAVA
TASK: shuttle
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;
class shuttle4 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("shuttle.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuttle.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        boolean[] state = new boolean[2 * n + 1];
        for(int i = 0; i < 2 * n + 1; i++){
            if(i < n)
                state[i] = true;
            else state[i] = false;
        }
        ArrayList<Byte> answer = null;
        ArrayDeque<situation1> states = new ArrayDeque<>();
        states.add(new situation1(state.clone(), n, new ArrayList<Byte>()));
        while(!states.isEmpty()){
            situation1 current = states.remove();
            boolean[] currentState = current.white;
            int currentEmpty = current.empty;
            if(currentEmpty > 1){
                if(currentState[currentEmpty - 1] ^ currentState[currentEmpty - 2]){
                    if(currentState[currentEmpty - 2]){
                        ArrayList<Byte> nextOp = (ArrayList)current.operation.clone();
                        boolean[] nextState = currentState.clone();
                        nextState[currentEmpty - 2] = false;
                        nextState[currentEmpty] = true;
                        nextOp.add((byte)(currentEmpty - 1));
                            if(check(nextState) && currentEmpty - 2 == n){
                                answer = nextOp;
                                break;
                            }
                            else{
                                states.add(new situation1(nextState, currentEmpty - 2, nextOp));
                            }
                    }
                }
            }
            if(currentEmpty > 0){
                if(currentState[currentEmpty - 1]){
                    ArrayList<Byte> nextOp = (ArrayList)current.operation.clone();
                    boolean[] nextState = currentState.clone();
                    nextState[currentEmpty - 1] = false;
                    nextState[currentEmpty] = true;
                    nextOp.add((byte)(currentEmpty));
                    if(check(nextState) && currentEmpty - 1 == n){
                        answer = nextOp;
                        break;
                    }
                    else{
                        states.add(new situation1(nextState, currentEmpty - 1, nextOp));
                    }
                }
            }
            if(currentEmpty < 2 * n){
                if(!currentState[currentEmpty + 1]) {
                    ArrayList<Byte> nextOp = (ArrayList)current.operation.clone();
                    boolean[] nextState = currentState.clone();
                    nextOp.add((byte)(currentEmpty + 2));
                    if(check(nextState) && currentEmpty + 1 == n){
                        answer = nextOp;
                        break;
                    }
                    else{
                        states.add(new situation1(nextState, currentEmpty + 1, nextOp));
                    }
                }
            }
            if(currentEmpty < 2 * n - 1){
                if(currentState[currentEmpty + 1] ^ currentState[currentEmpty + 2]){
                    if(!currentState[currentEmpty + 2]){
                        ArrayList<Byte> nextOp = (ArrayList)current.operation.clone();
                        boolean[] nextState = currentState.clone();
                        nextOp.add((byte)(currentEmpty + 3));
                        if(check(nextState) && currentEmpty + 2 == n){
                            answer = nextOp;
                            break;
                        }
                        else{
                            states.add(new situation1(nextState, currentEmpty + 2, nextOp));
                        }
                    }
                }
            }
        }
        int size = answer.size();
        int count = 0;
        for(byte number : answer) {
            count++;
            if(count % 20 == 0 && count != 0)
                out.println(number);
            else if(count != size)
                out.print(number + " ");
            else out.println(number);
        }
        out.close();                                  // close the output file
    }
    private static boolean check(boolean[] a){
        int len = a.length;
        boolean result = true;
        for(int j = len / 2 + 1; j < len; j++){
            if(!a[j]){
                result = false;
                break;
            }
        }
        return result;
    }
}
class situation1{
    public boolean[] white;
    public int empty;
    public ArrayList<Byte> operation;
    public situation1(boolean[] white, int empty, ArrayList<Byte> operation){
        this.white = white;
        this.empty = empty;
        this.operation = operation;
    }
}