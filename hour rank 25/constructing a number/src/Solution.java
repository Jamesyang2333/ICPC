import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nqueries = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < nqueries; i++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;
            for(int j = 0; j < n; j++){
                result += (digitsum(Integer.parseInt(st.nextToken())));
            }
            if(result % 3 == 0)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
    private static int digitsum(int a){
        int sum = 0;
        while(a > 0){
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }
}
