import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[][] dp = new BigInteger[151][151];
        for(int i = 0; i < 151; i++)
            for(int j = 0; j < 151; j++)
                dp[i][j] = BigInteger.ZERO;
        dp[0][0] = BigInteger.ONE;
        dp[1][1] = BigInteger.ONE;
        for(int i = 2; i < 151; i++){
            for(int j = 1; j <= i; j++){
                BigInteger result = BigInteger.ZERO;
                for(int k = i - 1; k >= 0; k--){
                    for(int l = 0; l < j; l++){
                        result = result.add(dp[k][j - 1].multiply(dp[i - 1 - k][l]));
                    }
                }
                for(int k = i - 1; k >= 0; k--){
                    for(int l = 0; l < j - 1; l++){
                        result = result.add(dp[k][j].multiply(dp[i - 1 - k][l]));
                    }
                }
                for(int k = i - 1; k >= 0; k--){
                    result = result.add(dp[k][j - 1].multiply(dp[i - 1 - k][j]));
                }
                dp[i][j] = result;
            }
        }
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken()) / 2;
            int b = Integer.parseInt(st.nextToken());
            System.out.println(dp[a][b].toString());
        }
    }
}
