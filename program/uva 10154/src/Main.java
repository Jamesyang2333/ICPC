import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<turtle> slaveList = new ArrayList<>();
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            int weight = Integer.parseInt(st.nextToken());
            int strenth = Integer.parseInt(st.nextToken());
            slaveList.add(new turtle(weight, strenth));
        }
        Collections.sort(slaveList);
        int n = slaveList.size();
        long[] dp = new long[n + 1];
        dp[0] = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            long prev = 0;
            for(int j = 0; j <= max; j++){
                long prevCopy = dp[j + 1];
                if(j < max){
                    if(prev + slaveList.get(i).weight <= slaveList.get(i).strength && prev + slaveList.get(i).weight <= dp[j + 1]){
                        dp[j + 1] = prev + slaveList.get(i).weight;
                    }
                }
                else{
                    if(prev + slaveList.get(i).weight <= slaveList.get(i).strength){
                        dp[j + 1] = prev + slaveList.get(i).weight;
                        max++;
                        break;
                    }
                }
                prev = prevCopy;
            }
        }
        System.out.println(max);
    }
}
class turtle implements Comparable<turtle>{
    int weight;
    int strength;
    public turtle(int weight, int strength){
        this.weight = weight;
        this.strength = strength;
    }
    public int compareTo(turtle a){
        return strength - a.strength;
    }
}
