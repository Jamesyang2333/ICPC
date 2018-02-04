/*
ID: jamesya4
LANG: JAVA
TASK: ttwo
*/
import java.io.*;
import java.util.*;

class ttwo {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st;
        // Get line, break into tokens
        char[][] forest = new char[10][10];
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(f.readLine());
            forest[i] = st.nextToken().toCharArray();
        }
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int cx = 0, cy = 0, fx = 0, fy = 0;
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++){
            if(forest[i][j] == 'C'){
                cx = i;
                cy = j;
                forest[i][j] = '.';
            }
            if(forest[i][j] == 'F'){
                fx = i;
                fy = j;
                forest[i][j] = '.';
            }
        }
        int[] fdir = direction[0];
        int fdire = 0;
        int[] cdir = direction[0];
        int cdire = 0;
        int count = 0;
        while(count < 160000){
            count++;
            //System.out.println(++count);
            if(fx + fdir[0] >= 0 && fx + fdir[0] < 10 && fy + fdir[1] >= 0 && fy + fdir[1] < 10 && forest[fx + fdir[0]][fy + fdir[1]] != '*'){
                fx += fdir[0];
                fy += fdir[1];
            }
            else{
                fdire = (fdire + 1) % 4;
                fdir = direction[fdire];
            }
            if(cx + cdir[0] >= 0 && cx + cdir[0] < 10 && cy + cdir[1] >= 0 && cy + cdir[1] < 10 && forest[cx + cdir[0]][cy + cdir[1]] != '*'){
                cx += cdir[0];
                cy += cdir[1];
            }
            else{
                cdire = (cdire + 1) % 4;
                cdir = direction[cdire];
            }
            if(fx == cx && fy == cy){
                break;
            }
            //System.out.println(fx + " " + fy);
            //System.out.println(cx + " " + cy);
        }
        if(count == 160000)
            count = 0;
        
        out.println(count);                           // output result
        out.close();                                  // close the output file
    }
}
