import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] can = new boolean[101];
        for(int i = 0; i < 101; i++)
            can[i] = false;
        can[0] = true;
        for(int i = 0; i < 101; i++){
            if(can[i]){
                if(i + 3 < 101)
                    can[i + 3] = true;
                if(i + 7  < 101)
                    can[i + 7] = true;
            }
        }
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(can[a])
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
