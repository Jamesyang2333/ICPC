/*
ID: jamesya4
LANG: JAVA
TASK: butter
*/
//This method uses dijkstra algorithm to calculate the shortest path between all pairs of vertices
import java.io.*;
import java.util.*;

class test {
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
        ArrayList<neighbor>[] adj = (ArrayList<neighbor>[]) new ArrayList[npastures];
        for(int i = 0; i < npastures; i++){
            adj[i] = new ArrayList<neighbor>();
        }
        int[][] shortest1 = new int[npastures][npastures];
        for(int i = 0; i < npastures; i++)
            for(int j = 0; j < npastures; j++){
                if(i == j)
                    shortest1[i][j] = 0;
                else shortest1[i][j] = 1000000;
            }
        for(int i = 0; i < edges; i++){
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            adj[a - 1].add(new neighbor(b - 1, dis));
            adj[b - 1].add(new neighbor(a - 1, dis));
            shortest1[a - 1][b - 1] = dis;
            shortest1[b - 1][a - 1] = dis;
        }
        int[][] shortest = new int[npastures][npastures];
        for(int i = 0; i < npastures; i++)
            for(int j = 0; j < npastures; j++)
                shortest[i][j] = Integer.MAX_VALUE;
        int result = 2000000000;
        for(int i = 0; i < npastures; i++){
            boolean can = true;
            int sum = 0;
            shortest[i][i] = 0;
            boolean[] checked = new boolean[npastures];
            for(int j = 0; j < npastures; j++)
                checked[j] = false;
            for(int j = 0; j < npastures; j++){
                int current = 0;
                int min = 1000000;
                for(int k = 0; k < npastures; k++){
                    if(!checked[k])
                        if(min > shortest[i][k]){
                            current = k;
                            min = shortest[i][k];
                        }
                }
                checked[current] = true;
                if(cowInpastures[current] != 0){
                    if(shortest[i][current] == Integer.MAX_VALUE){
                        can = false;
                        break;
                    }
                    else sum += cowInpastures[current] * shortest[i][current];
                }
                for(neighbor x : adj[current]){
                    if(!checked[x.number]){
                        if(x.dis + shortest[i][current] < shortest[i][x.number])
                            shortest[i][x.number] = x.dis + shortest[i][current];
                    }
                }
            }

            //sum = shortest[i][15] + shortest[i][17] + shortest[i][12] + shortest[i][30] + shortest[i][14] + shortest[i][4] + shortest[i][3] + shortest[i][29] + shortest[i][20] + shortest[i][26];
            //System.out.println(sum);
            if(can)
                if(sum < result)
                    result = sum;
        }
        for(int k = 0; k < npastures; k++)
            for(int i = 0; i < npastures; i++)
                for(int j = 0; j < npastures; j++){
                    if(shortest1[i][j] > shortest1[i][k] + shortest1[k][j])
                        shortest1[i][j] = shortest1[i][k] + shortest1[k][j];
                }
        for(int i = 0; i < npastures; i++)
            for(int j = 0; j < npastures; j++)
                if(shortest[i][j] != shortest1[i][j])
                    System.out.println(i + " " + j + " " + shortest[i][j] + " " + shortest1[i][j]);
    }
}

