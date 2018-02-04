import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public  static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  ncases = Integer.parseInt(br.readLine());
        for(int i = 0; i < ncases; i++){
            int nheaps = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean allOne = true;
            int nimSum = 0;
            for(int j = 0; j < nheaps; j++){
                int current = Integer.parseInt(st.nextToken());
                if(allOne){
                    if(current != 1)
                        allOne = false;
                }
                nimSum = nimSum ^ current;
            }
            boolean result = true;
            if(allOne){
                if(nimSum != 0){
                    result = false;
                }
            }
            else{
                if(nimSum == 0)
                    result = false;
            }
            if(result)
                System.out.println("First");
            else System.out.println("Second");
        }
    }
}
