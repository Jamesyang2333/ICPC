import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] b = new int[3];
        for (int i = 0; i < 3; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < 3; i++){
            if(a[i] > b[i]){
                alice++;
            }
            else if(a[i] < b[i]){
                bob++;
            }
        }
        System.out.print(alice);
        System.out.println(" " + bob);
    }
}
