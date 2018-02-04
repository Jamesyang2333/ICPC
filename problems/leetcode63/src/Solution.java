class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        if(obstacleGrid[0][0] == 1)
            return 0;
        paths[0][0] = 1;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0){
                    if(obstacleGrid[i][j] == 1)
                        paths[i][j] = 0;
                    else paths[i][j] = paths[i][j-1];
                }
                else if(j == 0){
                    if(obstacleGrid[i][j] == 1)
                        paths[i][j] = 0;
                    else paths[i][j] = paths[i-1][j];
                }
                else{
                    if(obstacleGrid[i][j] == 1)
                        paths[i][j] = 0;
                    else paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        return paths[m-1][n-1];
    }
}