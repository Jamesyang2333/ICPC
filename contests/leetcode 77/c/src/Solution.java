class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int nrows = grid.length;
        int[] left = new int[nrows];
        int ncols = grid[0].length;
        int[] top = new int[ncols];
        for(int i = 0; i < nrows; i++){
            int max = -1;
            for(int j = 0; j  < ncols; j++){
                if(grid[i][j] > max)
                    max = grid[i][j];
            }
            left[i] = max;
        }
        for(int i = 0; i < ncols; i++){
            int max = -1;
            for(int j = 0; j < nrows; j++){
                if(grid[j][i] > max)
                    max = grid[j][i];
            }
            top[i] = max;
        }
        int result = 0;
        for(int i = 0; i < nrows; i++){
            for(int j = 0; j < ncols; j++){
                result += (Math.min(left[i], top[j]) - grid[i][j]);
            }
        }
        return result;
    }
}