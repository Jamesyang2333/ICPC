import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            int[] cities = new int[5001];
            for(int i = 0; i <= 5000; i++){
                cities[i] = 0;
            }
            int nbuses = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < nbuses; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                cities[start]++;
                if(end < 5000)
                cities[end + 1]--;
            }
            int[] prefix = new int[5001];
            prefix[0] = cities[0];
            for(int i = 1; i <= 5000; i++){
                prefix[i] = cities[i] + prefix[i - 1];
            }
            int nquery = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            System.out.format("Case #%d:", cc + 1);
            for(int i = 0; i < nquery; i++){
                int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                System.out.print(" " + prefix[n]);
            }
            System.out.println();
            br.readLine();
        }
    }
}
