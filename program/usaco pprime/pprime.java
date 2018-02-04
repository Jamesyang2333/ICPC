/*
ID: jamesya4
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;
class pprime {
    private static int[] prime = new int[10000];
    private static int count = 0;
    private static PrintWriter out;
    private static int start;
    private static int end;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        // input file name goes above
        out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        start = Integer.parseInt(st.nextToken());
        int startCopy = start;
        int startLen = 0;
        while(startCopy > 0){
            startCopy /= 10;
            startLen++;
        }
        end = Integer.parseInt(st.nextToken());
        int endCopy = end;
        int endLen = 0;
        while(endCopy > 0){
            endCopy /= 10;
            endLen++;
        }
        int primeLen = (int)Math.sqrt(end);
        for(int i = 2; i <= primeLen; i++)
            construct(i);
        int number;
        if(1 >= startLen && 1 <= endLen){
            for(int i = 2; i <= 9; i++)
                if(i >= start && i <= end)
                    if(isPrime(i))
                        out.println(i);
        }
        if(11 >= start && 11 <= end)
            out.println(11);
        if(3 >= startLen && 3 <= endLen){
            for(int i = 1; i <= 9; i += 2)
                for(int j = 0; j <= 9; j++){
                    number = 101 * i + 10 * j;
                    if(number >= start && number <= end)
                        if(isPrime(number))
                            out.println(number);
                }
        }
        if(5 >= startLen && 5 <= endLen){
            for(int i = 1; i <= 9; i += 2)
                for(int j = 0; j <= 9; j++)
                    for(int k = 0; k <= 9; k++){
                        number = 10001 * i + 1010 * j + 100 * k;
                        if(number >= start && number <= end)
                            if(isPrime(number))
                                out.println(number);
                    }
        }
        if(7 >= startLen && 7 <= endLen){
            for(int i = 1; i <= 9; i += 2)
                for(int j = 0; j <= 9; j++)
                    for(int k = 0; k <= 9; k++)
                        for(int l = 0; l <= 9; l++){
                        number = 1000001 * i + 100010 * j + 10100 * k + 1000 * l;
                        if(number >= start && number <= end)
                            if(isPrime(number))
                                out.println(number);
                    }
        }


        out.close();                                  // close the output file
    }
    private static boolean isPrime(int a){
        if(a == 1)
            return false;
        if(a == 2){
            return true;
        }
        int root = (int)Math.sqrt(a);
        for(int i = 0; i <= root; i++){
            if(prime[i] > root) break;
            if(prime[i] == 0) break;
            if(a % prime[i] == 0)
                return false;
            }
        return true;
    }
    private static void construct(int a){
        if(a == 2){
            prime[0] = 2;
            count++;
            return;
        }
        int root = (int)Math.sqrt(a);
        for(int i = 0; i <= root; i++){
            if(prime[i] > root) break;
            if(a % prime[i] == 0)
                return;
        }
        prime[count++] = a;
    }

}
