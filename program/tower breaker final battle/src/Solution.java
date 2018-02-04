import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {
    private static long[] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cost = new long[136];
        cost[0] = 1;
        cost[1] = 1;
        cost[2] = 1;
        cost[3] = 1;
        cost[4] = 2;
        for(int i = 5; i <= 127; i++){
            long result = 0;
            int limit = (int)(Math.sqrt(i) + 0.5);
            for(int j = 1; j <= limit; j++){
                if(j * j <= i)
                    result += cost[i - j * j];
            }
            //if(result < 0) System.out.println(i);
            cost[i] = result;
        }
        //System.out.println(cost[127]);
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            long n = Long.parseLong(new  StringTokenizer(br.readLine()).nextToken());
            int pos = Arrays.binarySearch(cost, n);
            if(pos < 0)
                pos = -pos - 1;
            System.out.println(pos);
        }
    }
}
