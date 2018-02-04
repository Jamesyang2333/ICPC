import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static byte[][] dp;
    private static String line;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        int len = line.length();
        dp = new byte[len][len];
        for(int i = 0; i < len;  i++){
            for(int  j = i + 1;  j < len;  j += 2){
                dp[i][j] = -1;
            }
        }
        int count = 0;
        for(int i = 0; i < len;  i++){
            for(int  j = i + 1;  j < len;  j += 2){
                if(check(i, j))
                    count++;
            }
        }
        System.out.println(count);
    }
    private static boolean check(int i, int j){
        if(dp[i][j] != -1)
            return dp[i][j] == 1;
        if(line.charAt(i) != ')' && line.charAt(j) != '('){
            if(j == i + 1){
                dp[i][j] = 1;
                return true;
            }
            else{
                if(check(i + 1, j - 1)){
                    dp[i][j] = 1;
                    return true;
                }
                else{
                    for(int k = i + 1; k < j; k += 2){
                        if(check(i, k) && check(k + 1, j)){
                            dp[i][j] = 1;
                            return true;
                        }
                    }
                    dp[i][j] = 0;
                    return false;
                }
            }
        }
        else{
            dp[i][j] = 0;
            return false;
        }
    }
}
