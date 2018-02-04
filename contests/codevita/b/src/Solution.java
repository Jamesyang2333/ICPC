import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            line = br.readLine();
            line = line.replaceAll(",", " ");
            st = new StringTokenizer(line);
            int[] ones = new int[N];
            for(int i = 0; i < N; i++){
                int number = Integer.parseInt(st.nextToken());
                int count = 0;
                for(int j = 0; j <= 24; j++){
                    if((number & (1 << j)) > 0)
                        count++;
                }
                ones[i] = count;
            }
            int result = 0;
            for(int i = 0; i < N - 1; i++){
                for(int j = i + 1; j < N; j++){
                    if(ones[i] > ones[j])
                        result++;
                }
            }
            System.out.println(result);


        }
        catch (IOException err){}
    }
}
