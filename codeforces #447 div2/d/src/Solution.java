import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int n;
    private static int[] length;
    private static long result = 0;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            length = new int[n - 1];
            for(int i = 0; i < n - 1; i++){
                st = new StringTokenizer(br.readLine());
                length[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int H = Integer.parseInt(st.nextToken());
                result = 0;
                search(start, H, -1, true);
                System.out.println(result);
            }
        }
        catch (IOException err){}
    }
    private static void search(int current, int remHappy, int previous, boolean down){
        result += remHappy;
        if(down){
            if(current * 2 <= n && current * 2 != previous){
                if(remHappy > length[current * 2 - 2]){
                    search(current * 2, remHappy - length[current * 2 - 2], 1, false);
                }
            }
            if(current * 2 + 1 <= n && current * 2 + 1 != previous){
                if(remHappy > length[current * 2 - 1]){
                    search(current * 2 + 1, remHappy - length[current * 2 - 1], 1, false);
                }
            }
            if(current / 2 != 0){
                if(remHappy > length[current - 2]){
                    search(current / 2, remHappy - length[current - 2], current, true);
                }
            }
        }
        if(!down){
            if(current * 2 <= n && current * 2 != previous){
                if(remHappy > length[current * 2 - 2]){
                    search(current * 2, remHappy - length[current * 2 - 2], 1, false);
                }
            }
            if(current * 2 + 1 <= n && current * 2 + 1 != previous){
                if(remHappy > length[current * 2 - 1]){
                    search(current * 2 + 1, remHappy - length[current * 2 - 1], 1, false);
                }
            }
        }

    }
}
