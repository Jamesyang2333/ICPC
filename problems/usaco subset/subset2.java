/*
ID: jamesya4
LANG: JAVA
TASK: subset
*/
//To do this problem a year later
//used dp + rolling array
//take into consideration the same trick used as in 01knapsack could improve performance;
import java.io.*;
import java.util.*;

class subset2 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int sum = (n + 1) * n / 2;
        if((sum & 1) > 0){
            out.println(0);
            out.close();
            return;
        }
        int target = sum / 2;
        long[] dp = new long[target + 1];
            for(int j = 0; j <= target; j++)
                dp[j] = 0;
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = target; j >= 0 ; j--){
                if(j < i)
                    dp[j] = dp[j];
                else
                    dp[j] = dp[j] + dp[j - i];
            }
        }
        out.println(dp[target] / 2);                           // output result
        out.close();                                  // close the output file
    }
}
