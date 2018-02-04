/*
ID: jamesya4
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

class ariprog {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(f.readLine());
        int bound = Integer.parseInt(st.nextToken());
        byte[] check = new byte[2 * bound * bound + 1];
        for(int i = 0; i <= 2 * bound * bound; i++)
            check[i] = -1;
        for(int step = 1; step <= 2 * bound * bound / (n - 1); step++){
            for(int ini = 0; ini <= 2 * bound * bound - (n - 1) * step; ini++){
                int i;
                int inicopy = ini;
                for(i = 0; i < n; i++){
                    if(check[inicopy] == -1){
                        check[inicopy] = 0;
                        for(int p = 0; p <= bound; p++){
                            int rest = inicopy - p * p;
                            if(rest < 0)
                                break;
                            int q = (int)Math.sqrt(rest);
                            if((q * q == rest || (q + 1) * (q + 1) == rest) && q <=bound ) {
                                check[inicopy] = 1;
                                break;
                            }
                        }
                    }
                    if(check[inicopy] == 0)
                        break;
                    inicopy += step;
                }
                if(i == n){
                    out.print(ini + " ");
                    out.println(step);
                    count++;
                }
            }
        }
        if(count == 0)
            out.println("NONE");
        out.close();                                  // close the output file
    }
}
