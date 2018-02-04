import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int[] xmove = {-2, -2, 0, 2, 2, 0};
    private static final int[] ymove = {-1, 1, 2, 1, -1, -2};
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        int[][] steps = new int[n][n];
        int[][] moves = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                steps[i][j] = -1;
        ArrayDeque<int[]> states = new ArrayDeque<>();
        states.add(new int[]{i_start, j_start});
        steps[i_start][j_start] = 0;
        while(!states.isEmpty()){
            int[] current = states.remove();
            int x = current[0];
            int y = current[1];
            for(int i = 0; i < 6; i++){
                int newx = x + xmove[i];
                int newy = y + ymove[i];
                if(newx >= 0 && newy >= 0 && newx < n && newy < n){
                    if(steps[newx][newy] == -1){
                        steps[newx][newy] = steps[x][y] + 1;
                        moves[newx][newy] = i;
                        if(newx == i_end && newy == j_end)
                            break;
                        else states.add(new int[]{newx, newy});
                    }
                }
            }
        }
        if(steps[i_end][j_end] == -1)
            System.out.println("Impossible");
        else{
            int[] process = new int[steps[i_end][j_end]];
            int x = i_end;
            int y = j_end;
            for(int i = 0; i < steps[i_end][j_end]; i++){
                process[i] = moves[x][y];
                int prevx = x - xmove[moves[x][y]];
                int prevy = y - ymove[moves[x][y]];
                x = prevx;
                y = prevy;
            }
            Arrays.sort(process);
            System.out.println(steps[i_end][j_end]);
            for(int i = 0; i < steps[i_end][j_end]; i++){
                String a = "";
                switch (process[i]){
                    case (0) : a = "UL";
                    break;
                    case (1) : a = "UR";
                    break;
                    case (2) : a = "R";
                    break;
                    case (3) : a = "LR";
                    break;
                    case (4) : a = "LL";
                    break;
                    case (5) : a = "L";
                    break;
                }
                if(i != steps[i_end][j_end] - 1)
                    System.out.print(a + " ");
                else System.out.println(a);
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}