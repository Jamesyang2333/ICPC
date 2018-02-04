import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] permutation;
    private static int n;
    private static byte[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            StringTokenizer st = new StringTokenizer(br.readLine());
            permutation = new int[n];
            for(int j = 0; j < n; j++)
                permutation[j] = Integer.parseInt(st.nextToken());
            dp = new byte[(1 << n)];
            for(int j = 0; j < (1 << n); j++)
                dp[j] = -1;
            boolean result = search((1 << n) - 1);
            if(result){
                System.out.println("Alice");
            }
            else
                System.out.println("Bob");
        }
    }
    private static boolean search(int bitmask){
        if(dp[bitmask] != -1){
            if(dp[bitmask] == 1)
                return true;
            else return false;
        }
        else{
            boolean can = true;
            int last = -1;
            for(int i = 0; i < n; i++){
                if((bitmask & (1 << i)) > 0){
                    if(permutation[i] > last){
                        last = permutation[i];
                    }
                    else{
                        can = false;
                        break;
                    }
                }
            }
            if(can){
                dp[bitmask] = 0;
                return false;
            }
            else{
                boolean win = false;
                for (int i = 0; i < n; i++){
                    if((bitmask & (1 << i)) > 0){
                        int next = bitmask ^ (1 << i);
                        if(!search(next)){
                            win = true;
                            break;
                        }
                    }
                }
                if(win){
                    dp[bitmask] = 1;
                    return true;
                }
                else {
                    dp[bitmask] = 0;
                    return false;
                }
            }
        }
    }
}
