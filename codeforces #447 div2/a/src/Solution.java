import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            int nqs = 0;
            int length = line.length();
            for(int i = 0; i < length; i++){
                if(line.charAt(i) == 'Q')
                    nqs++;
            }
            int result = 0;
            if(nqs >= 2){
            int count = 0;
            for(int i = 0; i < length; i++){
                if(line.charAt(i) == 'Q')
                    count++;
                if(count == nqs)
                    break;
                else if(line.charAt(i) == 'A')
                    result += (count * (nqs - count));
            }}
            System.out.println(result);
        }
        catch (IOException err){}
    }
}
