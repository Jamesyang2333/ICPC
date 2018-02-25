import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            long n = Long.parseLong(new StringTokenizer(br.readLine()).nextToken());
            long initialLengh = findlargest(n);
            System.out.format("Case #%d: %d\n", cc + 1, find(initialLengh, n));
        }
    }
    public static long findlargest(long n){
        long a = 1;
        while(a - 1 < n){
            a = a * 2;
        }
        return a - 1;
    }
    public static int find(long len, long n){
        if(n == (len + 1) / 2)
            return 0;
        else if(n < (len + 1) / 2)
            return find((len - 1) / 2, n);
        else return 1 - find(len - 1 / 2, len - n + 1);
    }
}
