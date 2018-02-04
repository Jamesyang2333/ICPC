/*
ID: jamesya4
LANG: JAVA
TASK: fence
*/
import org.omg.PortableInterceptor.INACTIVE;
/*One really nice thing about this algorithm:
The remaining graph is always a connected graph, so acutally the loop inside the recursive fuction would be run exactly once.
 */
import java.io.*;
import java.util.*;

class fence {
    private static int count = 0;
    private static int nfence;
    private static int path[];
    private static PriorityQueue<Integer>[] adj;
    private static boolean[] intersection;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("fence.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        nfence = Integer.parseInt(st.nextToken());
        path = new int[nfence + 1];
        intersection = new boolean[501];
        for(int i = 0; i < 501; i++)
            intersection[i] = false;
        adj = (PriorityQueue<Integer>[])new PriorityQueue[501];
        for(int i = 0; i < 501; i++)
            adj[i] = new PriorityQueue<Integer>();
        for(int i = 0; i < nfence; i++){
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
            intersection[a] = true;
            intersection[b] = true;
        }
        int min = 0;
        boolean foundMin = false;
        int singleNode = 0;
        int[] single = new int[2];
        for(int i = 0; i < 501; i++){
            if(intersection[i]){
                if(!foundMin){
                    min= i;
                    foundMin = true;}
                if(adj[i].size() % 2 == 1){
                    single[singleNode++] = i;
                }
            }
        }
        if(singleNode == 0)
            search(min);
        else search(single[0]);
        for(int i = 0; i <= nfence; i++)
            out.println(path[nfence - i]);
        out.close();                                  // close the output file
    }
    private static void search(int a){
        if(adj[a].size() == 0) {
            path[count++] = a;
            return;
        }
        //int test = 0;
        while(adj[a].size() > 0){
            //test++;
            int neighbor = adj[a].poll();
            adj[neighbor].remove(new Integer(a));
            search(neighbor);
        }
        //System.out.println(test);
        path[count++] = a;
    }
}
