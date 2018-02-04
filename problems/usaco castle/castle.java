/*
ID: jamesya4
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

class castle {
    private static int count = 0;
    private static int[][] room;
    private static int[][] component;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        room = new int[m][n];
        for(int i = 0; i < m;  i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++)
                room[i][j] = Integer.parseInt(st.nextToken());
        }
        component = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
            component[i][j] = -1;
            }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(component[i][j] == -1){
                    count++;
                    search(i, j);
                }
            }
        int[] area = new int[count + 1];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                area[component[i][j]]++;
        int max = area[1];
        for(int i = 2; i <= count; i++)
            max = Math.max(max, area[i]);
        int maxMerge = 1;
        int[] wall = null;
        for(int j = 0; j < n; j++)
            for(int i = m - 1; i >= 0; i--) {
                if(i > 0)
                    if (component[i][j] != component[i - 1][j]) {
                        if (area[component[i][j]] + area[component[i - 1][j]] > maxMerge) {
                            wall = new int[]{i + 1, j + 1, 0};
                            maxMerge = area[component[i][j]] + area[component[i - 1][j]];
                        }
                    }
                if(j <  n - 1)
                    if (component[i][j] != component[i][j + 1]) {
                    if (area[component[i][j]] + area[component[i][j + 1]] > maxMerge) {
                        wall = new int[]{i + 1, j + 1, 1};
                        maxMerge = area[component[i][j]] + area[component[i][j + 1]];
                    }
                }
            }

        
        out.println(count);
        out.println(max);
        out.println(maxMerge);
        out.print(wall[0] + " " +wall[1] + " ");
        if(wall[2] == 0)
            out.println('N');
        else out.println('E');// output result
        out.close();                                  // close the output file
    }
    private static void search(int i, int j){
        ArrayDeque<int[]> allCase = new ArrayDeque<>();
        allCase.add(new int[]{i, j});
        do{
            int[] current = allCase.remove();
            component[current[0]][current[1]] = count;
            if((room[current[0]][current[1]] & 1) == 0)
                if(component[current[0]][current[1] - 1] == -1) {
                allCase.add(new int[]{current[0], current[1] - 1});
                component[current[0]][current[1] - 1] = -2;
                }
            if((room[current[0]][current[1]] & 2) == 0)
                if(component[current[0] - 1][current[1]] == -1) {
                allCase.add(new int[]{current[0] - 1, current[1]});
                component[current[0] - 1][current[1]] = -2;
                }
            if((room[current[0]][current[1]] & 4) == 0)
                if(component[current[0]][current[1] + 1] == -1) {
                allCase.add(new int[]{current[0], current[1] + 1});
                component[current[0]][current[1] + 1] = -2;
                }
            if((room[current[0]][current[1]] & 8) == 0)
                if(component[current[0] + 1][current[1]] == -1) {
                allCase.add(new int[]{current[0] + 1, current[1]});
                component[current[0] + 1][current[1]] = -2;
                }
        }while(allCase.size() != 0);
    }
}
