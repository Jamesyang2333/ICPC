import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Solution {
    private static int[][] matrix;
    private static int n;
    private static int m;
    private static int k;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            matrix = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrix[i][j] = -1000;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (matrix[i][j] == -1000)
                        matrix[i][j] = fill(i, j);
                }
            }
            for(int i = 0; i < n; i++){
                System.out.print(matrix[i][0]);
                for(int j = 1; j < n; j++)
                    System.out.print(" " + matrix[i][j]);
                System.out.println();
            }
        }
        catch(IOException err){}
    }
    private static int fill(int i, int j){
        if(matrix[i][j] != -1000){
            return matrix[i][j];
        }
        else{
            if(i == 0 && j == 0)
                matrix[i][j] = m;
            else if(i == j)
                matrix[i][j] = fill(i - 1, j - 1) + k;
            else if(i > j)
                matrix[i][j] = fill(i - 1, j) - 1;
            else if(i < j)
                matrix[i][j] = fill(i, j - 1) - 1;
            return matrix[i][j];
        }
    }
}
