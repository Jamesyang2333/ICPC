import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution1 {
    private static int[][] grundys;
    private static int[] xmov = {-2, -2, 1, -1};
    private static int[] ymov = {1, -1, -2, -2};
    public static void main(String[] args) throws IOException{
        grundys = new int[15][15];
        for(int i = 0; i < 15; i++)
            for(int j = 0; j < 15; j++)
                grundys[i][j] = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            int ncoins = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int nimsum = 0;
            for(int j = 0; j < ncoins; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()) - 1;
            int n = Integer.parseInt(st.nextToken()) - 1;
            nimsum = nimsum ^ grundy(m, n);
            }
            if(nimsum != 0)
                System.out.println("First");
            else System.out.println("Second");
        }
        /*for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                System.out.print(grundys[i][j] + " ");
            }
            System.out.println();
        }*/
    }
    private static int grundy(int m, int n){
        if(grundys[m][n] != -1){
            return grundys[m][n];
        }
        else{
            int result = 0;
            HashSet<Integer> nextGrundy = new HashSet<>();
            for(int i = 0; i < 4; i++){
                int newx = m + xmov[i];
                int newy = n + ymov[i];
                if(newx >= 0 && newx <= 14 && newy >= 0 && newy <= 14){
                    nextGrundy.add(grundy(newx, newy));
                }
            }
            for(int i = 0; i < 5; i++){
                if(!nextGrundy.contains(result)){
                    break;
                }
                else result++;
            }
            grundys[m][n] = result;
            return result;
        }
    }
}