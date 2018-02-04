/*
ID: jamesya4
LANG: JAVA
TASK: maze1
*/
import java.io.*;
import java.util.*;

class maze1 {
    private static int width;
    private static int height;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        int[][] dfs1 = new int[height * 2 + 1][width * 2 + 1];
        int[][] dfs2 = new int[height * 2 + 1][width * 2 + 1];
        int count = 0;
        int exit1x = 0;
        int exit1y = 0;
        int exit2x = 0;
        int exit2y = 0;
        for(int i = 0; i <= 2 * height; i++){
            String line = f.readLine();
            for(int j = 0; j <= 2 * width; j++){
                if(line.charAt(j) == '+' || line.charAt(j) == '|' || line.charAt(j) == '-'){
                    dfs1[i][j] = 0;
                    dfs2[i][j] = 0;
                }
                else {
                    dfs1[i][j] = -1;
                    dfs2[i][j] = -1;
                    if(j == 2 * width || j == 0 || i == 0 || i == 2 * height || dfs1[i][j] == 0)
                        if(count == 0){
                        count++;
                        exit1x = i;
                        exit1y = j;
                        }
                        else{
                            exit2x = i;
                            exit2y = j;
                        }
                }
            }
        }
        search(dfs1, exit1x, exit1y);
        search(dfs2, exit2x, exit2y);
        int worst = 0;
        for(int i = 0; i <= 2 * height; i++){
            for(int j = 0; j <= 2 * width; j++){
                if(dfs1[i][j] > 0){
                    worst = Math.max(worst, Math.min(dfs1[i][j], dfs2[i][j]));
                }
            }
        }
        out.println(worst / 2);                           // output result
        out.close();                                  // close the output file
    }
    private static void search(int[][] dfs, int x, int y){
        ArrayDeque<int[]> states = new ArrayDeque<>();
        dfs[x][y] = 1;
        states.add(new int[]{x, y});
        while(!states.isEmpty()){
            int[] current = states.remove();
            if(current[0] > 0)
                if(dfs[current[0] - 1][current[1]] == -1){
                    dfs[current[0] - 1][current[1]] = dfs[current[0]][current[1]] + 1;
                    states.add(new int[]{current[0] - 1, current[1]});
                }
            if(current[0] < 2 * height)
                if(dfs[current[0] + 1][current[1]] == -1){
                    dfs[current[0] + 1][current[1]] = dfs[current[0]][current[1]] + 1;
                    states.add(new int[]{current[0] + 1, current[1]});
                }
            if(current[1] > 0)
                if(dfs[current[0]][current[1] - 1] == -1){
                    dfs[current[0]][current[1] - 1] = dfs[current[0]][current[1]] + 1;
                    states.add(new int[]{current[0], current[1] - 1});
                }
            if(current[1] < 2 * width)
                if(dfs[current[0]][current[1] + 1] == -1){
                    dfs[current[0]][current[1] + 1] = dfs[current[0]][current[1]] + 1;
                    states.add(new int[]{current[0], current[1] + 1});
                }
        }
    }
}
