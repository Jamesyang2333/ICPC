import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long[] inverse = new long[p];
        inverse[p - 1] = b;
        for(int i = p - 2; i >= 0; i--){
            inverse[i] = (inverse[i + 1] * a) % p;
        }
        //System.out.println(inverse[0]);
        long result = 0;
        for(int i = 0; i < p - 1; i++){
            int start = (i - (int)inverse[i] + p) % p;
            long first = start * ((long)(p - 1)) + i;
            if(x >= first)
                result += ((x - first) / ((long)p * (p - 1)) + 1);
        }
        System.out.println(result);
    }
}
