import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<elephant> sequence = new ArrayList<>();
        int count = 0;
        while(true){
            String line = br.readLine();
            if(line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            short weight = Short.parseShort(st.nextToken());
            short IQ = Short.parseShort(st.nextToken());
            sequence.add(new elephant(weight, IQ, ++count));
        }
        Collections.sort(sequence);
        int len = sequence.size();
        int[] prev = new int[len];
        int[] dp = new int[len];
        dp[0] = 1;
        int answer = 0;
        int last = 0;
        for(int i = 1; i < len; i++){
            int max = 1;
            int prevNum = -1;
            for(int j = 0; j < i; j++){
                if(sequence.get(i).weight > sequence.get(j).weight){
                    if(sequence.get(i).IQ < sequence.get(j).IQ){
                        if(dp[j] + 1 > max){
                            max = dp[j] + 1;
                            prevNum = j;
                        }
                    }
                }
            }
            dp[i] = max;
            prev[i] = prevNum;
            if(max > answer){
                answer = max;
                last = i;
            }
        }
        Stack<Integer> order = new Stack<>();
        for(int i = 0; i < answer; i++){
            order.add(sequence.get(last).index);
            last = prev[last];
        }
        System.out.println(answer);
        for(int i = 0; i < answer; i++)
            System.out.println(order.pop());
    }
}
class elephant implements Comparable<elephant>{
    int index;
    short weight;
    short IQ;
    public elephant(short weight, short IQ, int index){
        this.weight = weight;
        this.IQ = IQ;
        this.index = index;
    }
    public int compareTo(elephant a){
        return weight - a.weight;
    }
}