//Got AC
//Turns out in this situation array is more efficient than hashmap
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    static int winningHands(int m, int x, int[] a) {
        // Complete this function
        int[] dp = new int[m];
        int[] aux = new int[m];
        for(int i = 0; i < m; i++){
            dp[i] = 0;
            aux[i] = 0;
        }
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < m; j++){
                int rem  = 0;
                if(dp[j] != 0)
                    rem = (int)(((long)j) * a[i] % m);
                else continue;
                aux[rem] += dp[j];
            }
            aux[a[i] % m]++;
            for(int j = 0; j < m; j++){
                dp[j] += aux[j];
                aux[j] = 0;
            }
        }
        return dp[x];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = winningHands(m, x, a);
        System.out.println(result);
        in.close();
    }
}