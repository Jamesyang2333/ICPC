import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            line = line.replaceAll(",", " ");
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            line = br.readLine();
            line = line.replaceAll(",", " ");
            st = new StringTokenizer(line);
            if(p != q){
            for(int i = 0; i < N; i++){
                int number = Integer.parseInt(st.nextToken());
                if(number % p == 0){
                    if(number % q == 0)
                        d++;
                    else a++;
                }
                else{
                    if(number % q == 0)
                        b++;
                    else c++;
                }
            }
            int result = (getRem(d) - 1) * getRem(a + b) + getRem(a + b) - getRem(a) - getRem(b) + 1;
            if(result > 0)
                result = result % 1009;
            else
                result = (result % 1009) + 1009;
            result = result * getRem(c);
            result = result % 1009;
            System.out.println(result);
            //for(int i = 0; i < 30; i++)
              //  System.out.println(getRem(i));
            }
            else {
                for(int i = 0; i < N; i++){
                    int number = Integer.parseInt(st.nextToken());
                    if(number % p == 0){
                        number /= p;
                        if(number % p == 0)
                            b++;
                        else a++;
                    }
                    else c++;
                }
                int result = (getRem(b) - 1) * getRem(a) + getRem(a) - a - 1;
                if(result > 0)
                    result = result % 1009;
                else
                    result = (result % 1009) + 1009;
                result = result * getRem(c);
                result = result % 1009;
                System.out.println(result);
            }
        }
        catch (IOException err){}

    }
    private static int getRem(int x){
        int reminder = x % 10;
        int rem = (1 << reminder);
        x = (x / 10) * 10;
        for(int i = 0; i < x / 10; i++){
            rem = (rem * 15) % 1009;
        }
        return rem;
    }
}
