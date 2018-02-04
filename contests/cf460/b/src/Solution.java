import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 19; i < 20000000; i++){
            if(check(i))
                numbers.add(i);
        }
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        System.out.println(numbers.get(n - 1));
    }
    private static boolean check(int a){
        int sum = 0;
        while (a > 0){
            sum += (a % 10);
            a /= 10;
        }
        if(sum == 10)
            return true;
        else return false;
    }
}
