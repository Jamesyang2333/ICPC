import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] fibs = new BigInteger[500];
        fibs[0] = BigInteger.ONE;
        fibs[1] = fibs[0].add(fibs[0]);
        int result = 0;
        for(int i = 2; i < 500; i++) {
            fibs[i] = fibs[i - 1].add(fibs[i - 2]);
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num1 = st.nextToken();
            String num2 = st.nextToken();
            BigInteger a = new BigInteger(num1);
            BigInteger b = new BigInteger(num2);
            if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO))
                break;
            int arank = Arrays.binarySearch(fibs, a);
            int brank = Arrays.binarySearch(fibs, b);
            if(arank < 0)
                arank = - arank - 1;
            if(brank < 0)
                brank = -brank - 2;
            System.out.println((brank - arank + 1));
        }
    }
}
