import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        int[] fib = new int[30];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < 30; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        //System.out.println(fib[29]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        boolean[] isfib = new boolean[1001];
        for(int i = 0; i < 1001; i++)
            isfib[i] = false;
        for(int i = 0; i < 30; i++){
            if(fib[i] > 1000)
                break;
            isfib[fib[i]] = true;
        }
        for(int i = 0; i < n; i++){
            if(isfib[i + 1])
                System.out.print("O");
            else System.out.print("o");
        }
        System.out.println();
    }
}
