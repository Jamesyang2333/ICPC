/*
ID: jamesya4
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        String bead = st.nextToken();
        String newbead = bead + bead;
        int[] rf = new int[2 * n];
        int[] rb = new int[2 * n];
        int[] bf = new int[2 * n];
        int[] bb = new int[2 * n];
        rf[0] = 0;
        bf[0] = 0;
        for(int i = 1; i < 2 * n; i++){
            if(newbead.charAt(i-1) == 'r'){
                rf[i] = rf[i-1] + 1;
                bf[i] = 0;
            }
            if(newbead.charAt(i-1) == 'b'){
                bf[i] = bf[i-1] + 1;
                rf[i] = 0;
            }
            if(newbead.charAt(i-1) == 'w'){
                rf[i] = rf[i-1] + 1;
                bf[i] = bf[i-1] + 1;
            }
        }
        if(newbead.charAt(2 * n - 1) == 'r'){
        rb[2 * n - 1] = 1;
        bb[2 * n - 1] = 0;
        }
        if(newbead.charAt(2 * n - 1) == 'b'){
            bb[2 * n - 1] = 1;
            rb[2 * n - 1] = 0;
        }
        if(newbead.charAt(2 * n - 1) == 'w'){
            rb[2 * n - 1] = 1;
            bb[2 * n - 1] = 1;
        }
        for(int i = 2 * n - 2; i >= 0; i--){
            if(newbead.charAt(i) == 'r'){
                rb[i] = rb[i + 1] + 1;
                bb[i] = 0;
            }
            if(newbead.charAt(i) == 'b'){
                bb[i] = bb[i + 1] + 1;
                rb[i] = 0;
            }
            if(newbead.charAt(i) == 'w'){
                rb[i] = rb[i + 1] + 1;
                bb[i] = bb[i + 1] + 1;
            }
        }
        int[] collect = new int[n];
        for(int i = 0; i < n; i++){
            collect[i] = Math.max(rb[i],bb[i]) + Math.max(rf[i + n], bf[i + n]);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, collect[i]);
        }
        if(max > n)
            max = n;
        out.println(max);                           // output result
        out.close();                                  // close the output file
    }
}
