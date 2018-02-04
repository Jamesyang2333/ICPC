import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] cut;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int len = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(len == 0)
                break;
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            cut = new int[n + 2];
            cut[0] = 0;
            cut[n + 1] = len;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i < n + 1; i++){
                cut[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[n + 1][n + 1];
            for(int i = 0; i < n + 1; i++)
                for (int j = 0; j < n + 1; j++)
                    dp[i][j] = -1;
            System.out.format("The minimum cutting is %d.\n", findmin(0, n, dp));
        }
    }
    public static int findmin(int start, int end, int[][] dp){
        if(dp[start][end] != -1)
            return dp[start][end];
        if(start == end){
            dp[start][end] = 0;
            return dp[start][end];
        }
        int len = cut[end + 1] - cut[start];
        int min = findmin(start, start, dp) + findmin(start + 1, end, dp);
        for(int i = start + 1; i < end; i++){
            if(findmin(start, i, dp) + findmin(i + 1, end, dp) < min)
                min = findmin(start, i, dp) + findmin(i + 1, end, dp);
        }
        dp[start][end] = min + len;
        return dp[start][end];
    }
}
