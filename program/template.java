/*
ID: jamesya4
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class  {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader(".in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(".out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        

        
        out.println(i1+i2);                           // output result
        out.close();                                  // close the output file
    }
}
