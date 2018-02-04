//This method exceeds the time limit
/*
ID: jamesya4
LANG: JAVA
TASK: humble
*/
import java.io.*;
import java.util.*;

class humble {
    private static int size;
    private static long[] primes;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("humble.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        primes = new long[size];
        Arrays.sort(primes);
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < size; i++) {
            primes[i] = Long.parseLong(st.nextToken());
        }
        PriorityQueue<number> min = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            min.add(new number(primes[i], i));
        }
        int count = 1;
        while (count < n) {
            number current = min.poll();
            for (int i = current.maxFactor; i < size; i++) {
                if (current.product * primes[i] > 0)
                    min.add(new number(current.product * primes[i], i));
            }
            count++;
        }

        out.println(min.poll().product);                           // output result
        out.close();                                  // close the output file
    }
    /*private static int maxFactor(long n){
        for(int i = size - 1; i >= 0; i--){
            if(n % primes[i] == 0)
                return i;
        }
        return size - 1;
    }*/
}
    class number implements Comparable<number>{
        public long product;
        public int maxFactor;
        public number(long product, int maxFactor){
            this.product = product;
            this.maxFactor = maxFactor;
        }
        public int compareTo(number b){
            if(product > b.product)
                return 1;
            else if(product == b.product)
                return 0;
            else return -1;
        }
    }

