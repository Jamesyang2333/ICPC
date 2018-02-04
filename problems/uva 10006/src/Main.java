import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int[] primes = new int[200];
    public static void main(String[] args) throws IOException{
        primes[0] = 2;
        int count = 1;
        int number = 3;
        while (count < 200){
            boolean prime = true;
            for(int i = 0; i < count; i++){
                if(number % primes[i] == 0){
                    prime = false;
                    break;
                }
            }
            if(prime)
                primes[count++] = number;
            number++;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            //System.out.println(isprime(n));
            //System.out.println(isCar(n));
            if((!isprime(n)) && isCar(n)){
                System.out.format("The number %d is a Carmichael number.\n", n);
            }
            else System.out.format("%d is normal.\n", n);
        }
    }
    private static boolean isCar(int n){
        boolean car = true;
        for(int i = 2; i < n; i++){
            long icopy = i;
            long result = 1;
            int ncopy = n;
            while(ncopy > 0){
                if(ncopy % 2 == 1){
                    result = (result * icopy) % n;
                }
                icopy = (icopy * icopy) % n;
                ncopy /= 2;
            }
            if(result != i){
                //System.out.println(n + " " + i);
                car = false;
                break;
            }
        }
        return car;
    }
    private static boolean isprime(int n){
        boolean result = true;
        for(int i = 0; i < 200; i++){
            if(primes[i] * primes[i] > n)
                break;
            if(n % primes[i] == 0){
                result = false;
                break;
            }
        }
        return result;
    }
}
