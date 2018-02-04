/*
ID: jamesya4
LANG: JAVA
TASK: kimbits
*/
import java.io.*;
import java.util.*;

class kimbits {
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
        //System.out.println((1 << 31) - 1);
        int result;
        if(length == nones){
            result = (int)n - 1;
        }
        else{
        int count = 0;
        int number = 0;
        while (count < n){
            if(check(number))
                count++;
            number++;
        }
        result = number - 1;
        }
        for(int i = length - 1; i >= 0; i--){
            if((result & (1 << i)) > 0)
                out.print(1);
            else out.print(0);
        }
        //System.out.println(check(522));
        out.println();                           // output result
        out.close();                                  // close the output file
    }
    private static boolean check(int n){
        if(length == nones)
            return true;
        int count = 0;
        for(int i = 0; i <= length - 1; i++){
            if((n & (1 << i)) == 0)
                count++;
            if(count >= length - nones)
                return true;
        }
        return false;
    }
}
