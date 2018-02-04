/*
ID: jamesya4
LANG: JAVA
TASK: cowtour
*/
import java.io.*;
import java.util.*;

class cowtour {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[][] positions = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            positions[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        boolean[][] connect = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String line = f.readLine();
            for(int j = 0; j < n; j++){
                if(line.charAt(j) == '0')
                    connect[i][j] = false;
                else {connect[i][j] = true; }
            }
        }
        double[][] paths = new double[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                paths[i][j] = 1e8;
        for(int i = 0; i < n; i++){
            boolean[] checked = new boolean[n];
            for(int j = 0; j < n; j++)
                checked[j] = false;
            paths[i][i] = 0;
            for(int j = 0; j < n - 1; j++){
                int current = 0;
                double min = (int)1e8;
                for(int k = 0; k < n; k++){
                    if(!checked[k])
                        if(paths[i][k] <  min){
                        min = paths[i][k];
                        current = k;
                        }
                }
                checked[current] = true;
                for(int l = 0; l < n; l++){
                    if(!checked[l])
                        if(connect[current][l])
                            if(paths[i][current] + Math.sqrt(Math.pow(positions[current][0] - positions[l][0], 2) + Math.pow(positions[current][1] - positions[l][1], 2)) < paths[i][l])
                                paths[i][l] = paths[i][current] + Math.sqrt(Math.pow(positions[current][0] - positions[l][0], 2) + Math.pow(positions[current][1] - positions[l][1], 2));
                }
            }
        }
        int[] segment = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++)
            segment[i] = 0;
        for(int i = 0; i < n; i++){
            if(segment[i] == 0){
                segment[i] = (++count);
                for(int j = 0; j < n; j++)
                    if(Math.abs(paths[i][j] - 1e8) > 1e-7)
                        segment[j] = count;
            }
            else continue;
        }
        //System.out.println(count);
        double min = 1e8;
        double[] max = new double[n];
        for(int i = 0; i < n; i++){
            double max1 = 0;
            for(int j = 0; j < n; j++){
            if(paths[i][j] < 9e7)
                max1 = Math.max(max1, paths[i][j]);
            }
            max[i]  = max1;
        }
        double[] fieldmax = new double[151];
        for(int i = 0; i < n; i++)
            fieldmax[i] = 0;
        for(int i = 0; i < n; i++){
            fieldmax[segment[i]] = Math.max(fieldmax[segment[i]], max[i]);
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                if(segment[i] != segment[j]){
                    double diameter = Math.max(fieldmax[segment[i]], fieldmax[segment[j]]);
                    diameter = Math.max(diameter, max[i] + max[j] + Math.sqrt(Math.pow(positions[i][0] - positions[j][0], 2) + Math.pow(positions[i][1] - positions[j][1], 2)));
                    if (diameter < min){
                        min = diameter;
                    }

                }
            }
        }
        out.format("%.6f\n", min);                           // output result
        out.close();                                  // close the output file
    }
}
