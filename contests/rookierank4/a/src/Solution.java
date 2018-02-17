import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nchaps = Integer.parseInt(st.nextToken());
        int totalh = Integer.parseInt(st.nextToken());
        int[] chaps = new int[nchaps];
        for(int i = 0; i < nchaps; i++){
            chaps[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        }
        Arrays.sort(chaps);
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nchaps; i++){
            sum += chaps[i];
            if(sum > totalh)
                break;
            else
                count++;
        }
        System.out.println(count);
    }
}
