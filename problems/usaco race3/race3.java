/*
ID: jamesya4
LANG: JAVA
TASK: race3
*/
import java.io.*;
import java.util.*;

class race3{
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static boolean[] marked;
    private static boolean[] marked1;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("race3.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race3.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st;
        // Get line, break into tokens
        while(true){
            boolean end = false;
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> currentadj = new ArrayList<>();
            while (true){
                int neighbor = Integer.parseInt(st.nextToken());
                if(neighbor == -1){
                    end = true;
                    break;
                }
                if(neighbor == -2)
                    break;
                else currentadj.add(neighbor);
            }
            if(end)
                break;
            adj.add(currentadj);
        }
        int N = adj.size();
        marked = new boolean[N];
        marked1 = new boolean[N];
        ArrayList<Integer> unavoidable = new ArrayList<>();
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N; j++)
                marked[j] = false;
            marked[i] = true;
            dfs(0, marked);
            if(!marked[N - 1]){
                unavoidable.add(i);
            }
        }
        ArrayList<Integer> splits = new ArrayList<>();
        for(int v : unavoidable){
            boolean issplit = true;
            for(int i = 0; i < N; i++)
                marked1[i] = false;
            dfs(v, marked1);
            for(int j = 0; j < N; j++)
                marked[j] = false;
            marked[v] = true;
            dfs(0, marked);
            for(int i = 0; i < N; i++){
                if(marked[i] && marked1[i] && i != v){
                issplit = false;
                break;
                }
            }
            if(issplit)
                splits.add(v);
        }
        if(!unavoidable.isEmpty()){
            out.print(unavoidable.size() + " ");
        for(int i = 0; i < unavoidable.size(); i++){
            if(i != unavoidable.size() - 1)
                out.print(unavoidable.get(i) + " ");
            else out.println(unavoidable.get(i));
        }
        }
        else out.println(0);
        if(!splits.isEmpty()){
        out.print(splits.size() + " ");
        for(int i = 0; i < splits.size(); i++){
            if(i != splits.size() - 1)
                out.print(splits.get(i) + " ");
            else out.println(splits.get(i));
        }
        }
        else out.println(0);

        out.close();                                  // close the output file
    }
    private static void dfs(int v, boolean[] marked){
        marked[v] = true;
        for(int neighbor : adj.get(v)){
            if(!marked[neighbor])
                dfs(neighbor, marked);
        }
    }
}
