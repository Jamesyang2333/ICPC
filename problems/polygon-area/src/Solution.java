import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;
            int[][] coordinates = new int[n][2];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                coordinates[i][0] = Integer.parseInt(st.nextToken());
                coordinates[i][1] = Integer.parseInt(st.nextToken());
            }
            double sum = 0;
            for (int i = 0; i < n; i++){
                int yindex = (i + 1) % n;
                sum += (coordinates[i][0] * coordinates[yindex][1]);
            }
            for (int i = 0; i < n; i++){
                int xindex = (i + 1) % n;
                sum -= (coordinates[i][1] * coordinates[xindex][0]);
            }
            if(sum < 0){
                System.out.print("cw");
                System.out.println(" " + Math.abs(sum) / 2);
            }
            else{
                System.out.print("ccw");
                System.out.println(" " + Math.abs(sum) / 2);
            }
        }
    }
}
