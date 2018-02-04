import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static int n;
    private static int m;
    private static boolean[] marked;
    private static boolean[] current;
    private static boolean hasCycle;
    private static ArrayDeque<Integer> reversePost;
    private static ArrayList<edge>[] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        byte[] letters = new byte[n];
        String line = br.readLine();
        for(int i = 0; i < n; i++){
            letters[i] = (byte)(line.charAt(i) - 'a');
        }
        adj = (ArrayList<edge>[]) new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<edge>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adj[from].add(new edge(from, to));
        }
        marked = new boolean[n];
        current = new boolean[n];
        for(int i = 0; i < n; i++)
            marked[i] = false;
        for(int i = 0; i < n; i++)
            current[i] = false;
        hasCycle = false;
        for(int i = 0; i < n; i++){
            if(!marked[i])
                dfs(i);
            if(hasCycle)
                break;
        }
        if(hasCycle){
            System.out.println(-1);
            return;
        }
        for(int i = 0; i < n; i++)
            marked[i] = false;
        reversePost = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(!marked[i])
                dfs1(i);
        }
        int[][] dp = new int[n][26];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < 26; j++)
                dp[i][j] = 0;
        for(int v : reversePost){
            dp[v][letters[v]]++;
            for(edge next : adj[v]){
                for(int i = 0; i < 26; i++){
                    dp[next.to][i] = Math.max(dp[v][i], dp[next.to][i]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 26; j++){
            max = Math.max(dp[i][j], max);
            }
    }
    System.out.println(max);
    }
    private static void dfs(int v){
            if(!marked[v]){
                marked[v] = true;
                current[v] = true;
                for(edge next : adj[v]){
                    if(!marked[next.to])
                        dfs(next.to);
                    else{
                        if(current[next.to])
                            hasCycle = true;
                    }
                }
                current[v] = false;
            }
    }
    private static void dfs1(int v){
            if(!marked[v]){
                marked[v] = true;
                for(edge next : adj[v]){
                    if(!marked[next.to])
                        dfs1(next.to);
                }
                reversePost.addFirst(v);
            }
    }
}
class edge{
    int from;
    int to;
    public edge(int from, int to){
        this.from = from;
        this.to = to;
    }
}