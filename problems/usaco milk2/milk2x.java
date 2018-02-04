/*
ID: jamesya4
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2x{
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int[] maxto = new int[n];
        int[] maxfrom = new int[n];
        int[] to = new int[n];
        int[] from = new int[n];
        maxto[0] = end[0] - start[0];
        maxfrom[0] = end[0] - start[0];
        to[0] = end[0];
        from[0] = start[0];
        for(int i = 1; i < n; i++){
            maxto[i] = end[i] - start[i];
            maxfrom[i] = end[i] - start[i];
            to[i] = end[i];
            from[i] = start[i];
            for(int j = 0; j < i; j++){
                if (from[i] < end[j] && from[i] > from[j]){
                    maxto[i] = end[i] - from[j];
                    from[i] = from[j];
                }
                if (to[i] < to[j] && to[i] > start[j]){
                    maxfrom[i] = to[j] - start[i];
                    to[i] = to[j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            max = Math.max(max, maxto[i]);
            max = Math.max(max, maxfrom[i]);
        }
        
        out.println(max);                           // output result
        out.close();                                  // close the output file
    }
}
