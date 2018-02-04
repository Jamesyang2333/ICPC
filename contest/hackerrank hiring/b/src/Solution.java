import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static final int hh = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nqueries = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < nqueries; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long .parseLong(st.nextToken());
            int result = simplestSum(k, a ,b);
            System.out.println(result);
        }
    }
    static int simplestSum(int k, long a, long b){
        BigInteger result = BigInteger.ZERO;
        BigInteger[] answerSet = find(k, a);
        BigInteger acc = answerSet[1];
        BigInteger counter = answerSet[0];
        while(true){
            if(counter.multiply(BigInteger.valueOf(k)).add(BigInteger.ONE).compareTo(BigInteger.valueOf(b)) <= 0){
                result = result.add(((counter.multiply(BigInteger.valueOf(k)).add(BigInteger.ONE).subtract(BigInteger.valueOf(a))).multiply(acc))).mod(BigInteger.valueOf(hh));
                counter = counter.multiply(BigInteger.valueOf(k)).add(BigInteger.ONE);
                acc = acc.add(counter);
                a = counter.longValue();
            }
            else{
                result = result.add((BigInteger.valueOf(b).subtract(BigInteger.valueOf(a)).add(BigInteger.ONE).multiply(acc))).mod(BigInteger.valueOf(hh));
                break;
            }
        }
        return result.intValue();
    }
    private static BigInteger[] find(int k, long a){
        BigInteger[] result = new BigInteger[2];
        BigInteger acc = BigInteger.ONE;
        BigInteger counter = BigInteger.ONE;
        while(true){
            if(counter.multiply(BigInteger.valueOf(k)).add(BigInteger.ONE).compareTo(BigInteger.valueOf(a)) < 0){
                counter = counter.multiply(BigInteger.valueOf(k)).add(BigInteger.ONE);
                acc = acc.add(counter);
            }
            else{
                result[0] = counter;
                result[1] = acc;
                break;
            }
        }
        return result;
    }
}
