//TLE when there are 4 million lines of input
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1{
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
            long[] fromLeft = new long[m];
            fromLeft[0] = maxSumFromLeft[0][0];
            for(int j = 1; j < m; j++){
                long next = fromLeft[j - 1] + (maxSumFromLeft[0][j] - maxSumFromLeft[0][j - 1]);
                if(maxSumFromLeft[0][j] - sumFromLeft[0][j - 1] > next){
                    fromLeft[j] = maxSumFromLeft[0][j] - sumFromLeft[0][j - 1];
                }
                else{
                    fromLeft[j] = next;
                }
            }
            long[] fromRight = new long[m];
            fromRight[m - 1] = maxSumFromRight[0][m - 1];
            for(int j = m - 2; j >= 0; j--){
                long next = fromRight[j + 1] + (maxSumFromRight[0][j] - maxSumFromRight[0][j + 1]);
                if(maxSumFromRight[0][j] - sumFromRight[0][j + 1] > next){
                    fromRight[j] = maxSumFromRight[0][j] - sumFromRight[0][j + 1];
                }
                else{
                    fromRight[j] = next;
                }
            }
            for(int j = 0; j < m; j++){
                best[0][j] = Math.max(fromLeft[j], fromRight[j]);
            }
            for(int i = 1; i < n; i++){
                fromLeft = new long[m];
                fromLeft[0] = best[i - 1][0] + maxSumFromLeft[i][0];
                for(int j = 1; j < m; j++){
                    long next = fromLeft[j - 1] + (maxSumFromLeft[i][j] - maxSumFromLeft[i][j - 1]);
                    long alter = maxSumFromLeft[i][j] - sumFromLeft[i][j - 1] + maxSumFromRight[i][j] - sumFromRight[i][j] + best[i - 1][j];
                    if(alter > next){
                        fromLeft[j] = alter;
                        }
                    else{
                        fromLeft[j] = next;
                    }
                }
                fromRight = new long[m];
                fromRight[m - 1] = best[i - 1][m - 1] + maxSumFromRight[i][m - 1];
                for(int j = m - 2; j >= 0; j--){
                    long next = fromRight[j + 1] + (maxSumFromRight[i][j] - maxSumFromRight[i][j + 1]);
                    long alter = maxSumFromLeft[i][j] - sumFromLeft[i][j] + maxSumFromRight[i][j] - sumFromRight[i][j + 1] + best[i - 1][j];
                    if(alter > next){
                        fromRight[j] = alter;
                    }
                    else{
                        fromRight[j] = next;
                    }
                }
                for(int j = 0; j < m; j++){
                    best[i][j] = Math.max(fromLeft[j], fromRight[j]);
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
