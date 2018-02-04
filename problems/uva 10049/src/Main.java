import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        dp.add(3);
        int count = 2;
        for(int i = 3; i < 700000; i++){
            if(i <= dp.get(count))
                dp.add(dp.get(i - 1) + count);
            else{
                count++;
                dp.add(dp.get(i - 1) + count);
            }
        }
        while (true){
            String line = br.readLine();
            int n = Integer.parseInt(new StringTokenizer(line).nextToken());
            if(n == 0)
                break;
            else {
                int rank = Collections.binarySearch(dp, n);
                if(rank < 0)
                    rank = (-rank) - 1;
                System.out.println(rank);
            }
        }
    }
}
