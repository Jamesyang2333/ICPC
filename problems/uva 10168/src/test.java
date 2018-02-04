import java.util.*;
public class test {
    private static int count;
    private static int[] primes =  new int[1000000];
    public static void main(String[] args){
        count = 0;
        primes[0] = 2;
        int number = 2;
        int result = 0;
        while(number <= 10000000){
            number++;
            if(isPrime(number)){
                primes[++count] = number;
            }
        }
        System.out.print(count);
    }
    private static boolean isPrime(long n){
        boolean isPrime = true;
        for(int i = 0; (i <= count) && (primes[i] * primes[i] <= n); i++){
            if((n % primes[i]) == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
