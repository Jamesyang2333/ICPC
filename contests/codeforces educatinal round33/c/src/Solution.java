import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static ArrayList<Integer>[] adj;
    private static int[] components;
    private static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int nedges = Integer.parseInt(st.nextToken());
        int[] prices = new int[n];
        adj = (ArrayList<Integer>[]) new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            prices[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < nedges; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        components = new int[n];
        for(int i = 0; i < n; i++)
            components[i] = -1;
        for (int i = 0; i < n; i++){
            if(components[i] == -1){
                count++;
                search(i);
            }
        }
        int[] cost = new int[count];
        for(int i = 0; i < count; i++)
            cost[i] = 2000000000;
        for(int i = 0; i < n; i++){
            if(prices[i] < cost[components[i] - 1])
                cost[components[i] - 1] = prices[i];
        }
        long result = 0;
        for(int i = 0; i < count; i++)
            result += cost[i];
        System.out.println(result);
    }
    private static void search(int current){
        components[current] = count;
        for(int next : adj[current]){
            if(components[next] == -1)
                search(next);
        }
    }
}
