/*
ID: jamesya4
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class lds {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("lds.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lds.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] sequence = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++)
            sequence[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(sequence[j] > sequence[i])
                    max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
        }

        
        out.println(dp[n - 1]);                           // output result
        out.close();                                  // close the output file
    }
}
