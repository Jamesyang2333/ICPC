/*
ID: jamesya4
LANG: JAVA
TASK: ditch
*/
import java.io.*;
import java.util.*;

class ditch {
    private static boolean[] marked;
    private static flowedege[] edgeTo;
    private static int M;
    private static ArrayList<flowedege>[] adj;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ditch.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ditch.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = (ArrayList<flowedege>[]) new ArrayList[M];
        for(int i = 0; i < M; i++)
            adj[i] = new ArrayList<flowedege>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(f.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cap = Integer.parseInt(st.nextToken());
            flowedege edge = new flowedege(from, to, cap);
            adj[from].add(edge);
            adj[to].add(edge);
        }
        int result = 0;
        while(checkPath()){
            int min = 1000000000;
            for(int v = M - 1; v != 0; v = edgeTo[v].other(v)){
                if(edgeTo[v].residualCap(v) < min)
                    min = edgeTo[v].residualCap(v);
            }
            for(int v = M - 1; v != 0; v = edgeTo[v].other(v)){
                edgeTo[v].addFlow(v, min);
            }
            result += min;
        }
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
    private static boolean checkPath(){
        marked = new boolean[M];
        for(int i = 0; i < M; i++)
            marked[i] = false;
        edgeTo = new flowedege[M];
        ArrayDeque<Integer> states = new ArrayDeque<>();
        states.add(0);
        marked[0] = true;
        while(!states.isEmpty()){
            int current = states.remove();
            for(flowedege nextEdge : adj[current]){
                int neighbor = nextEdge.other(current);
                if(!marked[neighbor] && nextEdge.residualCap(neighbor) > 0){
                    marked[neighbor] = true;
                    edgeTo[neighbor] = nextEdge;
                    states.add(neighbor);
                }
            }
        }
        return marked[M - 1];
    }
}
class flowedege{
    int from;
    int to;
    int capacity;
    int flow;
    public flowedege(int from, int to, int capacity){
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }
    public int other(int v){
        if(v == from)
            return to;
        else
            return from;
    }
    public int residualCap(int v){
        if(v == to)
            return capacity - flow;
        else
            return flow;
    }
    public void addFlow(int v, int add){
        if(v == to)
            flow += add;
        if(v == from)
            flow -= add;
    }
}