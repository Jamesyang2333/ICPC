/*
ID: jamesya4
LANG: JAVA
TASK: zerosum
*/
import java.io.*;
import java.util.*;

class zerosum {
    private static int n;
    private static int reg = 1;
    private static int[] result;
    private static PrintWriter out;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
        // input file name goes above
        out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        n = Integer.parseInt(st.nextToken());
        result = new int[n - 1];
        search(1, 0);
        out.close();                                  // close the output file
    }
    private static void search(int x, int val){
        if(x == n - 1){
            if(reg < 0)
                if(val + reg * 10 - x - 1 == 0){
                    result[x - 1] = 2;
                    printResult();
            }
            if(reg > 0)
                if(val + reg * 10 + x + 1 == 0){
                    result[x - 1] = 2;
                    printResult();
                }
            if ((val + reg + x + 1) == 0){
                result[x - 1] = 0;
                printResult();
            }
            if(val + reg - x - 1 == 0){
                result[x - 1] = 1;
                printResult();
            }
        }
        else{
            int temp = reg;
            if(temp > 0){
                reg = temp * 10 + x + 1;
                result[x - 1] = 2;
                search(x + 1, val);
            }
            else{
                reg = temp * 10 - x -1;
                result[x - 1] = 2;
                search(x + 1, val);
            }
            reg = x + 1;
            result[x - 1] = 0;
            search(x + 1, val + temp);
            reg = - x - 1;
            result[x - 1] = 1;
            search(x + 1, val + temp);
            reg = temp;
    }
    }
    private static void printResult(){
        for(int i = 1; i < n; i++){
            out.print(i);
            if(result[i - 1] == 0)
                out.print("+");
            else if(result[i - 1] == 1)
                out.print("-");
            else out.print(" ");
        }
        out.print(n);
        out.println();
    }
}
