import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[n];
            for(int i = 0; i < n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }
            int[] even = new int[(n + 1) / 2];
            int[] odd = new int[n / 2];
            for(int i = 0; i < n; i++){
                if(i % 2 == 0)
                    even[i / 2] = array[i];
                else odd[i / 2] = array[i];
            }
            Arrays.sort(array);
            Arrays.sort(even);
            Arrays.sort(odd);
            int wrong = -1;
            for(int i = 0; i < n; i++){
                if(i % 2 == 0){
                    if(array[i] != even[i / 2]){
                        wrong = i;
                        break;
                    }
                }
                else{
                    if(array[i] != odd[i / 2]){
                        wrong = i;
                        break;
                    }
                }
            }
            if(wrong == -1)
                System.out.format("Case #%d: OK\n", cc + 1);
            else System.out.format("Case #%d: %d\n", cc + 1, wrong);
        }
    }
}
