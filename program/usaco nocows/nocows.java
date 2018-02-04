/*
ID: jamesya4
LANG: JAVA
TASK: nocows
*/
import java.io.*;
import java.util.*;

class nocows {
    private static long[][] dp;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int cows = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        long result = 0;
        if(cows % 2 == 0)
            result = 0;
        else{
            dp = new long[height + 1][(cows + 1) / 2 + 1];
            for(int i = 0; i <= height; i++)
                for(int j = 0; j <= (cows + 1) / 2; j++)
                    dp[i][j] = -1;
            result = find(height, (cows + 1) / 2);
        }
        out.println(result % 9901);                           // output result
        out.close();                                  // close the output file
        System.out.println(1 << 31);
    }
    private static long find(int height, int number){
        if(number < height) {
            return 0;

        }
        if(height <= 8 && number > (1 << (height - 1)))
            return 0;
        if(height == 1 && number == 1){
            return 1;
        }
        if(dp[height][number] != -1)
            return dp[height][number];
        else {
            long result = 0;
            for (int i1 = 1; i1 <= height - 1; i1++) {
                for (int i2 = i1; (i2 < number) && (i1 > 8 || (i2 <= (1 << (i1 - 1)))); i2++) {
                    int j1;
                    if (i1 < height - 1)
                        j1 = height - 1;
                    else j1 = 1;
                    for (; j1 <= number - i2 && j1 <= height - 1; j1++){
                        result = result + (find(i1, i2) * find(j1, number - i2)) % 9901;
                        result = result % 9901;
                    }
                }
            }
            dp[height][number] = result;
            return result;
        }
    }
}
