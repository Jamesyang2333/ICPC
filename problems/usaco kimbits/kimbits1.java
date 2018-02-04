/*
ID: jamesya4
LANG: JAVA
TASK: kimbits
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class kimbits1 {
    private static BigInteger[] factorial  = new BigInteger[32];
    private static int length;
    private static int nones;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("kimbits.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        length = Integer.parseInt(st.nextToken());
        nones = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        factorial[0] = BigInteger.ONE;
        for(int i = 1; i < 32; i++){
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
        boolean[] sequence = new boolean[length + 1];
        for(int i = 0; i <= length; i++)
            sequence[i] = false;
        int digits = length;
        long rank = n;
        int oneleft = nones;
        while(rank != 1){
        long[] numbers = new long[digits + 1];
        numbers[0] = 1;
        numbers[1] = 2;
        for(int i = 2; i <= digits; i++){
            int count = 0;
            for(int j = 0; j <= Math.min(i - 1, oneleft - 1); j++){
                count += combination(i - 1,  j);
            }
            numbers[i] = count + numbers[i - 1];
        }
        int maxBit = 0;
        for(int i = 0; i <= length; i++){
            if(rank <= numbers[i]){
                maxBit = i;
                break;
            }
        }
        sequence[maxBit] = true;
        //System.out.println(maxBit);
        rank -= numbers[maxBit - 1];
        digits = maxBit - 1;
        oneleft--;
        }
        for(int i = length; i > 0; i--){
            if(sequence[i])
                out.print("1");
            else out.print("0");
        }

        out.println();                           // output result
        out.close();                                  // close the output file
    }
    private static int combination(int n, int k){
        BigInteger ans = factorial[n].divide(factorial[n - k].multiply(factorial[k]));
        int result = ans.intValue();
        return result;
    }

}
