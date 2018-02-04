import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        HashMap<Integer, Integer> numbers = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!numbers.containsKey(num))
                numbers.put(num, 1);
            else numbers.put(num, numbers.get(num) + 1);
            if(numbers.get(num) > max)
                max = numbers.get(num);
        }
        System.out.println(max);
    }
}
