import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[10001];
        dp[1] = BigInteger.ONE;
        for(int i = 2; i < 100; i++){
            int first = 1;
            BigInteger min = hanoi(i - 1).add(BigInteger.valueOf(2));
            for(int j = 2; j < i; j++){
                BigInteger times = hanoi(i - j);
                times = times.add(dp[j].multiply(BigInteger.valueOf(2)));
                if(times.compareTo(min) < 0){
                    min = times;
                    first = j;
                }
            }
            System.out.println(first);
            dp[i] = min;
        }
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            int n = Integer.parseInt(new StringTokenizer(line).nextToken());
            System.out.println(dp[n].toString());
        }
    }
    public static BigInteger hanoi(int n){
        BigInteger result = BigInteger.ONE;
        BigInteger accumulator = BigInteger.valueOf(2);
        while(n > 0){
            if(n % 2 == 1)
                result = result.multiply(accumulator);
            accumulator = accumulator.multiply(accumulator);
            n /= 2;
        }
        return result.subtract(BigInteger.ONE);
    }
}
