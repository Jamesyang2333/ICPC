class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        for(int i = 0; i < b; i++){
            int n = matrix[0][i];
            for(int j = 1; j < b - i && j < a; j++){
                if(matrix[j][i + j] != n){
                    return false;
                }
            }
        }
        for(int i = 1; i < a; i++){
            int n = matrix[i][0];
            for(int j = 1; j < b && j < a - i; j++){
                if(matrix[i + j][j] != n)
                    return false;
            }
        }
        return true;
    }
}