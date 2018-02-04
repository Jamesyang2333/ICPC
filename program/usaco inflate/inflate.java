/*
ID: jamesya4
LANG: JAVA
TASK: inflate
*/
import java.io.*;
import java.util.*;

class inflate {
    private static int[] dp;
    private static int[] newtime = new int[170000];
    private static int[] newpoints = new int[170000];
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int maxTime = Integer.parseInt(st.nextToken());
        int qnum = Integer.parseInt(st.nextToken());
        int newproblems = 0;
        for(int i = 0; i < qnum; i++){
            st = new StringTokenizer(f.readLine());
            int points = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= expoent(maxTime / time); j++){
                newtime[newproblems] = time * (1 << (j - 1));
                newpoints[newproblems] = points * (1 << (j - 1));
                newproblems++;
            }
        }
        dp = new int[maxTime + 1];
        for(int i = 0; i <= maxTime; i++) {
            if(newtime[0] <= i)
                dp[i] = newpoints[0];
                else dp[i] = 0;
        }
        for(int i = 1; i < newproblems; i++){
            for(int j = maxTime; j >= 0; j--){
                if(newtime[i] <= j)
                    dp[j] = Math.max(dp[j], newpoints[i] + dp[j - newtime[i]]);
            }
        }
        int result = dp[maxTime];
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
    private static int expoent (int n){
        int count = 0;
        while(n > 0){
            n /= 2;
            count++;
        }
        return count;
    }
}
