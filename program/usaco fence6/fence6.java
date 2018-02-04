/*
ID: jamesya4
LANG: JAVA
TASK: fence6
*/
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;

class fence6 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("fence6.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence6.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int nedges = Integer.parseInt(st.nextToken());
        int[] vertices = new int[nedges * 2];
        HashSet<Integer>[][] connect = (HashSet<Integer>[][]) (new HashSet[nedges][2]);
        for(int i = 0; i < nedges; i++){
            connect[i][0] = new HashSet<Integer>();
            connect[i][1] = new HashSet<Integer>();
        }

        int[] length = new int[nedges];
        int count = -1;
        for(int i = 0; i < nedges; i++){
            st = new StringTokenizer(f.readLine());
            int current = Integer.parseInt(st.nextToken());
            length[current - 1] = Integer.parseInt(st.nextToken());
            int line1 = Integer.parseInt(st.nextToken());
            int line2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < line1; j++){
                connect[current - 1][0].add(Integer.parseInt(st.nextToken()) - 1);
            }
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < line2; j++){
                connect[current - 1][1].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }
        for(int i = 0; i < nedges * 2; i++)
            vertices[i] = -1;
        for(int i = 0; i < nedges; i++){
            if(vertices[i * 2] == -1){
                count++;
                vertices[i * 2] = count;
                for(int neighbor : connect[i][0]){
                    if(connect[neighbor][0].contains(i)){
                        vertices[neighbor * 2] = count;
                    }
                    else{
                        vertices[neighbor * 2 + 1] = count;
                    }
                }
            }
            if(vertices[i * 2 + 1] == -1){
                count++;
                vertices[i * 2 + 1] = count;
                for(int neighbor : connect[i][1]){
                    if(connect[neighbor][0].contains(i)){
                        vertices[neighbor * 2] = count;
                    }
                    else{
                        vertices[neighbor * 2 + 1] = count;
                    }
                }
            }
        }
        ArrayList<Toadj>[] adj = (ArrayList<Toadj>[]) new ArrayList[count + 1];
        for(int i = 0; i <= count; i++)
            adj[i] = new ArrayList<Toadj>();
        for(int i = 0; i < nedges; i++){
            if(adj[vertices[i * 2]].isEmpty()){
                adj[vertices[i * 2]].add(new Toadj(length[i], vertices[i * 2 + 1]));
                for(int neighbor : connect[i][0]){
                    if(connect[neighbor][0].contains(i))
                        adj[vertices[i * 2]].add(new Toadj(length[neighbor], vertices[neighbor * 2 + 1]));
                    else adj[vertices[i * 2]].add(new Toadj(length[neighbor], vertices[neighbor * 2]));
                }
            }
            if(adj[vertices[i * 2 + 1]].isEmpty()){
                adj[vertices[i * 2 + 1]].add(new Toadj(length[i], vertices[i * 2]));
                for(int neighbor : connect[i][1]){
                    if(connect[neighbor][0].contains(i))
                        adj[vertices[i * 2 + 1]].add(new Toadj(length[neighbor], vertices[neighbor * 2 + 1]));
                    else adj[vertices[i * 2 + 1]].add(new Toadj(length[neighbor], vertices[neighbor * 2]));
                }
            }
        }
        int result = 1000000;
        for(int i = 0; i < nedges; i++){
            int start = vertices[i * 2];
            int end = vertices[i * 2 + 1];
            int nstartnei = adj[start].size();
            int nendnei = adj[end].size();
            for(int j = 0; j < nstartnei; j++){
                if(adj[start].get(j).neighbor == end){
                    adj[start].remove(j);
                    break;
                }
            }
            for(int j = 0; j < nendnei; j++){
                if(adj[end].get(j).neighbor == start){
                    adj[end].remove(j);
                    break;
                }
            }
            boolean[] checked = new boolean[count + 1];
            for(int j = 0; j <= count; j++)
                checked[j] = false;
            int[] shortest = new int[count + 1];
            for(int j = 0; j <= count; j++)
                shortest[j] = 100000;
            shortest[start] = 0;
            for(int j = 0; j < count; j++){
                int current = 0;
                int min = 1000000;
                for(int k = 0; k <= count; k++){
                    if(!checked[k])
                    if(shortest[k] < min){
                        min = shortest[k];
                        current = k;
                    }
                }
                //stop if the cycle is bound to be larger than the shortest cycle found so far
                if(shortest[current] > result)
                    break;
                if(current == end)
                    break;
                checked[current] = true;
                for(Toadj neighbor : adj[current]){
                    if(!checked[neighbor.neighbor]){
                        if(shortest[current] + neighbor.dis < shortest[neighbor.neighbor])
                            shortest[neighbor.neighbor] = shortest[current] + neighbor.dis;
                    }
                }
            }
            if(shortest[end] + length[i] < result)
                result = shortest[end] + length[i];
            //Putting the two edges back is not necessary as the shortest cycle containing that edge has already be found.
            adj[start].add(new Toadj(length[i], end));
            adj[end].add(new Toadj(length[i], start));
        }

        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
}
class Toadj{
    int dis;
    int neighbor;
    public Toadj(int dis, int neighbor){
        this.dis = dis;
        this.neighbor = neighbor;
    }
}
