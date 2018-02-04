public class Solution {
    private boolean canpass = false;
    private int[][] map;
    private byte[][] dp;
    private int[] xmove = {0, 0, 1, -1};
    private int[] ymove = {1, -1, 0, 0};
    private int N;
    public int swimInWater(int[][] grid) {
        N = grid.length;
        map = grid;
        dp = new byte[N][N];
        for(int i = map[0][0]; i <= N * N - 1; i++){
            canpass = false;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    dp[j][k] = -1;
                }
            }
            dfs(0, 0, i);
            if(canpass)
                return i;
        }
        return 0;
    }
    private void dfs(int x, int y, int max){
        dp[x][y] = 1;
        if(x == N - 1 && y == N - 1){
            canpass = true;
        }
        else{
            for(int i = 0; i < 4; i++){
                int newx = x + xmove[i];
                int newy = y + ymove[i];
                if(newx >= 0 && newy >= 0 && newx < N && newy < N){
                    if(dp[newx][newy] == -1){
                    if(map[newx][newy] <= max){
                        dfs(newx, newy, max);
                    }
                    else{
                        dp[newx][newy] = 0;
                    }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        int[][] grid = {{0, 2}, {1, 3}};
        Solution test = new Solution();
        System.out.println(test.swimInWater(grid));
    }
}
