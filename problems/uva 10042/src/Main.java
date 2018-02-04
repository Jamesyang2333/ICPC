import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < n; i++){
            int current = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int add = 1;
            while (true){
                if(factordigitsum(current + add) == digitsum(current + add)){
                    System.out.println(current + add);
                    break;
                }
                else add++;
            }
        }
    }
    public static int factordigitsum(int a){
        int n = 0;
        int result = 0;
        int count = 0;
        while(a % 2 == 0){
            a /= 2;
            count++;
            n++;
        }
        result += (count * 2);
        for(int i = 3; i < Math.sqrt(a) + 1; i += 2){
            count = 0;
            while(a % i == 0){
                a /= i;
                count++;
                n++;
            }
            result += (count * digitsum(i));
        }
        if(a > 1){
            result += digitsum(a);
            n++;
        }
        if(n > 1)
        return result;
        else return -1;
    }
    public static int digitsum(int a){
        int sum = 0;
        while(a > 0){
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }
}
