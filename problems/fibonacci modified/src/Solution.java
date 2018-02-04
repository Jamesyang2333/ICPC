import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        BigInteger[] fib = new BigInteger[n];
        fib[0] = BigInteger.valueOf(t1);
        fib[1] = BigInteger.valueOf(t2);
        for(int i = 2; i < n; i++){
            fib[i] = fib[i - 2].add(fib[i - 1].pow(2));
        }
        System.out.println(fib[n - 1]);
    }
}
