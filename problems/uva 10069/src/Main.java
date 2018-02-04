import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            String sequence = br.readLine();
            String pattern = br.readLine();
            int len = sequence.length();
            BigInteger[] dp = new BigInteger[len];
            int words = pattern.length();
            for(int j = 0; j < words; j++){
                BigInteger prev = BigInteger.ZERO;
                for(int k = 0; k < len; k++){
                    BigInteger prevcopy = dp[k];
                    if(k == 0){
                        if(j == 0 && sequence.charAt(0) == pattern.charAt(0))
                            dp[0] = BigInteger.ONE;
                        else dp[0] = BigInteger.ZERO;
                    }else{
                        if(sequence.charAt(k) == pattern.charAt(j)){
                            if(j == 0)
                                dp[k] = BigInteger.ONE.add(dp[k - 1]);
                            else
                                dp[k] = prev.add(dp[k - 1]);
                        }
                        else
                            dp[k] = dp[k - 1];
                    }
                    prev = prevcopy;
                }
            }
            System.out.println(dp[len - 1].toString());
        }
    }
}
