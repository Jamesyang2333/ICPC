/*
ID: jamesya4
LANG: JAVA
TASK: fracdec
*/
import java.io.*;
import java.util.*;

class fracdec {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("fracdec.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int numerator = Integer.parseInt(st.nextToken());
        int denominator = Integer.parseInt(st.nextToken());
        int[] decimal = new int[denominator];
        int before = numerator / denominator;
        int rest = numerator % denominator;
        HashMap<Integer, Integer> all = new HashMap<>();
        int firstRep = -1;
        int count = 0;
        while (true){
            if (rest == 0){
                if(count == 0)
                    decimal[count++] = 0;
                break;
            }
            if(all.containsKey(rest)){
                firstRep = all.get(rest);
                break;
            }
            else{
                all.put(rest, count);
                decimal[count++] = rest * 10 / denominator;
                rest = (rest * 10) % denominator;
            }
        }
        if(firstRep == -1){
            out.print(before);
            out.print(".");
            for(int i = 0; i < count; i++)
                out.print(decimal[i]);
            out.println();
        }
        else{
            int counter = 0;
            String beforestring = Integer.toString(before);
            out.print(before);
            out.print(".");
            counter = 1 + beforestring.length();
            for(int i = 0; i < count; i++){
                if(i == firstRep) {
                    if(counter % 76 == 0)
                        out.println();
                    out.print("(");
                    counter++;
                }
                if(counter % 76 == 0)
                    out.println();
                out.print(decimal[i]);
                counter++;
            }
            if(counter % 76 == 0)
                out.println();
            out.println(")");
        }
        out.close();                                  // close the output file
    }
}
