import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] weight;
    private static int[] value;
    private static int ngood;
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ncase = Integer.parseInt(st.nextToken());
        for(int i = 0; i < ncase; i++){
            st = new StringTokenizer(br.readLine());
            ngood = Integer.parseInt(st.nextToken());
            weight = new int[ngood];
            value = new int[ngood];
            for(int j = 0; j < ngood; j++){
                st = new StringTokenizer(br.readLine());
                value[j] = Integer.parseInt(st.nextToken());
                weight[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int nperson = Integer.parseInt(st.nextToken());
            int total = 0;
            for(int j = 0; j < nperson; j++){
                st = new StringTokenizer(br.readLine());
                int maxweight = Integer.parseInt(st.nextToken());
                total += knapsack(maxweight);
            }
            System.out.println(total);
        }}
        catch (IOException err){}
    }
    private static int knapsack(int maxweight){
        int[] dp = new int[maxweight + 1];
        for(int i = 0; i <= maxweight; i++)
            dp[i] = 0;
        for(int i = 1; i <= ngood; i++){
            for(int j = maxweight; j >= weight[i - 1]; j--){
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[maxweight];
    }
}
