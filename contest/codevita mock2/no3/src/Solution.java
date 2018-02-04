import java.util.Scanner;

public class Solution {
    private static int count;
    private static long[] primes =  new long[50000];
    private static long[] sum = new long[50000];
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();

    count = 0;
    primes[0] = 2;
    sum[0] = 2;
    long number = 2;
    int result = 0;
    while(sum[count] <= n){
        number++;
        if(isPrime(number)){
            primes[++count] = number;
            sum[count] = sum[count - 1] + number;
            if(sum[count] <= n)
                if(isPrime(sum[count])) {
                result++;
            }
            }
    }
    System.out.print(result);
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
