/*
ID: jamesya4
LANG: JAVA
TASK: range
*/
import java.io.*;
import java.util.*;

class range {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("range.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][n];
        for(int i = 0; i < n; i++){
            String line = f.readLine();
            for(int j = 0; j < n; j++){
                field[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        for(int i = 2; i <= n; i++){
            int count = 0;
            for(int j = 0; j <= n - i; j++){
                for(int k = 0; k <= n - i; k++){
                    boolean can = true;
                    if(field[j][k] != 1)
                        can = false;
                    if(field[j + 1][k] != 1)
                        can = false;
                    if(field[j][k + 1] != 1)
                        can = false;
                    if(field[j + 1][k + 1] != 1)
                        can = false;
                    if(can){
                        field[j][k] = 1;
                        count++;
                    }
                    else field[j][k] = 0;
                }
            }
            if(count == 0)
                break;
            else{
                out.print(i);
                out.println(" " + count);
            }
        }
        out.close();                                  // close the output file
    }
}
