import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] player = new boolean[3];
        for(int i = 0; i < 0; i++)
            player[i] = false;
        int[] winners = new int[n];
        for(int i = 0; i < n; i++){
            winners[i] =  Integer.parseInt(br.readLine());
        }
            boolean can = true;
            player[0] = true;
            player[1] = true;
            for(int j = 0; j < n; j++){
                if(!player[winners[j] - 1]){
                    can = false;
                    break;
                }
                else{
                    for(int k = 0; k < 3; k++){
                        if(k != winners[j] - 1){
                            if(player[k])
                                player[k] = false;
                            else player[k] = true;
                        }
                    }
                }
            }
        if(can)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
