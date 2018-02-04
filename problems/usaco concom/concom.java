/*
ID: jamesya4
LANG: JAVA
TASK: concom
*/
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;

class concom {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("concom.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[][] control = new int[101][101];
        int[][] combinedControl = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        for(int i = 0; i < 101; i++)
            for(int j = 0; j < 101; j++) {
            control[i][j] = 0;
            combinedControl[i][j] = 0;
            }
        for(int i = 0; i < 101; i++)
            for(int j = 0; j < 101; j++)
                visited[i][j] = false;
        int min = 100;
        int max = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a > max)
                max = a;
            if(a < min)
                min = a;
            int b = Integer.parseInt(st.nextToken());
            if(b > max)
                max = b;
            if(b < min)
                min = b;
            int percent = Integer.parseInt(st.nextToken());
            control[a][b] = percent;
            combinedControl[a][b] = percent;
        }
        for(int i = min; i <= max; i++){
            int searched = 1;
            while(searched != 0){
                searched = 0;
                for(int j = min; j <= max; j++){
                    if(i != j)
                        if((combinedControl[i][j] > 50) && !visited[i][j]){
                            searched++;
                            visited[i][j] = true;
                            for(int k = min; k <= max; k++){
                                combinedControl[i][k] += control[j][k];
                        }
                    }
                }
            }

        }
        for(int i = min; i <= max; i++)
            for(int j = min; j <= max; j++){
            if(i != j)
                if(combinedControl[i][j] > 50)
                    out.println(i + " " + j);
            }
        out.close();                                  // close the output file
    }
}
