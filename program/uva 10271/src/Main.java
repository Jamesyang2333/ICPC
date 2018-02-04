import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final long max = 1000000000000l;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ncases = Integer.parseInt(st.nextToken());
        for(int i = 0; i < ncases; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()) + 8;
            int nchops = Integer.parseInt(st.nextToken());
            int[] chops = new int[nchops];
            st = new StringTokenizer(br.readLine());
            for(int j = nchops - 1; j >= 0; j--){
                chops[j] = Integer.parseInt(st.nextToken());
            }
            long[][] dp = new long[nchops + 1][k + 1];
            for(int j = 0; j < nchops + 1; j++){
                dp[j][0] = 0;
            }
            for(int j = 0; j < nchops + 1; j++){
                for(int l = 1; l < k + 1; l++){
                    dp[j][l] = max;
                }
            }
            for(int j = 1; j < nchops + 1; j++){
                for(int l = 1; l < k + 1; l++){
                    if(l <= j / 3){
                        dp[j][l] = Math.min(dp[j - 1][l], dp[j - 2][l - 1] + (chops[j - 1] - chops[j - 2]) * (chops[j - 1] - chops[j - 2]));
                    }
                    else break;
                }
            }
            long result = max;
            System.out.println(dp[nchops][k]);
        }
    }
}
