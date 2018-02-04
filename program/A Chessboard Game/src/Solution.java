import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static byte[][] states;
    private static int[] xmov = {-2, -2, 1, -1};
    private static int[] ymov = {1, -1, -2, -2};
    public static void main(String[] args) throws IOException{
        states = new byte[15][15];
        for(int i = 0; i < 15; i++)
            for(int j = 0; j < 15; j++)
                states[i][j] = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(br.readLine());
        for(int i = 0; i < ncases; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(search(m - 1, n - 1))
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
}
