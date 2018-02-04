/*
ID: jamesya4
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

class combo {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        if(n <= 5)
            out.println(n * n * n);
        else {
            int[] key = new int[3];
            int[] master = new int[3];
            st = new StringTokenizer(f.readLine());
            for (int i = 0; i < 3; i++) {
                key[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            for (int i = 0; i < 3; i++) {
                master[i] = Integer.parseInt(st.nextToken());
            }
            int rep = 1;
            for(int i = 0; i < 3; i++)
                rep *= overlap(n, key[i], master[i]);
            out.println(250 - rep);

        }

        out.close();                                  // close the output file
    }
    private static int overlap(int n, int key, int master){
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = -2; i <=2; i++){
            a.add((key + n + i) % n);
        }
        int count = 0;
        for(int i = -2; i <=2; i++){
            if(a.contains((master + i + n) % n))
            count++;
        }
        return count;
    }
}
