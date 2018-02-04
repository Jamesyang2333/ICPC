import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int[] gcds = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++)
                gcds[i] = Integer.parseInt(st.nextToken());
            boolean can = true;
            for(int i = 0; i < m - 1; i++){
                for(int j = i + 1; j < m; j++){
                int gcd = gcd(gcds[j], gcds[i]);
                int index = Arrays.binarySearch(gcds, gcd);
                if(index < 0){
                    if(m == 487)
                        System.out.println(gcds[j] + " " + gcds[i] + " " + gcd(gcds[j], gcds[i]));
                    can = false;
                    break;
                }
                }
                if(!can)
                    break;
            }
            if(can){
                System.out.println(m);
                for(int i = 0; i < m; i++){
                    System.out.print(gcds[i] + " ");
                }
                System.out.println();
            }
            else {System.out.println(-1);
            }
        }
        catch (IOException err){}
    }
    private static int gcd(int a, int b){
        if(b == 0)
            return a;
        else return gcd(b, a % b);
    }
}
