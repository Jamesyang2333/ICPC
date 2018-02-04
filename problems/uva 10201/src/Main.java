import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final int max = 100000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        br.readLine();
        for(int i = 0; i < ncases; i++){
            int totalDis = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            ArrayList<gasStation> stations = new ArrayList<>();
            stations.add(new gasStation(0, max));
            while(true){
                String line = br.readLine();
                if(line == null)
                    break;
                StringTokenizer st = new StringTokenizer(line);
                if(!st.hasMoreTokens())
                    break;
                int dis = Integer.parseInt(st.nextToken());
                if(dis > totalDis)
                    continue;
                int price = Integer.parseInt(st.nextToken());
                stations.add(new gasStation(dis, price));
            }
            if(stations.get(stations.size() - 1).dis != totalDis);
            stations.add(new gasStation(totalDis, max));
            int nstations = stations.size() - 1;
            int[][] dp = new int[nstations + 1][201];
            for(int j = 0; j < nstations + 1; j++){
                for(int k = 0; k <= 200; k++)
                    dp[j][k] = max;
            }
            dp[0][100] = 0;
            for(int j = 1; j < nstations + 1; j++){
                int[] mincosts = new int[201];
                for(int k = 0; k <= 200; k++){
                    if(k + stations.get(j).dis - stations.get(j - 1).dis <= 200){
                        dp[j][k] = dp[j - 1][k + stations.get(j).dis - stations.get(j - 1).dis];
                    }
                    if(k == 0){
                        mincosts[k] = dp[j][k] + (200 - k) * stations.get(j).price;
                    }
                    else{
                        mincosts[k] = Math.min(mincosts[k - 1], dp[j][k] + (200 - k) * stations.get(j).price);
                    }
                }
                for(int k = 0; k <= 200; k++){
                    dp[j][k] = Math.min(mincosts[k] - (200 - k) * stations.get(j).price, dp[j][k]);
                }
            }
            if(dp[nstations][100] >= max){
                System.out.println("Impossible");
            }
            else System.out.println(dp[nstations][100]);
            if(i != ncases - 1)
                System.out.println();
        }
    }
}
class gasStation{
    int dis;
    int price;
    public gasStation(int dis, int price){
        this.dis = dis;
        this.price = price;
    }
}
