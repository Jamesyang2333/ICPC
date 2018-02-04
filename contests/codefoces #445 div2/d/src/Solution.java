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
            boolean[] letters = new boolean[26];
            String[] sections = new String[26];
            int count = 0;
            for(int i = 0; i < n; i++)
                letters[i] = false;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String current = st.nextToken();
                boolean repeat = false;
                for(int i = 0; i < )
            }
        }
        catch (IOException err){}
    }
}
