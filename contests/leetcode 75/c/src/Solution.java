class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
       double[][] tower = new double[100][];
       for(int i = 0; i < 100; i++)
           tower[i] = new double[i + 1];
       tower[0][0] = poured;
       for(int i = 0; i < 100; i++){
           boolean flowtonext = false;
           for(int j = 0; j < i + 1; j++){
               if(tower[i][j] > 1){
                   flowtonext = true;
                   tower[i + 1][j] += (tower[i][j] - 1) / 2;
                   tower[i + 1][j + 1] += (tower[i][j] - 1) / 2;
               }
           }
           if(!flowtonext)
               break;
       }
       return tower[query_row][query_glass];
    }
}