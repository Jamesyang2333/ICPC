/*
ID: jamesya4
LANG: JAVA
TASK: sort3
*/
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;

class sort3 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] ini = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            ini[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = ini.clone();
        Arrays.sort(sorted);
        int mark1 = n;
        boolean marked1 = false;
        int mark2 = n;
        boolean marked2 = false;
        for(int i = 0; i < n; i++){
            if(!marked1)
                if(sorted[i] == 2){
                    marked1 = true;
                    mark1 = i;
            }
            if(!marked2)
                if(sorted[i] == 3){
                    marked2 = true;
                    mark2 = i;
                }
        }
        //System.out.println(mark1);
        //System.out.println(mark2);
        int[][] sec = new int[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                sec[i][j] = 0;
        for(int i = 0; i < mark1; i++)
            if(ini[i] == 1)
                sec[0][0]++;
            else if(ini[i] == 2)
                sec[0][1]++;
            else sec[0][2]++;
        for(int i = mark1; i < mark2; i++)
            if(ini[i] == 1)
                sec[1][0]++;
            else if(ini[i] == 2)
                sec[1][1]++;
            else sec[1][2]++;
        for(int i = mark2; i < n; i++)
            if(ini[i] == 1)
                sec[2][0]++;
            else if(ini[i] == 2)
                sec[2][1]++;
            else sec[2][2]++;
        int count = 0;
        int ex = Math.min(sec[0][1], sec[1][0]);
        sec[0][1] -= ex;
        sec[0][0] += ex;
        sec[1][0] -= ex;
        sec[1][1] += ex;
        count += ex;
        ex = Math.min(sec[1][2], sec[2][1]);
        sec[1][2] -= ex;
        sec[1][1] += ex;
        sec[2][1] -= ex;
        sec[2][2] += ex;
        count += ex;
        ex = Math.min(sec[0][2], sec[2][0]);
        sec[0][2] -= ex;
        sec[0][0] += ex;
        sec[2][0] -= ex;
        sec[2][2] += ex;
        count += ex;
        count += (sec[0][1] + sec[0][2]) * 2;
        out.println(count);
        out.close();                                  // close the output file
    }
}
