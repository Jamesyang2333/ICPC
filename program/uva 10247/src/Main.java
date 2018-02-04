import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static BigInteger[] factorials;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        factorials = new BigInteger[3500];
        factorials[0] = BigInteger.ONE;
        for(int i = 1; i < 3500; i++)
            factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());
            int depth = Integer.parseInt(st.nextToken());
            System.out.println(calc(k, depth).toString());
        }

    }
    public static BigInteger calc (int k, int d){
        if(d == 1)
            return factorials[k];
        int total = 0;
        for(int i = 1; i <= d; i++){
            total += power(k, i);
        }
        int subtotal = total / k;
        BigInteger selection = factorials[total].divide(power(factorials[subtotal], k));
        BigInteger subresult = calc(k, d - 1);
        return power(subresult, k).multiply(selection);
    }
    public static BigInteger power(BigInteger base, int exponent){
        BigInteger result = BigInteger.ONE;
        BigInteger accumulator = base;
        while(exponent > 0){
            if(exponent % 2 == 1)
                result = result.multiply(accumulator);
            accumulator = accumulator.multiply(accumulator);
            exponent /= 2;
        }
        return result;
    }
    public static int power(int base, int exponent){
        int result = 1;
        int accumulator = base;
        while(exponent > 0){
            if(exponent % 2 == 1)
                result *= accumulator;
            accumulator *= accumulator;
            exponent /= 2;
        }
        return result;
    }
    public static BigInteger combination(int n, int k){
        return factorials[n].divide(factorials[k]).divide(factorials[n - k]);
    }
}
