import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long a1, b1, a2, b2;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int sum = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(sum == 0)
                break;
            else{
                StringTokenizer st = new StringTokenizer(br.readLine());
                long cost1 = Integer.parseInt(st.nextToken());
                long cap1 = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                long cost2 = Integer.parseInt(st.nextToken());
                long cap2 = Integer.parseInt(st.nextToken());
                a1 = 1;
                b1 = 0;
                a2 = 0;
                b2 = 1;
                long divisor = gcd(cap1, cap2);
                if(sum % divisor != 0)
                    System.out.println("failed");
                else{
                long lcm = (long)cap1 * cap2 / divisor;
                a1 = a1 * (sum / divisor);
                b1 = b1 * (sum / divisor);
                if (cost1 * cap2 > cost2 * cap1){
                    if(a1 < 0){
                        long t = 0;
                        if((-a1) % (lcm / cap1) != 0)
                            t = (-a1) / (lcm / cap1) + 1;
                        else t = (-a1) / (lcm / cap1);
                        a1 = a1 + t * (lcm / cap1);
                        b1 = b1 - t * (lcm / cap2);
                    }
                    else{
                        long t = (a1) / (lcm / cap1);
                        a1 = a1 - t * (lcm / cap1);
                        b1 = b1 + t * (lcm / cap2);
                    }
                    if(b1 < 0)
                        System.out.println("failed");
                    else System.out.println(a1 + " " + b1);
                }
                else{
                    if(b1 < 0){
                        long t = 0;
                        if((-b1) % (lcm / cap2) != 0)
                            t = (-b1) / (lcm / cap2) + 1;
                        else t = (-b1) / (lcm / cap2);
                        a1 = a1 - t * (lcm / cap1);
                        b1 = b1 + t * (lcm / cap2);
                    }
                    else{
                        long t = (b1) / (lcm / cap2);
                        a1 = a1 + t * (lcm / cap1);
                        b1 = b1 - t * (lcm / cap2);
                    }
                    if(a1 < 0)
                        System.out.println("failed");
                    else System.out.println(a1 + " " + b1);
                }
            }
            }
        }
    }
    private static long gcd(long a, long b){
        if(b == 0)
            return a;
        long mul = a / b;
        long a1c = a1;
        long b1c = b1;
        a1 = a2;
        b1 = b2;
        a2 = a1c - mul * a2;
        b2 = b1c - mul * b2;
        return gcd(b, a % b);
    }
}
