import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] cafes = new int[200001];
            for(int i = 0; i <= 200000; i++)
                cafes[i] = -1;
            for(int i = 0; i < n; i++){
                int index = Integer.parseInt(st.nextToken());
                cafes[index] = i;
            }
            int min = 200001;
            int current = 0;
            for(int i = 0; i <= 200000; i++){
                if(cafes[i] >= 0)
                    if(cafes[i] < min){
                    current = i;
                    min = cafes[i];
                }
            }
            System.out.println(current);
        }
        catch (IOException err){}
    }
}
