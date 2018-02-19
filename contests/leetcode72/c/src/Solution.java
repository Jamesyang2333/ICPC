import java.util.ArrayList;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<edge>[] adj = (ArrayList<edge>[]) new ArrayList[n];
        for(int i = 0;  i < n; i++)
            adj[i] = new ArrayList<edge>();
        for(int i = 0; i  < flights.length; i++){
            adj[flights[i][0]].add(new edge(flights[i][0], flights[i][1],  flights[i][2]));
        }
        int[] dis = new int[n];
        boolean[] marked = new boolean[n];
        for(int i = 0; i < n; i++){
            marked[i] = false;
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        for(int i = 0; i <= K; i++){
            for(int j = 0; j < n; j++){
                if(!marked[j] && dis[j] != Integer.MAX_VALUE)
                    marked[j] = true;
            }
            for(int j = 0; j < n; j++){
                if(marked[j]){
                    for(edge next : adj[j]){
                            if(dis[j] + next.price < dis[next.to]){
                                dis[next.to] = dis[j] + next.price;
                            }
                    }
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE)
            return -1;
        return dis[dst];
    }
}
class edge{
    int from;
    int to;
    int price;
    public edge(int from, int to, int price){
        this.from = from;
        this.to = to;
        this.price = price;
    }
}