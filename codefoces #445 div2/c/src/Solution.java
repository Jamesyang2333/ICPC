import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void  main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] log = new int[n + 1];
            for(int i = 1; i <= n; i++){
                log[i] = Integer.parseInt(st.nextToken());
            }
            int count = 1;
            int[] rooms = new int[n + 1];
            int[] last = new int[n + 1];
            rooms[0] = 1;
            last[1] = 0;
            for(int i = 1; i <= n; i++){
                if(last[rooms[log[i]]] == log[i]){
                    rooms[i] = rooms[log[i]];
                    last[rooms[log[i]]] = i;
                }
                else{
                    count++;
                    rooms[i] = count;
                    last[count] = i;
                }
            }
            System.out.println(count);
        }
        catch (IOException err){}
    }
}
