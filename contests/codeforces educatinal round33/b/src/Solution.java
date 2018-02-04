import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int limit = (int)(Math.sqrt(n));
        if((limit + 1) * (limit + 1) == n)
            limit++;
        int result = 1;

        boolean found = false;
        for(int i = 1; i <= limit; i++){
            if(n % i == 0){
                int current = n / i;
                if(isBeautiful(current)){
                    result = current;
                    found = true;
                    break;
                }
            }
        }
        if(!found)
        for(int i = limit; i >= 1; i--){
            if(n % i == 0){
                int current = i;
                if(isBeautiful(current)){
                    result = current;
                    found = true;
                    break;
                }
            }
        }
        /*for(int i = n; i >= 2; i--){
            if(n % i == 0)
                if(isBeautiful(i)){
                result = i;
                break;
                }
        }*/
        System.out.println(result);
    }
    private static boolean isBeautiful(int n){
        boolean one = false;
        int count0 = 0;
        int count1 = 0;
        while(n > 0){
            if(one){
                if(n % 2 == 0)
                    return false;
                else {
                    count1++;
                    n /= 2;
                }
            }
            if(!one){
                if(n % 2 == 1){
                    count1++;
                    one = true;}
                else count0++;
                n /= 2;
            }
        }
        if(count0 + 1 == count1)
            return true;
        return false;
    }
}
