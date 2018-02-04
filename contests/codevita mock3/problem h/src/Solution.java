import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> rows = new ArrayList<>();
        while (st.hasMoreTokens()){
            rows.add(st.nextToken());
        }
        boolean first = true;
        for(String x : rows){
            if(first)
                first = false;
            else
                System.out.println();
            for(int i = 0; i < x.length(); i++){
                if(i % 2 == 0)
                {for(int j = 0; j < x.charAt(i) - 64; j++)
                        System.out.print("0");}
                else
                {for(int j = 0; j < x.charAt(i) - 64; j++)
                        System.out.print("!");}
            }
        }
        }
        catch (IOException err){}
    }
}
