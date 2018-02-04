import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long k = Long.parseLong(new StringTokenizer(br.readLine()).nextToken());
        long start = k * (k - 1) + 1;
        long result = 0;
        for(int i = 0; i < k; i++){
            result += start + 2 * i;
        }
        pw.println(result);
        pw.close();
    }
}
