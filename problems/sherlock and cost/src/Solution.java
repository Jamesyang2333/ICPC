import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int[] dp = new int[101];
            int[] aux = new int[101];
            int[] fromLeft = new int[101];
            int[] fromRight = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= first; j++){
                dp[j] = 0;
            }
            for(int j = first + 1; j < 101; j++){
                dp[j] = -1;
            }
            for(int j = 1; j < n; j++){
                int b = Integer.parseInt(st.nextToken());
                fromLeft[1] = dp[1];
                int last = -1;
                for(int k = 2; k < 101; k++){
                    if(dp[k] == -1){
                        if(last == -1)
                            last = k - 1;
                        fromLeft[k] = fromLeft[k - 1] + 1;
                    }
                    else fromLeft[k] = Math.max(dp[k], fromLeft[k - 1] + 1);
                }
                if(last == -1)
                    last = 100;
                for(int k = 1; k < 100; k++)
                    fromRight[k] = 0;
                fromRight[last] = dp[last];
                for(int k = last - 1; k >= 1; k--){
                    fromRight[k] = Math.max(dp[k], fromRight[k + 1] + 1);
                }
                for(int k = 1; k <= b; k++)
                    aux[k] = Math.max(fromLeft[k], fromRight[k]);
                for(int k = b + 1; k < 101; k++){
                    aux[k] = -1;
                }
                dp = aux.clone();
            }
            int result = 0;
            for(int j = 1; j < 101; j++){
                if(dp[j] > result)
                    result = dp[j];
                if(dp[j] == -1)
                    break;
            }
            System.out.println(result);
        }
    }
}
