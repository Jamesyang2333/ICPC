import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private static BigInteger[] factorial = new BigInteger[101];
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            factorial[0] = BigInteger.ONE;
            for(int i = 1; i < 101; i++){
                factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
            }
            while (true){
                line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                if(n == 0 && k == 0)
                    break;
                System.out.format("%d things taken %d at a time is ", n, k);
                System.out.print(combination(n, k));
                System.out.println(" exactly.");
            }}
        catch (IOException err){}
    }
    private static long combination(int n, int k){
        BigInteger ans = factorial[n].divide(factorial[n - k].multiply(factorial[k]));
        long result = ans.longValue();
        return result;

    }
}
