/*
ID: jamesya4
LANG: JAVA
TASK: humble
*/
import java.io.*;
import java.util.*;

class humble1 {
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
        long[] humble = new long[n + 1];
        int[] counter = new int[size];
        humble[0] = 1;
        for(int i = 0; i < size; i++)
            counter[i] = 0;
        for(int i = 1; i <= n; i++) {
            HashSet<Integer> repeat = new HashSet<>();
            long min = primes[0] * humble[counter[0]];
            repeat.add(0);
            for (int j = 1; j < size; j++) {
                if (primes[j] * humble[counter[j]] == min)
                    repeat.add(j);
                else if (primes[j] * humble[counter[j]] < min) {
                    repeat.clear();
                    repeat.add(j);
                    min = primes[j] * humble[counter[j]];
                }
            }
            humble[i] = min;
            for (int j : repeat) {
                counter[j]++;
            }
        }
        //for(int i = 0; i <= n; i++)
        //    System.out.println(humble[i]);
        out.println(humble[n]);                           // output result
        out.close();                                  // close the output file
    }
}
