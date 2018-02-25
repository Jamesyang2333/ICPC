import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < a; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sequence = st.nextToken();
            int len = sequence.length();
            int k = Integer.parseInt(st.nextToken());
            boolean[] pancakes = new boolean[len];
            for(int i = 0; i < len; i++){
                if(sequence.charAt(i) == '+')
                    pancakes[i] = true;
                else pancakes[i] = false;
            }
            int count = 0;
            for(int i = 0; i <= (len - k); i++){
                if(!pancakes[i]){
                    count++;
                    for(int j = 0; j < k; j++){
                        pancakes[i + j] = !pancakes[i + j];
                    }
                }
            }
            boolean can = true;
            for(int i = 0; i < k; i++){
                if(!pancakes[len - 1 - i]){
                    can = false;
                    break;
                }
            }
            if(!can)
                System.out.println("Case #" + (cc + 1) + ": IMPOSSIBLE");
            else {
                System.out.format("Case #%d: %d\n", cc + 1,  count);
            }
        }
    }
}
