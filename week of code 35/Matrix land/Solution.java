//TLE for most tests
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            int[][] sumFromLeft = new int[n][m];
            int[][] sumFromRight = new int[n][m];
            for(int i  = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                matrix[i][0] = Integer.parseInt(st.nextToken());
                sumFromLeft[i][0] = matrix[i][0];
                for(int j = 1; j < m; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    sumFromLeft[i][j] = matrix[i][j] + sumFromLeft[i][j - 1];
                }
            }
            int[][] maxSumFromLeft = new int[n][m];
            int[][] maxSumFromRight = new int[n][m];
            for(int i = 0; i < n; i++){
                maxSumFromLeft[i][m - 1] = sumFromLeft[i][m - 1];
                for(int j = m - 2; j >= 0; j--){
                    maxSumFromLeft[i][j] = Math.max(sumFromLeft[i][j], maxSumFromLeft[i][j + 1]);
                }
            }
            for(int i = 0; i < n; i++){
                sumFromRight[i][0] = sumFromLeft[i][m - 1];
                for(int j = 1; j < m; j++){
                    sumFromRight[i][j] = sumFromLeft[i][m - 1] - sumFromLeft[i][j - 1];
                }
            }
            for(int i = 0; i < n; i++){
                maxSumFromRight[i][0] = sumFromRight[i][0];
                for(int j = 1; j < m; j++)
                    maxSumFromRight[i][j] = Math.max(maxSumFromRight[i][j - 1], sumFromRight[i][j]);
            }
            long[][]best = new long[n][m];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    best[i][j] = -1000000000;
            for(int j = 0; j < m; j++){
                for(int k = 0; k <= j; k++){
                    int leftextra = maxSumFromRight[0][k] - sumFromRight[0][k];
                    int rightextra = maxSumFromLeft[0][j] - sumFromLeft[0][j];
                    int current = 0;
                    if(j < m - 1)
                        current = sumFromRight[0][k] - sumFromRight[0][j + 1] + leftextra + rightextra;
                    else current = sumFromRight[0][k] + leftextra + rightextra;
                    if(best[0][k] < current)
                        best[0][k] = current;
                }
                for(int k = j + 1; k < m; k++){
                    int leftextra = maxSumFromRight[0][j] - sumFromRight[0][j];
                    int rightextra = maxSumFromLeft[0][k] - sumFromLeft[0][k];
                    int current = 0;
                    if(j > 0)
                        current = sumFromLeft[0][k] - sumFromLeft[0][j - 1] + leftextra + rightextra;
                    else current = sumFromLeft[0][k] + leftextra + rightextra;
                    if(best[0][k] < current)
                        best[0][k] = current;
                }

            }
            for(int i = 1; i < n; i++){
                for(int j = 0; j < m; j++){
                    for(int k = 0; k <= j; k++){
                        int leftextra = maxSumFromRight[i][k] - sumFromRight[i][k];
                        int rightextra = maxSumFromLeft[i][j] - sumFromLeft[i][j];
                        long current = 0;
                        if(j < m - 1)
                            current = best[i - 1][j] + sumFromRight[i][k] - sumFromRight[i][j + 1] + leftextra + rightextra;
                        else current = best[i - 1][j] + sumFromRight[i][k] + leftextra + rightextra;
                        if(best[i][k] < current){
                            best[i][k] = current;
                        }
                    }
                    for(int k = j + 1; k < m; k++){
                        int leftextra = maxSumFromRight[i][j] - sumFromRight[i][j];
                        int rightextra = maxSumFromLeft[i][k] - sumFromLeft[i][k];
                        long current = 0;
                        if(j > 0)
                            current = best[i - 1][j] + sumFromLeft[i][k] - sumFromLeft[i][j - 1] + leftextra + rightextra;
                        else current = best[i - 1][j] + sumFromLeft[i][k] + leftextra + rightextra;
                        if(best[i][k] < current){
                            best[i][k] = current;
                        }
                    }

                }
            }
            long result = best[n - 1][0];
            for(int i = 1; i < m; i++)
                result = Math.max(result, best[n - 1][i]);
            System.out.println(result);
        }
        catch (IOException err){}
    }
}
