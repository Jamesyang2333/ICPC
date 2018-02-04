import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> primes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] isprime = new boolean[n + 100];
        for(int i = 0; i < n + 100; i++)
            isprime[i] = true;
        for(int i = 2; i < n + 100; i++){
            if(isprime[i]){
                primes.add(i);
                for(int j = 1; j <= (n + 99) / i; j++){
                    isprime[j * i] = false;
                }
            }
        }
        int index = Collections.binarySearch(primes, n - 1);
        int smallestPrime = 0;
        if(index < 0){
            smallestPrime = primes.get((-index) - 1);
        }
        else smallestPrime = primes.get(index);
        System.out.println(smallestPrime + " " + smallestPrime);
        for(int i = 1; i < n - 1; i++)
            System.out.println(i + " " + (i + 1) + " " + 1);
        System.out.println((n - 1) + " " + n + " " + (smallestPrime - n + 2));
        int count = n - 1;
        boolean stop = false;
        for(int i = 1; i < n; i++){
            for(int j = i + 2; j <= n; j++){
                if(count == m){
                    stop = true;
                    break;
                }
                else{
                    int weight = 0;
                    if(j != n)
                        weight = j - i;
                    else weight = smallestPrime - (n - 2) + j - i - 1;
                    System.out.println(i + " " + j + " " + weight);
                    count++;
                    if(count == m){
                        stop = true;
                        break;
                    }
                }
            }
            if(stop){
                break;
            }
        }
    }
}
