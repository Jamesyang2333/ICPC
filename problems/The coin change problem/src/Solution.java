import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] coins = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            coins[i] = Integer.parseInt(st.nextToken());
        long[][] dp = new long[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++)
            for(int j = 0; j < n + 1; j++)
                dp[i][j] = 0;
        dp[0][0] = 1;
        for(int i = 1; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                int max = j / coins[i - 1];
                long acc = 0;
                for(int k = 1; k <= max; k++){
                    for(int l = 0; l < i; l++){
                        acc += dp[l][j - k * coins[i - 1]];
                    }
                }
                dp[i][j] = acc;
            }
        }
        long result = 0;
        for(int i = 1; i < m + 1; i++){
            result += dp[i][n];
        }
        System.out.println(result);
    }
}
