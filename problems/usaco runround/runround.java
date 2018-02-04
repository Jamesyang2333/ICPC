/*
ID: jamesya4
LANG: JAVA
TASK: runround
*/
import java.io.*;
import java.util.*;

class runround {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        while(true){
            if(check(++n)){
                out.println(n);
                break;
            }
        }
        out.close();                                  // close the output file
    }
    private static boolean check(int n){
        int ncopy = n;
        int numDigit = 0;
        while(ncopy > 0){
            ncopy /= 10;
            numDigit++;
        }
        HashSet<Integer> repeat = new HashSet<>();
        int[] digits = new int[numDigit];
        for(int i = numDigit - 1; i >= 0; i--){
            if(n % 10 == 0)
                return false;
            if(repeat.contains(n % 10))
                return false;
            repeat.add(n % 10);
            digits[i] = n % 10;
            n /= 10;
        }
        int p = 0;
        int count = 1;
        boolean[] checked = new boolean[numDigit];
        while (count <= numDigit){
            if(checked[p])
                return false;
            checked[p] = true;
            p = (p + digits[p]) % numDigit;
            count++;
        }
        if(p == 0) return true;
        else return false;
    }
}
