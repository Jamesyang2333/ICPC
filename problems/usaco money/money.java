/*
ID: jamesya4
LANG: JAVA
TASK: money
*/
import java.io.*;
import java.util.*;

class money {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("money.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int num = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int[] coins = new int[num];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < num; i++) {
            if(!st.hasMoreTokens())
                st = new StringTokenizer(f.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        long[][] dp = new long[num][amount + 1];
        for(int i = 0; i < num; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < num; i++)
            for(int j = 1; j <= amount; j++)
                dp[i][j] = 0;
        for(int i = 1; i <= amount; i++){
            if(i >= coins[num - 1])
                dp[0][i] = dp[0][i - coins[num - 1]];
            for(int j = 1; j < num; j++){
                dp[j][i] += dp[j - 1][i];
                if(i >= coins[num - 1 - j]){
                    dp[j][i] += dp[j][i - coins[num - 1 - j]];
                }
            }
        }
        out.println(dp[num - 1][amount]);                           // output result
        out.close();                                  // close the output file
    }
}
