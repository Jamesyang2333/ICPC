/*
ID: jamesya4
LANG: JAVA
TASK: milk6
*/
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class milk6 {
    private static ArrayList<flowedge>[] adj;
    private static boolean[] marked;
    private static flowedge[] prev;
    private static int n;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk6.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk6.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        n = Integer.parseInt(st.nextToken());
        int nedges = Integer.parseInt(st.nextToken());
        flowedge[] edges = new flowedge[nedges];
        adj = (ArrayList<flowedge>[]) new ArrayList[n];
        marked = new boolean[n];
        prev = new flowedge[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<flowedge>();
        for(int i = 0; i < nedges; i++){
            st = new StringTokenizer(f.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cap = Integer.parseInt(st.nextToken()) * (nedges + 1) + 1;
            flowedge current = new flowedge(from, to, cap);
            edges[i] = current;
            boolean had = false;
            /*int prevflow = 0;
            for(int i = 0; i < adj[from].size(); i++){
                if(adj[from].get(i).other(from) == to){
                    had = true;
                    prevflow = adj[from].get(i).residualflow(from);
                    adj[from].remove(i);
                }
            }
            if(!had){
                adj[from].add(current);
                adj[to].add(current);
            }
            else{

            }*/
            adj[from].add(current);
            adj[to].add(current);
        }
        Networkflow network = new Networkflow(copyArray(adj, n, n, n, 1), n);
        BigInteger result = network.maxflow();
        out.println(result.divide(BigInteger.valueOf(nedges + 1)).toString() + " " + result.mod(BigInteger.valueOf(nedges + 1)).toString());// output result
        ArrayList<Integer> indices = new ArrayList<>();
        if(nedges <= 100){
        for(int i = 0; i < nedges; i++){
            flowedge current = edges[i];
            ArrayList<flowedge>[] newadj = copyArray(adj, n, current.from, current.to, current.cap);
            Networkflow currentFlow = new Networkflow(newadj, n);
            BigInteger remainingflow = currentFlow.maxflow();
            if(remainingflow.add(BigInteger.valueOf(current.cap)).equals(result)){
                result = remainingflow;
                remove(adj, current.from, current.to, current.cap);
                indices.add(i + 1);
                if(result.equals(BigInteger.ZERO))
                    break;
            }
        }
        for(int i : indices){
            out.println(i);
        }}
        else{
            boolean[] marked = network.marked;
            if(!result.equals(BigInteger.ZERO)){
                for(int i = 0; i < nedges; i++){
                    if(marked[edges[i].from] && (!marked[edges[i].to]))
                        indices.add(i + 1);
                }
                for(int i : indices){
                    out.println(i);
                }
            }
        }
        out.close();                                  // close the output file
    }
    private static void remove(ArrayList<flowedge>[] adj, int from, int to, int cap){
        for(int j = 0; j < adj[from].size(); j++){
            if(adj[from].get(j).to == to && adj[from].get(j).cap == cap){
                adj[from].remove(j);
                break;
            }
        }
        for(int j = 0; j < adj[to].size(); j++){
            if(adj[to].get(j).from == from && adj[to].get(j).cap == cap){
                adj[to].remove(j);
                break;
            }
        }
    }
    private static ArrayList<flowedge>[] copyArray(ArrayList<flowedge>[] adj, int n, int from, int to, int cap){
        ArrayList<flowedge>[] result = (ArrayList<flowedge>[]) new ArrayList[n];
        for(int i = 0; i < n; i++){
            result[i] = new ArrayList<flowedge>();
            if(i == from){
                boolean found = false;
                for(flowedge next : adj[i]){
                    if(!found){
                    if(next.to == to && next.cap == cap)
                        found = true;
                    else
                        result[i].add(new flowedge(next));
                    }
                    else{
                        result[i].add(new flowedge(next));
                    }
                }
            }
            else if(i == to){
                boolean found = false;
                for(flowedge next : adj[i]){
                    if(!found){
                        if(next.from == from && next.cap == cap)
                            found = true;
                        else
                            result[i].add(new flowedge(next));
                    }
                    else{
                        result[i].add(new flowedge(next));
                    }
                }
            }
            else{
                for(flowedge next : adj[i]){
                    result[i].add(new flowedge(next));
                }
            }
        }
        return result;
    }
}
class flowedge{
    int from;
    int to;
    int cap;
    int flow;
    public flowedge(flowedge a){
        this.from = a.from;
        this.to = a.to;
        this.cap = a.cap;
        this.flow = cap;
    }
    public flowedge(int from, int to, int cap){
        this.from = from;
        this.to = to;
        this.cap = cap;
        this.flow = cap;
    }
    public int other(int v){
        if(v == from)
            return to;
        else return from;
    }
    public int residualflow(int v){
        if(v == to)
            return flow;
        else return (cap - flow);
    }
    public void addflow(int v, int add){
        if(v == to){
            flow -= add;
        }
        else flow += add;
    }
}
class Networkflow{
    private ArrayList<flowedge>[] adj;
    public boolean[] marked;
    private flowedge[] prev;
    private int n;
    public Networkflow(ArrayList<flowedge>[] adj, int n){
        this.n = n;
        this.adj = adj;
        marked = new boolean[n];
        prev = new flowedge[n];
    }
    public BigInteger maxflow(){
        BigInteger result = BigInteger.ZERO;
        while (hasAugmentingPath()){
            int min = 1000000000;
            int p = n - 1;
            while(p != 0){
                flowedge now = prev[p];
                if(now.residualflow(p) < min)
                    min = now.residualflow(p);
                p = now.other(p);
            }
            result = result.add(BigInteger.valueOf(min));
            p = n - 1;
            while(p != 0){
                flowedge now = prev[p];
                now.addflow(p, min);
                p = now.other(p);
            }
            for(int i = 0; i < n; i++)
                marked[i] = false;
        }
        return result;
    }
    private boolean hasAugmentingPath(){
        ArrayDeque<Integer> states = new ArrayDeque<>();
        states.add(0);
        marked[0] = true;
        while (!states.isEmpty()){
            boolean found = false;
            int current = states.remove();
            for(flowedge next : adj[current]){
                if(!marked[next.other(current)]){
                    if(next.residualflow(next.other(current)) > 0){
                        marked[next.other(current)] = true;
                        prev[next.other(current)] = next;
                        if(next.other(current) == n - 1){
                            found = true;
                            break;
                        }
                        states.add(next.other(current));
                    }
                }
            }
            if(found)
                break;
        }
        return marked[n - 1];
    }
}