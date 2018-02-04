import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static byte[][] states;
    private static int[] xmov = {-2, -2, 1, -1};
    private static int[] ymov = {1, -1, -2, -2};
    private static byte[][][][][][] positions;
    public static void main(String[] args) throws IOException{
        states = new byte[15][15];
        for(int i = 0; i < 15; i++)
            for(int j = 0; j < 15; j++)
                states[i][j] = -1;
        positions = new byte[15][15][15][15][15][15];
        for(int i1 = 0; i1 < 15; i1++)
            for(int i2 = 0; i2 < 15; i2++)
                for(int i3 = 0; i3 < 15; i3++)
                    for(int i4 = 0; i4 < 15; i4++)
                        for(int i5 = 0; i5 < 15; i5++)
                            for (int i6 = 0; i6 < 15; i6++)
                                positions[i1][i2][i3][i4][i4][i6] = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(br.readLine());
        for(int i = 0; i < ncases; i++){
            int ncoins = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            if(isWon(x1, y1, x2, y2, x3, y3))
                System.out.println("First");
            else System.out.println("Second");
    }
    }
    private static boolean search(int m, int n){
        if(states[m][n] != -1){
            if(states[m][n] == 1)
                return true;
            else return false;
        }
        else{
            boolean result = false;
            for(int i = 0; i < 4; i++){
                int newx = m + xmov[i];
                int newy = n + ymov[i];
                if(newx >= 0 && newx <= 14 && newy >= 0 && newy <= 14){
                    if(!search(newx, newy)){
                        result = true;
                        break;
                    }
                }
            }
            if(result)
                states[m][n] = 1;
            else states[m][n] = 0;
            return result;
        }
    }
    private static boolean isWon(int x1, int y1,int x2, int y2, int x3, int y3){
        if(positions[x1][y1][x2][y2][x3][y3] != -1){
            if (positions[x1][y1][x2][y2][x3][y3] == 1)
            return true;
            else return false;
        }
        else{
            int winCount = 0;
            int loseCount = 0;
            if(search(x1, y1))
                winCount++;
            else loseCount++;
            if(search(x2, y2))
                winCount++;
            else loseCount++;
            if(search(x3, y3))
                winCount++;
            else loseCount++;
            if (winCount == 0){
                positions[x1][y1][x2][y2][x3][y3] = 0;
                return false;
            }
            else if(winCount == 1){
                positions[x1][y1][x2][y2][x3][y3] = 1;
                return true;
            }
            else{
                boolean couldWin = false;
                for(int i = 0; i < 4; i++){
                    int newx1 = x1 + xmov[i];
                    int newy1 = y1 + ymov[i];
                    if(newx1 >= 0 && newx1 <= 14 && newy1 >= 0 && newy1 <= 14){
                        if(!isWon(newx1, newy1, x2, y2, x3, y3)){
                            couldWin = true;
                            break;
                        }
                    }
                }
                if(!couldWin){
                    for(int i = 0; i < 4; i++){
                        int newx2 = x2 + xmov[i];
                        int newy2 = y2 + ymov[i];
                        if(newx2 >= 0 && newx2 <= 14 && newy2 >= 0 && newy2 <= 14){
                            if(!isWon(x1, y1, newx2, newy2, x3, y3)){
                                couldWin = true;
                                break;
                            }
                        }
                    }
                }
                if(!couldWin){
                    for(int i = 0; i < 4; i++){
                        int newx3 = x3 + xmov[i];
                        int newy3 = y3 + ymov[i];
                        if(newx3 >= 0 && newx3 <= 14 && newy3 >= 0 && newy3 <= 14){
                            if(!isWon(x1, y1, x2, y2, newx3, newy3)){
                                couldWin = true;
                                break;
                            }
                        }
                    }
                }
                if(couldWin)
                    positions[x1][y1][x2][y2][x3][y3] = 1;
                else positions[x1][y1][x2][y2][x3][y3] = 0;
                return couldWin;
            }
        }
    }
}
