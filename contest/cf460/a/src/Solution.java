import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nlines = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        double min = 100000000000000.0;
        for(int i = 0; i < nlines; i++){
            st = new StringTokenizer(br.readLine());
            double single = ((double)(Integer.parseInt(st.nextToken()))) / Integer.parseInt(st.nextToken());
            if(single < min)
                min = single;
        }
        System.out.println(min * total);
    }
}
