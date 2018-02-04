import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    private static boolean[] isprime;
    private static HashSet<Integer> primes = new HashSet<>();
    public static void main(String[] args) throws IOException{
        isprime = new boolean[10000001];
        for(int i = 0; i <= 10000000; i++){
            isprime[i] = true;
        }
        for(int i = 2; i <= 10000000; i++){
            if(isprime[i]){
                primes.add(i);
                for(int j = 2 * i; j <= 10000000; j += i){
                    if(isprime[j]){
                        isprime[j] = false;
                    }
                }
            }
        }
        //System.out.println(primes.size());
        int size = primes.size();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            int N = Integer.parseInt(new StringTokenizer(line).nextToken());
            if(N < 8)
                System.out.println("Impossible.");
            else{
                if(N % 2 == 1){
                    N -= 5;
                    System.out.print("2 3 ");
                }
                else{
                    N -= 4;
                    System.out.print("2 2 ");
                }
                for(int i : primes){
                    if(primes.contains(N - i)){
                        System.out.format("%d %d\n", i, N - i);
                        break;
                    }
                }
            }
        }
    }
}
