import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] check = new int[n + 2];
        for (int i = 0; i <= n + 1; i++){
            check[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            check[start] += 1;
            check[end + 1] -= 1;
        }
        int[] accu = new int[n + 2];
        for (int i = 0; i <= n + 1; i++){
            if(i == 0){
                accu[i] = check[i];
            }
            else accu[i] = check[i] + accu[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            sb.append(accu[query]);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
