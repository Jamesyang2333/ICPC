/*Must pay attention to the requirement for the blank lines regarding output and input.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        boolean first = true;
        while((line = br.readLine()) != null){
            if(!first){
                System.out.println();
                line = br.readLine();}
            else first = false;
            st = new StringTokenizer(line);
            int aircap = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cap = aircap / (3 * w);
            st = new StringTokenizer(br.readLine());
            int ntreasure = Integer.parseInt(st.nextToken());
            int[] depths = new int[ntreasure];
            int[] values = new int[ntreasure];
            for(int i = 0; i < ntreasure; i++){
                st = new StringTokenizer(br.readLine());
                depths[i] = Integer.parseInt(st.nextToken());
                values[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[cap + 1];
            ArrayList<Integer>[] choices = new ArrayList[cap + 1];
            for(int i = 0; i <= cap; i++){
                dp[cap] = 0;
            }
            for(int i = 0; i <= cap; i++){
                choices[i] = new ArrayList<Integer>();
            }
            for(int i = 1; i <= ntreasure; i++){
                for(int j = cap; j >= depths[i - 1]; j--){
                    if(dp[j - depths[i - 1]] + values[i - 1] > dp[j]){
                        dp[j] = dp[j - depths[i - 1]] + values[i - 1];
                        choices[j] = (ArrayList<Integer>)choices[j - depths[i - 1]].clone();
                        choices[j].add(i - 1);
                    }
                }
            }
            System.out.println(dp[cap]);
            System.out.println(choices[cap].size());
            for(int i = 0; i < choices[cap].size(); i++){
                System.out.print(depths[choices[cap].get(i)]);
                System.out.println(" " + values[choices[cap].get(i)]);
            }

        }
        }
        catch(IOException err){}
    }
}
