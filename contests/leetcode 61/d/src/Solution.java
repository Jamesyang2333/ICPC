//why this work?
//because the movement of first k steps has no effect on the later steps
public class Solution {
    private int N;
    private int[][] grid1;
    private int[][][] dp;
    private int[] firstMov = {0, 0, -1, -1};
    private int[] secondMov = {-1, 0, 0, -1};
    public int cherryPickup(int[][] grid) {
        grid1 = grid;
        N = grid.length;
        dp = new int[2 * N - 1][N][N];
        for(int i = 0; i < 2 * N - 1; i++)
            for(int j = 0; j < N; j++)
                for(int k = 0; k < N; k++)
                    dp[i][j][k] = -1;
        int result = dp(2 * N - 2, N - 1,  N - 1);
        if(result == -2)
            return 0;
        else return result;
    }
    private int dp(int sum, int x1, int x2){
        if(dp[sum][x1][x2] != -1)
            return dp[sum][x1][x2];
        else{
            if(sum == 0){
                if(grid1[0][0] == 0)
                    dp[sum][x1][x2] = 0;
                else dp[sum][x1][x2] = 1;
            }else{
            if(grid1[x1][sum - x1] != -1 && grid1[x2][sum - x2] != -1){
                boolean can = false;
                int result = -2;
                for(int i = 0; i < 4; i++){
                    int newx1 = x1 + firstMov[i];
                    int newx2 = x2 + secondMov[i];
                    if(newx1 <= sum - 1 && newx2 <= sum - 1 && newx1 >= 0 && newx2 >= 0){
                        int prev = dp(sum - 1, newx1, newx2);
                        if(prev != -2){
                            if(!can)
                                can = true;
                            if(x1 != x2)
                                result = Math.max(result, prev + grid1[x1][sum - x1] + grid1[x2][sum - x2]);
                            else result = Math.max(result, prev + grid1[x1][sum - x1]);
                        }
                    }
                    dp[sum][x1][x2] = result;
                }
            }
            else dp[sum][x1][x2] = -2;}
            return dp[sum][x1][x2];
        }
    }
    public static void main(String[] args){
        int[][] grid = {{0, 1, -1}, {1, 0,  -1}, {1, 1, 1}};
        Solution test = new Solution();
        System.out.println(test.cherryPickup(grid));
    }
}
