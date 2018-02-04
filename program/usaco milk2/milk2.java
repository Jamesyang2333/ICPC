/*
ID: jamesya4
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2{
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
        int endtime = 0;
        int starttime = 1000000;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            endtime = Math.max(endtime, end[i]);
            starttime = Math.min(starttime, start[i]);
        }

        boolean[] state = new boolean[endtime];
        for(int i = 0; i < n; i++){
            for(int j = start[i]; j < end[i]; j++){
                if(!state[j])
                    state[j] = true;
            }
        }
        int count1 = 0;
        int count2 = 0;
        int max1 = 0;
        int max2 = 0;
        for(int i = starttime; i < endtime; i++){
            if(state[i])
                count1++;
            else {
                max1 = Math.max(max1, count1);
                count1 = 0;
            }
            if(i == endtime-1){
                max1 = Math.max(max1, count1);
            }
        }
        for(int i = starttime; i < endtime; i++){
            if(!state[i])
                count2++;
            else {
                max2 = Math.max(max2, count2);
                count2 = 0;
            }
            if(i == endtime-1){
                max2 = Math.max(max2, count2);
            }
        }
        out.print(max1 + " ");// output result
        out.print(max2);
        out.println("");
        out.close();                                  // close the output file
    }
}
