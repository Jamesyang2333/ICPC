/*
ID: jamesya4
LANG: JAVA
TASK: buylow
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class buylow {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("buylow.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buylow.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] price = new int[n];
        int[] dp = new int[n];
        BigInteger[] times = new BigInteger[n];
        for(int i = 0; i < n; i++){
            times[i] = BigInteger.ZERO;
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            if(!st.hasMoreTokens())
                st = new StringTokenizer(f.readLine());
            int current = Integer.parseInt(st.nextToken());
            price[i] = current;
            int max = 1;
            for(int j = i - 1; j >= 0; j--){
                if(price[j] > current){
                    if(dp[j] + 1 > max){
                        max = dp[j] + 1;
                    }
                }
            }
            dp[i] = max;
            if(max == 1){
                times[i] = BigInteger.ONE;
            }
            else {
                HashSet<Integer> got = new HashSet<>();
                for(int j = i - 1; j >= 0; j--){
                    if(price[j] > current)
                    if(dp[j] + 1 == max){
                        if(!got.contains(price[j])){
                            got.add(price[j]);
                            times[i] = times[i].add(times[j]);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] > max)
                max = dp[i];
        }
        BigInteger result = BigInteger.ZERO;
        HashSet<Integer> got = new HashSet<>();
        for(int i = n - 1; i >= 0; i--){
            if(dp[i] == max)
            if(!got.contains(price[i])){
                got.add(price[i]);
                result = result.add(times[i]);
            }
        }
        out.println(max + " " + result.toString());                           // output result
        out.close();                                  // close the output file
    }
}
