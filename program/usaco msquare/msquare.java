/*
ID: jamesya4
LANG: JAVA
TASK: msquare
*/
import java.io.*;
import java.util.*;

class msquare {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int[] target = new int[8];
        for(int i = 0; i < 8; i++)
            target[i] = Integer.parseInt(st.nextToken());
        square end = new square(target);
        int[] marked = new int[40320];
        byte[] operation = new byte[40320];
        int[] previous = new int[40320];
        for(int i = 0; i < 40320; i++){
            marked[i] = -1;
        }
        ArrayDeque<square> states = new ArrayDeque<>();
        marked[0] = 0;
        int[] ini = new int[8];
        for(int i = 0; i < 8; i++)
            ini[i] = i + 1;
        states.add(new square(ini));
        while(!states.isEmpty()) {
            square current = states.remove();
            int currentVal = current.toInt();
            square op1 = current.op1();
            int op1Val = op1.toInt();
            if (marked[op1Val] == -1) {
                marked[op1Val] = marked[currentVal] + 1;
                previous[op1Val] = currentVal;
                operation[op1Val] = 1;
                if(op1.equals(end))
                    break;
                states.add(op1);
            }
            square op2 = current.op2();
            int op2Val = op2.toInt();
            if (marked[op2Val] == -1) {
                marked[op2Val] = marked[currentVal] + 1;
                previous[op2Val] = currentVal;
                operation[op2Val] = 2;
                if(op2.equals(end))
                    break;
                states.add(op2);
            }
            square op3 = current.op3();
            int op3Val = op3.toInt();
            if(marked[op3Val] == -1){
                marked[op3Val] = marked[currentVal] + 1;
                previous[op3Val] = currentVal;
                operation[op3Val] = 3;
                if(op3.equals(end)){
                    break;
                }
                states.add(op3);
            }
        }
        int result = marked[end.toInt()];
        int[] manips = new int[result];
        int p = end.toInt();
        for(int i = 0; i < result; i++){
            manips[result - 1 - i] = operation[p];
            p = previous[p];
        }
        out.println(result);                           // output result
        for(int i = 0; i < result; i++){
            if(manips[i] == 1)
                out.print('A');
            else if(manips[i] == 2)
                out.print('B');
            else out.print('C');
        }
        out.println();
        out.close();                                  // close the output file
    }
}
class square{
    public static int[] factorial = {1,1,2,6,24,120,720,5040};
    public int[] sequence = new int[8];
    public square(int[] a){
        for(int i = 0; i < 8; i++){
            sequence[i] = a[i];
        }
    }
    public boolean equals(square a){
        boolean isEqual = true;
        for(int i = 0; i < 8; i++){
            if(sequence[i] != a.sequence[i]){
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }
    public int toInt(){
        int sum = 0;
        sum += (sequence[0] - 1) * factorial[7];
        for(int i = 1 ; i < 7; i++){
            int rank = 0;
            for(int j = i + 1; j < 8; j++){
                if(sequence[i] > sequence[j])
                    rank++;
            }
            sum += rank * factorial[7 - i];
        }
        return sum;
    }
    public square op1(){
        int[] nextSequence = new int[8];
        for(int i = 0; i < 8; i++){
            nextSequence[i] = sequence[7 - i];
        }
        return new square(nextSequence);
    }
    public square op2(){
        int[] nextSequence = new int[8];
        for(int i = 1; i < 4; i++){
            nextSequence[i] = sequence[i - 1];
        }
        for(int i = 4; i < 7; i++){
            nextSequence[i] = sequence[i + 1];
        }
        nextSequence[0] = sequence[3];
        nextSequence[7] = sequence[4];
        return new square(nextSequence);
    }
    public square op3(){
        int[] nextSequence = new int[8];
        nextSequence[0] = sequence[0];
        nextSequence[1] = sequence[6];
        nextSequence[2] = sequence[1];
        nextSequence[3] = sequence[3];
        nextSequence[4] = sequence[4];
        nextSequence[5] = sequence[2];
        nextSequence[6] = sequence[5];
        nextSequence[7] = sequence[7];
        return new square(nextSequence);
    }
}
