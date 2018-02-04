import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(br.readLine());
        for(int i = 0; i <  ncases; i++){
            int nPiles = Integer.parseInt(br.readLine());
            int nimsum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j = 1; j < nPiles; j++){
                int number = Integer.parseInt(st.nextToken());
                if(number % 2 == 1)
                    nimsum = nimsum ^ j;
            }
            if(nimsum == 0)
                System.out.println("Second");
            else System.out.println("First");
        }

    }
}
