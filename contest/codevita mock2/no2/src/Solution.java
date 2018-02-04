import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long numMod = Long.parseLong(st.nextToken());
        long[] arr1 = new long[n];
        long[] arr2 = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr1[i] = Long.parseLong(st.nextToken());
        long maxin2 = -100000;
        long result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
            maxin2 = Math.max(Math.abs(arr2[i]), maxin2);
            result += arr1[i] * arr2[i];
        }
        result -= (2 * numMod * maxin2);
        System.out.print(result);}
        catch(IOException e){}
    }
}
