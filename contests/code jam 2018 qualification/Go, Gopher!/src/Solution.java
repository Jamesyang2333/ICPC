import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st;
        for(int cc = 0; cc < ncases; cc++){
            int a = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(a == 20){
                int width = 4;
                int height = 5;
                boolean[][] grids = new boolean[height][width];
                for(int i = 0; i < height; i++)
                    for(int j = 0; j < width; j++)
                        grids[i][j] = false;
                boolean stop = false;
                for(int i = 2; i < 5; i++){
                    for(int j = 2; j < 4; j++){
                        if(j == 2 && i != 4){
                            while(!grids[i - 2][j - 2]){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                grids[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
                            }
                        }
                        else if(j == 2 && i == 4){
                             while(!check(grids, 3, 1)){
                                 System.out.format("%d %d\n", i, j);
                                 st = new StringTokenizer(br.readLine());
                                 grids[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
                             }
                        }
                        else if(j == 3 && i != 4){
                            while(!checkline(grids, i - 2, 2)){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                grids[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
                            }
                        }
                        else{
                            boolean end = false;
                            while(!end){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                if(Integer.parseInt(st.nextToken()) == 0 && Integer.parseInt(st.nextToken()) == 0)
                                    break;
                            }
                        }
                    }
                }
            }
            else{
                int width = 10;
                int height = 20;
                boolean[][] grids = new boolean[height][width];
                for(int i = 0; i < height; i++)
                    for(int j = 0; j < width; j++)
                        grids[i][j] = false;
                boolean stop = false;
                for(int i = 2; i < 20; i++){
                    for(int j = 2; j < 10; j++){
                        if(j != 9 && i != 19){
                            while(!grids[i - 2][j - 2]){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                grids[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
                            }
                        }
                        else if(j != 9 && i == 19){
                            while(!check(grids, i - 1, j - 1)){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                grids[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
                            }
                        }
                        else if(j == 9 && i != 19){
                            while(!checkline(grids, i - 2, j - 1)){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                grids[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
                            }
                        }
                        else{
                            boolean end = false;
                            while(!end){
                                System.out.format("%d %d\n", i, j);
                                st = new StringTokenizer(br.readLine());
                                if(Integer.parseInt(st.nextToken()) == 0 && Integer.parseInt(st.nextToken()) == 0)
                                    break;
                            }
                        }
                    }
                }
            }

        }
    }
    private static boolean check(boolean[][] a, int centerx, int centery){
        for(int i = centerx - 1; i <= centerx + 1; i++){
            for(int j = centery - 1; j <= centery + 1; j++){
                if(!a[i][j])
                    return false;
            }
        }
        return true;
    }
    private static boolean checkline(boolean[][] a, int centerx, int centery){
        for(int i = centery - 1; i <= centery + 1; i++){
            if(!a[centerx][i])
                return false;
        }
        return true;
    }
}
