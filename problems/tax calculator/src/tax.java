import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tax {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            double result = 0;
            double a = Double.parseDouble(new StringTokenizer(br.readLine()).nextToken());
            System.out.println(calc(a));
        }
    }
    private static double calc (double a){
        if(a <= 1500)
            return 0.03 * a;
        else if(a <= 4500)
            return (a - 1500) * 0.1 + calc(1500);
        else if(a <= 9000)
            return (a - 4500) * 0.2 + calc(4500);
        else if(a <= 35000)
            return (a - 9000) * 0.25 + calc(9000);
        else if(a <= 55000)
            return (a - 35000) * 0.3 + calc(35000);
        else if(a <= 80000)
            return (a - 55000) * 0.35 + calc(55000);
        else return (a - 80000) * 0.45 + calc(55000);
    }
}
