/*
ID: jamesya4
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

class numtri {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[][] triangle = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++)
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
        for(int i = 1; i < n; i++)
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        for(int i = 2; i < n; i++)
            for(int j = 1; j < i; j++){
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        int max = dp[n - 1][0];
        for(int i = 1; i < n; i++)
            max = Math.max(max, dp[n - 1][i]);
        out.println(max);                           // output result
        out.close();                                  // close the output file
    }
}
