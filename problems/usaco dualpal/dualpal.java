/*
ID: jamesya4
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int count = 0;
        while(count < n){
            s++;
            int num = 0;
            for(int i = 2; i <= 10; i++){
                int s1 = s;
                int len = (int)(Math.log(s)/Math.log(i)) + 1;
                if(len - Math.log(s)/Math.log(i) < 1e-7)
                    len++;
                int[] sequence = new int[len];
                for(int j = 0; j < len; j++){
                    sequence[j] = s1 % i;
                    s1 /= i;
                }
                boolean pal = true;
                for(int j = 0; j < len/2; j++){
                    if(sequence[j] != sequence[len-1-j]){
                        pal = false;
                        break;
                    }
                }

                if(pal)
                    num ++;
                if(num == 2)
                    break;
            }
            if(num == 2) {
                out.println(s);
                count++;
            }

        }// output result
        out.close();                                  // close the output file
    }
}
