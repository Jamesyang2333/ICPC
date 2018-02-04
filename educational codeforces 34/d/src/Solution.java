import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger result = BigInteger.ZERO;
        HashMap<Integer, Integer> numbers = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(i > 0){
                int nocount = 0;
                int a1 = 0;
                int a2 = 0;
                int a3 = 0;
                if(numbers.containsKey(a)){
                    a1 = numbers.get(a);
                    nocount += a1;
                }
                if(numbers.containsKey(a - 1)){
                    a2 = numbers.get(a - 1);
                    nocount += a2;
                }
                if(numbers.containsKey(a + 1)){
                    a3 = numbers.get(a + 1);
                    nocount += a3;
                }
                result = result.add(BigInteger.valueOf(((long)(i - nocount)) * a - (sum - (long)a * a1 - (long)(a - 1) * a2 - (long)(a + 1) * a3)));
            }
            if(!numbers.containsKey(a))
                numbers.put(a, 1);
            else{
                numbers.put(a, numbers.get(a) + 1);
            }
            sum += a;
        }
        System.out.println(result.toString());
    }
}
