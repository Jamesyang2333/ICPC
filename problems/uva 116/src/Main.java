import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static info[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[row][column];
            for(int i = 0; i < row; i++){
                for(int j = 0;  j < column; j++){
                    if(!st.hasMoreTokens())
                        st = new StringTokenizer(br.readLine());
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new info[row][column];
            for(int i = 0; i < row; i++){
                dp[i][0] = new info(matrix[i][0], -1);
            }
            for(int j = 1; j < column; j++){
                for(int i = 1; i < row - 1; i++){
                    long min = dp[i - 1][j - 1].val;
                    int prev = i - 1;
                    for(int k = i; k <= i + 1;  k++){
                        if(dp[k][j - 1].val <  min){
                            min = dp[k][j - 1].val;
                            prev = k;
                        }
                        else if(dp[k][j - 1].val == min){
                            if(!compare(j - 1, prev, k)){
                                prev = k;
                            }
                        }
                    }
                    dp[i][j] = new info(min + matrix[i][j], prev);
                }
                long min = dp[0][j - 1].val;
                int prev = 0;
                if(row > 1){
                if(dp[1][j - 1].val < min){
                    min = dp[1][j - 1].val;
                    prev = 1;
                }
                else if(dp[1][j - 1].val == min){
                    if(!compare(j - 1, prev, 1)){
                        prev = 1;
                    }
                }}
                if(dp[row - 1][j - 1].val < min){
                    min = dp[row - 1][j - 1].val;
                    prev = row - 1;
                }
                else if(dp[row - 1][j - 1].val == min){
                    if(!compare(j - 1, prev, row - 1)){
                        prev = row - 1;
                    }
                }
                dp[0][j] = new info(min + matrix[0][j], prev);
                min = dp[0][j - 1].val;
                prev = 0;
                for(int k = row - 2; k <= row - 1;  k++){
                    if (k > 0) {
                    if(dp[k][j - 1].val <  min){
                        min = dp[k][j - 1].val;
                        prev = k;
                    }
                    else if(dp[k][j - 1].val == min){
                        if(!compare(j - 1, prev, k)){
                            prev = k;
                        }
                    }
                    }
                }
                dp[row - 1][j] = new info(min + matrix[row - 1][j], prev);
            }
            long min = dp[0][column - 1].val;
            int minrow = 0;
            for(int i = 1; i < row; i++){
                if(dp[i][column - 1].val < min){
                    min = dp[i][column - 1].val;
                    minrow = i;
                }
                else if(dp[i][column - 1].val == min){
                    if(!compare(column - 1, minrow, i)){
                        minrow = i;
                    }
                }
            }
            Stack<Integer> sequence = new Stack<>();
            for(int i = 0; i < column; i++){
                sequence.push(minrow + 1);
                minrow = dp[minrow][column - 1 - i].prev;
            }
            for(int i = 0; i < column - 1; i++){
                System.out.print(sequence.pop() + " ");
            }
            System.out.println(sequence.pop());
            System.out.println(min);
        }
    }
    public static boolean compare(int column, int row1, int row2){
        Stack<Integer> sequence1 = new Stack<>();
        for(int i = 0; i <= column; i++){
            sequence1.push(row1);
            row1 = dp[row1][column - i].prev;
        }
        Stack<Integer> sequence2 = new Stack<>();
        for(int i = 0; i <= column; i++){
            sequence2.push(row2);
            row2 = dp[row2][column - i].prev;
        }
        for(int i = 0; i <= column; i++){
            int val1 = sequence1.pop();
            int val2 = sequence2.pop();
            if(val1 < val2)
                return true;
            if(val2 < val1)
                return false;
        }
        return true;
    }
}
class info{
    long val;
    int prev;
    public info(long val, int prev){
        this.val = val;
        this.prev = prev;
    }
}