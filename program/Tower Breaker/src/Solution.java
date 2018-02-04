import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(br.readLine());
        for(int i = 0; i < ncases; i++){
            boolean result = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(M == 1)
                result = false;
            else{
                if(N % 2 == 0)
                    result = false;
                else result = true;
            }
            if(result)
                System.out.println("1");
            else System.out.println("2");
        }
    }
}
