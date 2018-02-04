import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] scores = new int[n];
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        for(int i = 0; i < n; i++){
            scores[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        }
        fromLeft[0] = 1;
        for(int i = 1; i < n; i++){
            if(scores[i] > scores[i - 1])
                fromLeft[i] = fromLeft[i - 1] + 1;
            else fromLeft[i] = 1;
        }
        fromRight[n - 1] = 1;
        for(int j = n - 2; j >= 0;  j--){
            if(scores[j] > scores[j + 1])
                fromRight[j] = fromRight[j + 1] + 1;
            else fromRight[j] = 1;
        }
        long result = 0;
        for(int i = 0; i < n; i++)
            result += Math.max(fromLeft[i], fromRight[i]);
        System.out.println(result);
    }
}
