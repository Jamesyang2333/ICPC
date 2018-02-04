/*
ID: jamesya4
LANG: JAVA
TASK: butter
*/
//This method uses floyd-Warshall algorithm to calculate the shortest path between all pairs of vertices
import java.io.*;
import java.util.*;

class butter1 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("butter.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int ncows = Integer.parseInt(st.nextToken());
        int npastures = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int[] cowInpastures = new int[npastures];
        for(int i = 0; i < npastures; i++)
            cowInpastures[i] = 0;
        for(int i = 0; i < ncows; i++){
            int pasture = Integer.parseInt(f.readLine());
            cowInpastures[pasture - 1]++;
        }
        int[][] shortest = new int[npastures][npastures];
        for(int i = 0; i < npastures; i++)
            for(int j = 0; j < npastures; j++){
                if(i == j)
                    shortest[i][j] = 0;
                else shortest[i][j] = 1000000;
        }
        for(int i = 0; i < edges; i++){
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            shortest[a - 1][b - 1] = dis;
            shortest[b - 1][a - 1] = dis;
        }
        for(int k = 0; k < npastures; k++)
            for(int i = 0; i < npastures; i++)
                for(int j = 0; j < npastures; j++){
                    if(shortest[i][j] > shortest[i][k] + shortest[k][j])
                        shortest[i][j] = shortest[i][k] + shortest[k][j];
                }
        int result = 2000000000;
        for(int i = 0; i < npastures; i++){
            boolean can = true;
            int sum = 0;
            for(int j = 0; j < npastures; j++){
                if(cowInpastures[j] != 0){
                    if(shortest[i][j] >= 1000000){
                        can = false;
                        break;
                    }
                    else sum += cowInpastures[j] * shortest[i][j];
                }
            }
            if(can)
                if(sum < result)
                    result = sum;
        }
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
}

