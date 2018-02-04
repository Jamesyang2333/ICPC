/*
ID: jamesya4
LANG: JAVA
TASK: shuttle
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class shuttle1 {
    private static BigInteger[] factorials;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("shuttle.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuttle.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        factorials = new BigInteger[2 * n + 2];
        factorials[0] = BigInteger.ONE;
        for(int i = 1; i < 2 * n + 2; i++){
            factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
        }
        int allSit = combination(2 * n + 1, n);
        byte[][] operation = new byte[allSit][2 * n + 1];
        for(int i = 0; i < allSit; i++){
            for(int j = 0; j < 2 * n + 1; j++)
                operation[i][j] = -1;
        }
        int[][] prevx = new int[allSit][2 * n + 1];
        int[][] prevy = new int[allSit][2 * n + 1];
        /*boolean[] test = new boolean[5];
        for(int i = 0; i < 5; i++)
            test[i] = false;
        for(int i = 1; i < 3; i++)
            test[i] = true;
        System.out.print(encode(test));*/
        boolean[] state = new boolean[2 * n + 1];
        for(int i = 0; i < 2 * n + 1; i++){
            if(i < n)
                state[i] = true;
            else state[i] = false;
        }
        ArrayDeque<situation> states = new ArrayDeque<>();
        states.add(new situation(state.clone(), n));
        while(!states.isEmpty()){
            situation current = states.remove();
            boolean[] currentState = current.white;
            int currentEmpty = current.empty;
            int currentStateNo = encode(currentState);
            if(currentEmpty > 1){
                if(currentState[currentEmpty - 1] ^ currentState[currentEmpty - 2]){
                    if(currentState[currentEmpty - 2]){
                        boolean[] nextState = currentState.clone();
                        nextState[currentEmpty - 2] = false;
                        nextState[currentEmpty] = true;
                        int nextStateNo = encode(nextState);
                        if(operation[nextStateNo][currentEmpty - 2] == -1){
                            prevx[nextStateNo][currentEmpty - 2] = currentStateNo;
                            prevy[nextStateNo][currentEmpty - 2] = currentEmpty;
                            operation[nextStateNo][currentEmpty - 2] = (byte)(currentEmpty - 1);
                            if(nextStateNo == allSit - 1 && currentEmpty - 2 == n){
                                break;
                            }
                            else{
                                states.add(new situation(nextState, currentEmpty - 2));
                            }
                        }
                    }
                    else{
                        if(operation[currentStateNo][currentEmpty - 2] == -1){
                            prevx[currentStateNo][currentEmpty - 2] = currentStateNo;
                            prevy[currentStateNo][currentEmpty - 2] = currentEmpty;
                            operation[currentStateNo][currentEmpty - 2] = (byte)(currentEmpty - 1);
                            if(currentStateNo == allSit - 1 && currentEmpty - 2 == n){
                                break;
                            }
                            else{
                                states.add(new situation(currentState.clone(), currentEmpty - 2));
                            }
                        }
                    }
                }
            }
            if(currentEmpty > 0){
                if(currentState[currentEmpty - 1]){
                    boolean[] nextState = currentState.clone();
                    nextState[currentEmpty - 1] = false;
                    nextState[currentEmpty] = true;
                    int nextStateNo = encode(nextState);
                    if(operation[nextStateNo][currentEmpty - 1] == -1){
                        prevx[nextStateNo][currentEmpty - 1] = currentStateNo;
                        prevy[nextStateNo][currentEmpty - 1] = currentEmpty;
                        operation[nextStateNo][currentEmpty - 1] = (byte)currentEmpty;
                        if(nextStateNo == allSit - 1 && currentEmpty - 1 == n){
                            break;
                        }
                        else{
                            states.add(new situation(nextState, currentEmpty - 1));
                        }
                    }
                }
                else {
                    if(operation[currentStateNo][currentEmpty - 1] == -1){
                        prevx[currentStateNo][currentEmpty - 1] = currentStateNo;
                        prevy[currentStateNo][currentEmpty - 1] = currentEmpty;
                        operation[currentStateNo][currentEmpty - 1] = (byte)currentEmpty;
                        if(currentStateNo == allSit - 1 && currentEmpty - 1 == n){
                            break;
                        }
                        else{
                            states.add(new situation(currentState.clone(), currentEmpty - 1));
                        }
                    }
                }
            }
            if(currentEmpty < 2 * n - 1){
                if(currentState[currentEmpty + 1] ^ currentState[currentEmpty + 2]){
                    if(currentState[currentEmpty + 2]){
                        boolean[] nextState = currentState.clone();
                        nextState[currentEmpty + 2] = false;
                        nextState[currentEmpty] = true;
                        int nextStateNo = encode(nextState);
                        if(operation[nextStateNo][currentEmpty + 2] == -1){
                            prevx[nextStateNo][currentEmpty + 2] = currentStateNo;
                            prevy[nextStateNo][currentEmpty + 2] = currentEmpty;
                            operation[nextStateNo][currentEmpty + 2] = (byte)(currentEmpty + 3);
                            if(nextStateNo == allSit - 1 && currentEmpty + 2 == n){
                                break;
                            }
                            else{
                                states.add(new situation(nextState, currentEmpty + 2));
                            }
                        }
                    }
                    else{
                        if(operation[currentStateNo][currentEmpty + 2] == -1){
                            prevx[currentStateNo][currentEmpty + 2] = currentStateNo;
                            prevy[currentStateNo][currentEmpty + 2] = currentEmpty;
                            operation[currentStateNo][currentEmpty + 2] = (byte)(currentEmpty + 3);
                            if(currentStateNo == allSit - 1 && currentEmpty + 2 == n){
                                break;
                            }
                            else{
                                states.add(new situation(currentState.clone(), currentEmpty + 2));
                            }
                        }
                    }
                }
            }
            if(currentEmpty < 2 * n){
                if(currentState[currentEmpty + 1]){
                    boolean[] nextState = currentState.clone();
                    nextState[currentEmpty + 1] = false;
                    nextState[currentEmpty] = true;
                    int nextStateNo = encode(nextState);
                    if(operation[nextStateNo][currentEmpty + 1] == -1){
                        prevx[nextStateNo][currentEmpty + 1] = currentStateNo;
                        prevy[nextStateNo][currentEmpty + 1] = currentEmpty;
                        operation[nextStateNo][currentEmpty + 1] = (byte)(currentEmpty + 2);
                        if(nextStateNo == allSit - 1 && currentEmpty + 1 == n){
                            break;
                        }
                        else{
                            states.add(new situation(nextState, currentEmpty + 1));
                        }
                    }
                }
                else {
                    if(operation[currentStateNo][currentEmpty + 1] == -1){
                        prevx[currentStateNo][currentEmpty + 1] = currentStateNo;
                        prevy[currentStateNo][currentEmpty + 1] = currentEmpty;
                        operation[currentStateNo][currentEmpty + 1] = (byte)(currentEmpty + 2);
                        if(currentStateNo == allSit - 1 && currentEmpty + 1 == n){
                            break;
                        }
                        else{
                            states.add(new situation(currentState.clone(), currentEmpty + 1));
                        }
                    }
                }
            }
        }
        int x = allSit - 1;
        int y = n;
        ArrayDeque<Byte> result = new ArrayDeque<>();
        while(!(x == 0 && y == n)){
            int copyx = prevx[x][y];
            int copyy = prevy[x][y];
            result.addFirst(operation[x][y]);
            x = copyx;
            y = copyy;
        }
        int size = result.size();
        int count = 0;
        for(byte number : result) {
            count++;
            if(count % 20 == 0 && count != 0)
                out.println(number);
            else if(count != size)
                out.print(number + " ");
            else out.println(number);
        }
        out.close();                                  // close the output file
    }
    private static int encode(boolean[] state){
        int len = state.length;
        int number = (len - 1) / 2;
        int result = 0;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(state[i]){
                count++;
                if(count == number)
                    break;
            }
            else{
                result += combination(len - i - 1, number - count - 1);
            }
        }
        return result;
    }
    private static int combination(int n, int k){
        return factorials[n].divide(factorials[k]).divide(factorials[n - k]).intValue();
    }
}
/*class situation{
    public boolean[] white;
    public int empty;
    public situation(boolean[] white, int empty){
        this.white = white;
        this.empty = empty;
    }
}*/