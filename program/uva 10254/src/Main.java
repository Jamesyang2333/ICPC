import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] first = new int[10001];
        BigInteger[] dp = new BigInteger[10001];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        first[2] = 1;
        first[3] = 1;
        first[4] = 1;
        int count = 2;
        int counter = 0;
        int val = 1;
        for(int i = 5; i < 10001; i++){
            if(counter == count){
                first[i] = val;
                count++;
                counter = 0;
            }
            else{
                counter++;
                val++;
                first[i] = val;
            }
        }
        for(int i = 2; i < 10001; i++){
            dp[i] = dp[first[i]].multiply(BigInteger.valueOf(2)).add(hanoi(i - first[i]));
        }
        System.out.println(first[10000]);
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
