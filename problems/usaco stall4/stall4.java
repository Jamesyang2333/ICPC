/*
ID: jamesya4
LANG: JAVA
TASK: stall4
*/
import java.io.*;
import java.util.*;

class stall4 {
    private static int N;
    private static int M;
    private static ArrayList<flowedge>[] adj;
    private static boolean[] marked;
    private static flowedge[] edgeTo;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("stall4.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stall4.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = (ArrayList<flowedge>[]) new ArrayList[M + N + 2];
        for(int i = 0; i < M + N + 2; i++)
            adj[i] = new ArrayList<flowedge>();
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(f.readLine());
            int number = Integer.parseInt(st.nextToken());
            for(int j = 0; j < number; j++){
                int to = Integer.parseInt(st.nextToken());
                flowedge edge = new flowedge(i, N + to, 1);
                adj[i].add(edge);
                adj[N + to].add(edge);
            }
        }
        for(int i = 1; i <= N; i++){
            flowedge edge = new flowedge(0, i, 1);
            adj[0].add(edge);
            adj[i].add(edge);
        }
        for(int i = 1; i <= M; i++){
            flowedge edge = new flowedge(N + i, N + M + 1, 1);
            adj[N + i].add(edge);
        }
        int result = 0;
        while(hasAug()){
            result += 1;
            for(int v = M + N + 1; v > 0; v = edgeTo[v].other(v)){
                edgeTo[v].addflow(v, 1);
            }
        }
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
    private static boolean hasAug(){
        marked = new boolean[M + N + 2];
        for(int i = 0; i < M + N + 2; i++)
            marked[i] = false;
        edgeTo = new flowedge[M + N + 2];
        ArrayDeque<Integer> states = new ArrayDeque<>();
        states.add(0);
        marked[0] = true;
        while (!states.isEmpty()){
            int current = states.remove();
            for(flowedge next : adj[current]){
                int neighbor = next.other(current);
                if(!marked[neighbor] && next.residualcap(neighbor) > 0){
                    marked[neighbor] = true;
                    edgeTo[neighbor] = next;
                    states.add(neighbor);
                }
            }
        }
        return marked[M + N + 1];
    }
}
class flowedge{
    int from;
    int to;
    int cap;
    int flow;
    public flowedge(int from, int to, int cap){
        this.from = from;
        this.to = to;
        this.cap = cap;
        this.flow = 0;
    }
    public int other(int v){
        if(v == from)
            return to;
        else return from;
    }
    public int residualcap(int v){
        if(v == from)
            return flow;
        else return cap - flow;
    }
    public void addflow(int v, int add){
        if(v == to)
            flow += add;
        else flow -= add;
    }
}
