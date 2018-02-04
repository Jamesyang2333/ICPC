import java.util.ArrayList;

public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<edge>[] adj = (ArrayList<edge>[])new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<edge>();
        int nedges = times.length;
        for(int i = 0; i < nedges; i++){
            adj[times[i][0]].add(new edge(times[i][0], times[i][1], times[i][2]));
        }
        int[] dis = new int[N + 1];
        boolean[] checked = new boolean[N + 1];
        for(int i = 0; i <= N; i++)
            checked[i] = false;
        for(int i = 0; i <= N; i++)
            dis[i] = 10000000;
        dis[K] = 0;
        for(int i = 0; i < N; i++){
            int current = -1;
            int min = 10000000;
            for(int j = 1; j <= N; j++){
                if(!checked[j])
                if(dis[j] < min){
                    min = dis[j];
                    current = j;
                }
            }
            if(current == -1)
                break;
            checked[current] = true;
            for(edge inc : adj[current]){
                if (!checked[inc.end]){
                    if(dis[current] + inc.dis < dis[inc.end])
                        dis[inc.end] = dis[current] + inc.dis;
                }
            }
        }
        int max = 0;
        for(int j = 1; j <= N; j++){
            if(dis[j] > max)
                max = dis[j];
        }
        if(max == 10000000)
            return  -1;
        else return max;
    }
    public static void main(String[] args){
        int[][] times = {{2,1,1}, {2,3,1},{3,4,1}};
        Solution test = new Solution();
        System.out.println(test.networkDelayTime(times, 4, 2));
    }
}
class edge{
    int start;
    int end;
    int dis;
    public edge(int start, int end, int dis){
        this.start = start;
        this.end = end;
        this.dis = dis;
    }
}
