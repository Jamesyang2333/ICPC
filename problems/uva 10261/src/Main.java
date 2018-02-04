import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        boolean[] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            br.readLine();
            int len = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            dp = new boolean[len * 100 + 1];
            HashMap<Integer, ArrayList<Integer>> sequence = new HashMap<>();
            for(int j = 0; j <  len * 100 + 1;  j++)
                dp[j] = false;
            dp[0] = true;
            sequence.put(0, new ArrayList<Integer>());
            int sum = 0;
            int count = 0;
            int answer = 0;
            boolean found = true;
            while(true){
                int car = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                if(car == 0)
                    break;
                if(!found)
                    continue;
                found = false;
                sum += car;
                count++;
                for(int j = len * 100; j >= 0; j--){
                    if(j >= car && dp[j - car]){
                        answer = j;
                        found = true;
                        dp[j] = true;
                        ArrayList<Integer> cars = (ArrayList<Integer>)sequence.get(j - car).clone();
                        cars.add(count);
                        sequence.put(j, cars);
                    }
                    else if(dp[j]){
                        if(sum - j <= len * 100){
                            if(!found)
                                answer = j;
                            found = true;
                        }
                        else{
                            dp[j] = false;
                        }
                    }
                    else{
                        dp[j] = false;
                    }
                }
            }
            int result = 0;
            if(found)
                result = count;
            else result = count - 1;
            System.out.println(result);
            ArrayList<Integer> chosen = sequence.get(answer);
            for(int j = 0; j < result; j++){
                if(chosen.contains(j + 1))
                    System.out.println("starboard");
                else System.out.println("port");
            }
            if(i != ncases - 1)
            System.out.println();
        }
    }
}
