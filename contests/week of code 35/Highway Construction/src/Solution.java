import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final long hh = 1000000009;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ncases = Integer.parseInt(st.nextToken());
            for(int i = 0; i < ncases; i++){
                st = new StringTokenizer(br.readLine());
                Long n = Long.parseLong(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                if(n == 1 || n == 2)
                    System.out.println(0);
                else{
                    long result = 0;
                    if(k == 1){
                        if(n % 2 == 0){
                            result = (n / 2) % hh;
                            result = (result * ((n - 1) % hh)) % hh;
                            result = (hh + result - 1) % hh;
                        }
                        else{
                            result = ((n - 1) / 2) % hh;
                            result = (result * (n % hh)) % hh;
                            result = (hh + result - 1) % hh;
                        }
                    }
                    if(k == 2){
                        long first = n;
                        long second = n - 1;
                        long third = 2 * n - 1;
                        if(first % 2 == 0)
                            first /= 2;
                        else
                            second /= 2;
                        if(first % 3 == 0)
                            first /= 3;
                        else if (second % 3 == 0)
                            second /= 3;
                        else third /= 3;
                        result = ((((first % hh) * (second % hh)) % hh) * (third % hh)) % hh;
                        result = (hh + result - 1) % hh;
                    }
                    if(k == 3){
                        if(n % 2 == 0){
                            result = (n / 2) % hh;
                            result = (result * ((n - 1) % hh)) % hh;
                            result = (result * result) % hh;
                            result = (hh + result - 1) % hh;
                        }
                        else{
                            result = ((n - 1) / 2) % hh;
                            result = (result * (n % hh)) % hh;
                            result = (result * result) % hh;
                            result = (hh + result - 1) % hh;
                        }
                    }
                    if(k > 3){
                        if(n <= hh + 1){
                        result = fastExpo(2, k);
                        for(long j = 3; j < n; j++){
                            result = (result + fastExpo(j, k)) % hh;
                        }
                        }
                        else{
                            long circle = (n - 1) / hh;
                            long rem = (n - 1) % hh;
                            for(long j = 1; j < hh; j++){
                                if(j <= rem){
                                    if(j == 1)
                                        result = (result + fastExpo(j, k) * circle) % hh;
                                    else result += (result + ((fastExpo(j, k) * (circle + 1)) % hh)) % hh;
                                }
                                else result += (result + ((fastExpo(j, k) * circle)  % hh)) % hh;
                            }
                        }
                    }
                    System.out.println(result);
                }
            }
        }
        catch(IOException err){}
    }
    private static long fastExpo(long base, int expo){
        if(expo == 1)
            return (base % hh);
        if(expo % 2 == 0)
            return (fastExpo(base, expo / 2) * fastExpo(base, expo / 2)) % hh;
        else return (base * fastExpo(base, expo - 1)) % hh;
    }
}
