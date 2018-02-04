/*
ID: jamesya4
LANG: JAVA
TASK: sprime
*/
import java.io.*;
import java.util.*;

class sprime {
    private static int[] prime = new int[2000];
    private static int count = 0;
    private static PrintWriter out;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        // input file name goes above
        out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int primeLen = (int)(Math.pow(10, (n + 1) / 2));
        for(int i = 2; i < primeLen; i++)
            construct(i);
        find(0,n);
        out.close();                                  // close the output file
    }
    private static void find(int current, int n){
        if(n == 1){
            for(int i = 1; i <= 9; i += 2){
                if(isPrime(10 * current + i))
                    out.println(10 * current + i);

            }
            return;
        }
        for(int i = 1; i <= 9; i++){
            if(isPrime(10 * current + i)){
                find(10 * current + i, n - 1);
            }
        }
    }
    private static boolean isPrime(int a){
        if(a == 1) return false;
        int root = (int)(Math.sqrt(a));
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
            prime[count++] = 2;
            return;
        }
        int root = (int)(Math.sqrt(a));
        for(int i = 0; i <= root; i++){
            if(prime[i] > root) break;
            if(prime[i] == 0) break;
            if(a % prime[i] == 0)
                return;
        }
        prime[count++] = a;
    }

}
