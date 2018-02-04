/*
ID: jamesya4
LANG: JAVA
TASK: fact4
*/
import java.io.*;
import java.util.*;

class fact4 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        long digit = 1;
        for(int i = 2; i <= n; i++){
            digit = extractDigit(digit * i);
        }
        

        
        out.println(digit % 10);                           // output result
        out.close();                                  // close the output file
    }
    private static long extractDigit(Long n){
        while(n % 10 == 0)
            n /= 10;
        return n % 100000;
    }
}
