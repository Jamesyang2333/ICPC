public class Solution {
    int[][] dp;
    int[] weight;
    int[] value;
    int totalWeight;
    public int solve(int[] weight, int[] value, int totalWeight){
        int n = weight.length;
        this.weight = weight;
        this.totalWeight = totalWeight;
        this.value = value;
        dp = new int[n][totalWeight+1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j <= totalWeight; j++)
                dp[i][j] = -1;
        return solve1(n-1, totalWeight);
    }

    private int solve1(int i, int w) {
        if (dp[i][w] != -1)
            return dp[i][w];
        if (i == 0) {
            if (w >= weight[i]) {
                dp[i][w] = value[i];
            } else {
                dp[i][w] = 0;
            }
            return dp[i][w];
        }
        if (w >= weight[i]) {
            dp[i][w] = Math.max(solve1(i - 1, w), solve1(i - 1, w - weight[i]) + value[i]);
            return dp[i][w];
        }
        else{
            dp[i][w] = dp[i - 1][w];
            return dp[i][w];
        }
    }
}
