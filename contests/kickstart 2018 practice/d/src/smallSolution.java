import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class smallSolution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int nqueries = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] numbers = new int[n];
            for(int i = 0; i < n; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            int[] sum = new int[n + 1];
            sum[0] = 0;
            for(int i = 1; i <= n; i++)
                sum[i] = sum[i - 1] + numbers[i - 1];
            ArrayList<Integer> sumofsums = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                for(int j = 0; j < i; j++){
                    sumofsums.add(sum[i] - sum[j]);
                }
            }
            Collections.sort(sumofsums);
            long[] newsum = new long[n * (n + 1) / 2 + 1];
            newsum[0] = 0;
            for(int i = 1; i <= n * (n + 1) / 2; i++){
                newsum[i] = newsum[i - 1] + sumofsums.get(i - 1);
            }
            System.out.format("Case #%d:\n", cc + 1);
            for(int i = 0; i < nqueries; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                System.out.println(newsum[end] - newsum[start - 1]);
            }
        }
    }
}
