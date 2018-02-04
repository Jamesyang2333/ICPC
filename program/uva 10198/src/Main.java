import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[1001];
        dp[1] = BigInteger.valueOf(2);
        dp[2] = BigInteger.valueOf(5);
        dp[3] = BigInteger.valueOf(13);
        for(int i = 4; i < 1001; i++){
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(2)).add(dp[i - 2]).add(dp[i - 3]);
        }
        while(true){
            String line = br.readLine();
            if(line == null)
            if(line == null)
                break;
            int n = Integer.parseInt(new StringTokenizer(line).nextToken());
            System.out.println(dp[n].toString());
        }
    }
}
