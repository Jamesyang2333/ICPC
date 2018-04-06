/*
ID: jamesya4
LANG: JAVA
TASK: subset
*/
//A dp method I did when I'm new to dp, quite redundant and really hard to understand
import java.io.*;
import java.util.*;

class subset {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int total = n * (n + 1) / 2;
        long result;
        if (total % 2 == 1)
            result = 0;
        else{
            int sum = total / 2;
            long[][] dp = new long[n + 1][sum + 1];
            long[][] dp2 = new long[n + 1][sum + 1];
            dp[1][1] = 1;
            dp2[1][1] = 1;
            for(int i = 2; i <= n;  i++){
                dp[i][1] = 0;
                dp2[i][1] = 0;
            }
            for(int j = 2; j <= sum; j++){
                for(int i = 1; i <= n; i++){
                    if(i == j)
                        dp[i][j] = 1;
                    else if(i == n) dp[i][j] = 0;
                    else if((j < 2 * i + 1))
                        dp[i][j] = 0;
                    else{
                        dp[i][j] = dp2[i + 1][j - i];
                    }
                }
                dp2[n][j] = dp[n][j];
                for(int i = n - 1; i >= 1; i--){
                    dp2[i][j] = dp2[i + 1][j] + dp[i][j];
                }
            }
            result = dp2[1][sum] / 2;
            /*for(int i = 1; i <= n; i++){
                for(int j = 1; j <= sum; j++)
                    System.out.print(dp[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= sum; j++)
                    System.out.print(dp2[i][j] + " ");
                System.out.println();
            }*/
        }
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
}
