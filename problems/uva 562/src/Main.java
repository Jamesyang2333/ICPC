
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ncase = Integer.parseInt(st.nextToken());
            String line;
            while((line = br.readLine()) != null){
                st = new StringTokenizer(line);
                int ncoins = Integer.parseInt(st.nextToken());
                int[] coins = new int[ncoins + 1];
                coins[0] = 0;
                int total = 0;
                st = new StringTokenizer(br.readLine());
                for(int i = 1; i <= ncoins; i++){
                    coins[i] = Integer.parseInt(st.nextToken());
                    total += coins[i];
                }
                int half;
                if(total % 2 == 0)
                    half = total / 2;
                else half = (total - 1) / 2;
                int[] dp = new int[half + 1];
                for(int i = 0; i <= half; i++)
                    dp[i] = 0;
                for(int i = 1; i <= ncoins; i++)
                    for(int j = half; j >= coins[i]; j--){
                        dp[j] = Math.max(dp[j], dp[j - coins[i]] + coins[i]);
                    }
                int result = 0;
                if(total % 2 == 0)
                    result = 2 * (half - dp[half]);
                else result = 1 + 2 * (half - dp[half]);
                System.out.println(result);
            }
        }
        catch(IOException err){}

    }
}
