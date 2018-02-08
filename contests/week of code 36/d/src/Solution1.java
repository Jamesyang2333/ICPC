import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    static long raceAgainstTime(int n, int mason_height, int[] heights, int[] prices) {
        // Complete this function
        int[] newheights = new int[n];
        newheights[0] = mason_height;
        for(int i = 1; i < n; i++){
            newheights[i] = heights[i - 1];
        }
        long[] dp = new long[n];
        dp[0] = 0;
        HashSet<Integer> heros = new HashSet<>();
        heros.add(0);
        for(int i = 0; i < n - 1; i++){
            long min = Long.MAX_VALUE;
            ArrayList<Integer> getridof = new ArrayList<>();
            for(int j : heros){
                if(newheights[i + 1] > newheights[j])
                    getridof.add(j);
                min = Math.min(dp[j] + Math.abs(newheights[i + 1] - newheights[j]) + prices[i], min);
            }
            for(int a : getridof)
                heros.remove(a);
            heros.add(i + 1);
            dp[i + 1] = min;
        }
        long answer = Long.MAX_VALUE;
        for(int i : heros){
            if(dp[i] < answer)
                answer = dp[i];
        }
        return (answer + n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mason_height = in.nextInt();
        int[] heights = new int[n-1];
        for(int heights_i = 0; heights_i < n-1; heights_i++){
            heights[heights_i] = in.nextInt();
        }
        int[] prices = new int[n-1];
        for(int prices_i = 0; prices_i < n-1; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        long result = raceAgainstTime(n, mason_height, heights, prices);
        System.out.println(result);
        in.close();
    }
}
