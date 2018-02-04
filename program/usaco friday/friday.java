/*
ID: jamesya4
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday{
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int[] week = new int[7];
        int[] month1 = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] month2 = {31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 12;
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1900; i < 1900 + n; i++) {
            boolean isLeap = false;
            if (i % 4 == 0) {
                if (i % 100 == 0) {
                    if (i % 400 == 0)
                        isLeap = true;
                } else isLeap = true;
            }
            int[] month;
            if (isLeap)
                month = month2;
            else month = month1;
            for (int j = 0; j < 12; j++) {
                week[day % 7]++;
                day += month[j];
            }

        }

        for(int i = 5; i < 11; i++){
            out.print(week[i % 7]);
            out.print(" ");
        }  
        out.print(week[11 % 7]);
        out.println("");                       // output result
        out.close();                                  // close the output file
    }
}
