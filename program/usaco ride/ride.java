/*
ID: jamesya4
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        String comet = st.nextToken();    // first integer
        st = new StringTokenizer(f.readLine());
        String group = st.nextToken();
        int comet_length = comet.length();
        int comet_num = 1;
        int group_num = 1;
        int group_length = group.length();
        for(int i = 0; i < comet_length; i++)
            comet_num *= (comet.charAt(i) - 'A' + 1);
        for(int i = 0; i < group_length; i++)
            group_num *= (group.charAt(i) - 'A' + 1);
        String result;
        if (group_num % 47 == comet_num % 47)
            result = "GO";
        else result = "STAY";
        out.println(result);
        out.close();


    }
}
