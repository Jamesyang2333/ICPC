import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int i = 0; i < ncases; i++){
            int current = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(current == 0)
                System.out.println(1);
            else if(current < 3)
                System.out.println(current);
            else{
            BigInteger result = calc(current - 2).add(BigInteger.valueOf(2));
            System.out.println(result.toString());
            }
        }
    }
    public static BigInteger calc(int current){
        BigInteger number = BigInteger.valueOf(current);
        BigInteger result = (number.pow(4).add(number.pow(3).multiply(BigInteger.valueOf(2))).add(number.pow(2).multiply(BigInteger.valueOf(11))).add(number.multiply(BigInteger.valueOf(34)))).divide(BigInteger.valueOf(24));
        return result;
    }
}
