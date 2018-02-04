import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final long div = 1000000007;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long result = 0;
            if(k == 1){
                result = getRim(2, (m - 1));
                result = getRim(result, n - 1);
            }
            else{
                if((n + m) % 2 == 0){
                    result = getRim(2, (m - 1));
                    result = getRim(result, n - 1);
                }
                else result = 0;
            }
            System.out.println(result);
        }
        catch (IOException err){}
    }
    private static long getRim(long base, long expo){
        if(expo == 0)
            return 1;
        if(expo == 1)
            return base;
        if(expo % 2 == 0){
            long half = getRim(base, expo / 2);
            return ((half * half) % div);}
        else
            return (base * getRim(base, expo - 1)) % div;
    }
}
