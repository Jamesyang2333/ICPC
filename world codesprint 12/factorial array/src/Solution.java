//TLE
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int[] A;
    private static long[] dp;
    public static void main(String[] args) {
        dp = new long[40];
        dp[1] = 1;
        for(int i = 2; i < 40; i++){
            dp[i] = (i * dp[i - 1]) % 1000000000;
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < m; a0++){
            int op = in.nextInt();
            if(op == 1)
                increase(in.nextInt(), in.nextInt());
            else if(op == 3)
                set(in.nextInt(), in.nextInt());
            else{
                int start = in.nextInt();
                int end = in.nextInt();
                long result = 0;
                for(int i = start - 1; i <= end - 1; i++){
                    result = (result + fac(A[i])) % 1000000000;
                }
                System.out.println(result);
            }
        }
        in.close();
    }
    private static void increase (int l, int r){
        for(int i = l - 1; i <= r - 1; i++){
            A[i] += 1;
        }
    }
    private static void set(int i, int v){
        A[i - 1] = v;
    }
    private static long fac(int a){
        if(a >= 40)
            return 0;
        else return dp[a];
    }
}
