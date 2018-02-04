//sort edges by the value of v + w + weight when edges have the same weight, which is actually not necessary.
//can choose a random edge when multiple edges have the same weight, multiple different MST could be formed.
//this can be proven by the greedy algorithm for MST
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        edge[] allEdges = new edge[E];
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            allEdges[i] = new edge(v, w, dis);
        }
        Arrays.sort(allEdges);
        QuickUnion components = new QuickUnion(V);
        int count = 0;
        int addedNum = 0;
        int sum = 0;
        while(addedNum < V - 1){
            edge current = allEdges[count];
            if(!components.connected(current.v - 1, current.w - 1)){
                addedNum++;
                components.union(current.v - 1, current.w - 1);
                sum += current.dis;
            }
            count++;
        }
        System.out.println(sum);
    }
}
class edge implements Comparable<edge>{
    int v;
    int w;
    int dis;
    public edge(int v, int w, int dis){
        this.v = v;
        this.w = w;
        this.dis = dis;
    }
    public int compareTo(edge a){
        if(this.dis != a.dis)
            return dis - a.dis;
        else{
            return v + w - a.v - a.w;
        }
    }
}
class QuickUnion{
    int n;
    int[] parent;
    public QuickUnion(int n){
        this.n = n;
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
    }
    private int root(int i){
        int pointer = i;
        while(parent[pointer] != pointer)
            pointer = parent[pointer];
        return pointer;
    }
    public void union(int i, int j){
        int iroot = root(i);
        int jroot = root(j);
        parent[iroot] = jroot;
    }
    public boolean connected(int i, int j){
        return root(i) == root(j);
    }
}