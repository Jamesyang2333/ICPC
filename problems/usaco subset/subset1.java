/*
ID: jamesya4
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;

class subset1 {
    private static long result = 0;
    private static int n;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        n = Integer.parseInt(st.nextToken());
        int total = n * (n + 1) / 2;
        if(total % 2 == 0){
        search(0, total / 2);
        }
        out.println(result / 2);                           // output result
        out.close();                                  // close the output file
    }
    private static void search(int max, int rem){
        if(rem == 0){
            result++;
            return;}
        for(int i = max + 1; i <= n && i <= rem; i++){
            if(i == rem){
                search(i, 0);
            }
            if(rem >=  2 * i + 1)
                search(i, rem - i);
        }
    }
}
