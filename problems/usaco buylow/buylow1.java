/*
ID: jamesya4
LANG: JAVA
TASK: buylow
*/
import java.io.*;
import java.util.*;

class buylow1 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("buylow.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buylow.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        st = new StringTokenizer(f.readLine());
        int count = 0;
        dp[0] = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(!st.hasMoreTokens())
                st = new StringTokenizer(f.readLine());
            int current = Integer.parseInt(st.nextToken());
            for(int j = count; j >= 0; j--){
                if(current < dp[j]){
                    if(j == count){
                        dp[++count] = current;
                    }
                    else{
                        if(dp[j + 1] < current) {
                            dp[j + 1] = current;
                        }
                    }
                    break;
                }
            }
        }
        out.println(count);                           // output result
        out.close();                                  // close the output file
    }
}
