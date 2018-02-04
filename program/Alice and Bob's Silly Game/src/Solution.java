import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static boolean[] primes = new boolean[100001];
    public static void main(String[] args) throws IOException{
        for(int i = 0; i <= 100000; i++)
            primes[i] = true;
        for(int i = 2; i < 100000; i++){
            if(primes[i]){
                for(int j = 2 * i; j <= 100000; j += i){
                    primes[j] = false;
                }
            }
        }
        for(int i = 2;  i <= 100000; i++){
            if(primes[i])
                primes[i] = !primes[i - 1];
            else primes[i] = primes[i - 1];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(br.readLine());
        for(int i = 0; i < ncases; i++){
            if(primes[Integer.parseInt(br.readLine())])
                System.out.println("Bob");
            else System.out.println("Alice");
        }
    }
}
