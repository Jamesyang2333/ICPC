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
        int max = 0;
        char color;
        String bead = st.nextToken();
        for (int i = 0; i < n; i++){
            char prevcolor = bead.charAt((n+i-1)%n);
            char nextcolor = bead.charAt(i);
            boolean prev1  = true;
            boolean next1 = true;
            int prev = i - 2;
            int next = i + 1;
            while(prev1 && ((prev+n) % n != i)){
                color = bead.charAt((prev+n) % n);
                if (prevcolor == 'w'){
                    if(color != 'w'){
                        prevcolor = color;
                    }
                }
                else{
                    if(color != 'w'){
                        if(prevcolor != color)
                            prev1 = false;
                    }
                }
                prev --;
            }
            int prev_length = (i-1 - (prev + 1)+n) % n;
            while(next1 && ((next+n) % n != i)){
                color = bead.charAt((next+n) % n);
                if (nextcolor == 'w'){
                    if(color != 'w'){
                        nextcolor = color;
                    }
                }
                else{
                    if(color != 'w'){
                        if(nextcolor != color)
                            next1 = false;
                    }
                }
                next++;
            }
            int next_length = ((next - 1) - i+n) % n;
            max = Math.max(max, next_length + prev_length);

        }
        if(max > n)
            max = n;
        out.println(max);                           // output result
        out.close();                                  // close the output file
    }
}
