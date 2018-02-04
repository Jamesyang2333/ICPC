/*
ID: jamesya4
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class ldsQuick {
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
        int count = 0;
        dp[0] = sequence[0];
        for(int i = 0; i < n; i++){
            boolean further = true;
            if(sequence[i] < dp[count]) {
                dp[++count] = sequence[i];
                continue;
            }
            for(int j = count - 1; j >= 0; j--){
                if(sequence[i] < dp[j])
                    if(sequence[i] > dp[j + 1]) {
                    dp[j + 1]++;
                    further = false;
                    break;
                    }
            }
            if(further)
                if (sequence[i] > dp[0])
                    dp[0] = sequence[i];
        }

        out.println(dp[count] + 1);                           // output result
        out.close();                                  // close the output file
    }
}
