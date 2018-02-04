import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1 {
    private static BigInteger[] factorials;
    public static void main(String[] args) throws IOException{
        factorials = new BigInteger[1001];
        factorials[0] = BigInteger.ONE;
        factorials[1] = BigInteger.ONE;
        for(int i = 2; i < 1001; i++)
            factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            int n = Integer.parseInt(new StringTokenizer(line).nextToken());
            BigInteger answer = BigInteger.ZERO;
            for(int i = 0; i <= n / 2; i++){
                for(int j = 0; j <= (n - 2 * i) / 3; j++){
                    int rem = n - i * 2 - j * 3;
                    int total = rem + i + j;
                    BigInteger result = combination(total, i).multiply(combination(total - i, j)).multiply(power(rem));
                    answer = answer.add(result);
                }
            }
            System.out.println(answer);
        }
    }
    private static BigInteger combination(int n, int k){
        if(k == 0 || k == n)
            return BigInteger.ONE;
        else return factorials[n].divide(factorials[k]).divide(factorials[n - k]);
    }
    private static BigInteger power(int e){
        BigInteger result = BigInteger.ONE;
        BigInteger acc = BigInteger.valueOf(2);
        while(e > 0){
            if(e % 2 == 1)
                result = result.multiply(acc);
            e /= 2;
            acc = acc.multiply(acc);
        }
        return result;
    }
}
