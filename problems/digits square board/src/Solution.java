import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    private static int[][][][] grundys;
    private static int[][] board;
    private static HashSet<Integer> prime = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        prime.add(2);
        prime.add(3);
        prime.add(5);
        prime.add(7);
        for(int i = 0; i < ncases; i++){
            int length = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            grundys = new int[length][length][length][length];
            for(int i1 = 0; i1 <  length; i1++)
                for (int i2 = 0; i2 < length; i2++)
                    for(int i3 = 0;  i3 < length; i3++)
                        for(int i4 = 0; i4 < length; i4++)
                            grundys[i1][i2][i3][i4] = -1;
            board = new int[length][length];
            for(int j = 0; j < length; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < length; k++){
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int a = findGrundy(0, 0, length - 1, length - 1);
            if(a == 0)
                System.out.println("Second");
            else System.out.println("First");

        }
    }
    private static boolean cuttale(int x1, int y1, int x2, int y2){
        boolean can = false;
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(!prime.contains(board[i][j])){
                    can = true;
                    break;
                }
            }
            if(can)
                break;
        }
        return can;
    }
    private static int findGrundy(int x1, int y1, int x2,  int y2){
        if(x1 == x2 && y1 == y2)
            return 0;
        else{
            if(grundys[x1][y1][x2][y2] != -1){
                return grundys[x1][y1][x2][y2];
            }
            else{
                if (!cuttale(x1, y1, x2, y2))
                    grundys[x1][y1][x2][y2] = 0;
                else{
                    HashSet<Integer> next = new HashSet<>();
                    for(int i = x1; i < x2; i++)
                        next.add(findGrundy(x1, y1, i, y2) ^ findGrundy(i + 1, y1, x2, y2));
                    for(int i = y1; i < y2; i++){
                        next.add(findGrundy(x1,  y1, x2, i) ^ findGrundy(x1, i + 1, x2, y2));
                    }
                    int result = 0;
                    for(int i = 0; i < 100; i++){
                        if(!next.contains(result))
                            break;
                        result++;
                    }
                    grundys[x1][y1][x2][y2] = result;
                }
                return grundys[x1][y1][x2][y2];
            }

        }
    }
}
