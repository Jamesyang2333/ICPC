/*
ID: jamesya4
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int base = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= 300; i++){
            int square = i * i;
            int num = i;
            int a = (int)(Math.log(square)/Math.log(base));
            if (a + 1 - Math.log(square)/Math.log(base) < 1e-7)
                a++;
            int squarelen = a + 1;
            a = (int)(Math.log(num)/Math.log(base));
            if (a + 1 - Math.log(num)/Math.log(base) < 1e-7)
                a++;
            int len = a + 1;
            int[] sequence2 = new int[squarelen];
            int[] sequence1 = new int[len];
            for(int j = 0; j < squarelen; j++){
                sequence2[j] = square % base;
                square = square / base;
            }
            for(int j = 0; j < len; j++){
                sequence1[j] = num % base;
                num = num / base;
            }
            boolean ispal = true;
            for(int j = 0; j < squarelen/2; j++){
                if(sequence2[j] != sequence2[squarelen-1-j]) {
                    ispal = false;
                    break;
                }
            }
            if(ispal){
                //System.out.println(i);
                for(int j = 0; j < len; j++){
                    if(sequence1[len-1-j] > 9)
                        out.print(String.valueOf((char)('A' + sequence1[len-1-j] - 10)));
                    else out.print(sequence1[len-1-j]);
                }
                out.print(" ");
                for(int j = 0; j < squarelen; j++){
                    if(sequence2[squarelen-1-j] > 9)
                        out.print(String.valueOf((char)('A' + sequence2[squarelen-1-j]-10)));
                    else out.print(sequence2[squarelen-1-j]);
                }
                out.println("");
            }
        }

        out.close();                                  // close the output file
    }
}
