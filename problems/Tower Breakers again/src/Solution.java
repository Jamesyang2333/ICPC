import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int count = 1;
    private static int[] primes = new int[200];
    public static void main(String[] args) throws IOException{
        //BufferedReader br2 = new BufferedReader(new FileReader("input1.in"));
        primes[0] = 2;
        for(int i = 3; i < 1000; i++){
            if(isPrime(i) == -1){
                primes[count++] = i;
            }
        }
        int[] factors = new int[100001];
        factors[1] = 0;
        factors[2] = 0;
        for(int i = 3; i <= 100000; i++){
            int factor = isPrime(i);
            if(factor == -1){
                factors[i] = 1;
            }
            else{
                if(factor != 2)
                    factors[i] = factors[i / factor] + 1;
                else
                    factors[i] = factors[i / 2];
            }
        }
        //System.out.println(factors[100000]);
        /*for(int i = 1; i < 100; i++)
            System.out.println(factors[i]);*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            int piles = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int nimsum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < piles; j++){
                int current = Integer.parseInt(st.nextToken());
                int nim = factors[current];
                if(current % 2 == 0)
                    nim++;
                nimsum = nimsum ^ nim;
            }
            if(nimsum == 0){
                System.out.println(2);
            }
            else System.out.println(1);
        }
        /*for(int i = 0; i < count; i++)
            System.out.println(primes[i]);
        System.out.println(count);*/
    }
    private static int isPrime(int n){
        int factor = -1;
        for(int i = 0; i < count; i++){
            if(primes[i] * primes[i] > n)
                break;
            else{
                if(n % primes[i] == 0){
                    factor = primes[i];
                    break;
                }
            }
        }
        return factor;
    }
}
