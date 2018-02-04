/*
ID: jamesya4
LANG: JAVA
TASK: agrinet
*/
import java.io.*;
import java.util.*;

class agrinet {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[][] connections = new int[n][n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!st.hasMoreElements())
                    st = new StringTokenizer(f.readLine());
                connections[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        road[] roads = new road[n];
        for(int i = 0; i < n; i++)
            roads[i] = null;
        int size = 0;
        boolean[] isConnected = new boolean[n];
        for(int i = 0; i < n; i++)
            isConnected[i] = false;
        roads[0] = new road(0, 0, 0);
        int result = 0;
        while(size < n){
            int current = 0;
            int min = 100000;
            for(int i = 0; i < n; i++){
                if(!isConnected[i] && roads[i] != null){
                    if(roads[i].dis < min){
                        min = roads[i].dis;
                        current = i;
                    }
                }
            }
            size++;
            result +=  min;
            isConnected[current] = true;
            for(int i = 0; i < n; i++){
                if(!isConnected[i]) {
                    int dis = connections[current][i];
                    if (roads[i] == null)
                        roads[i] = new road(current, i, dis);
                    else if (dis < roads[i].dis)
                        roads[i] = new road(current, i, dis);
                }
            }
        }


        
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
}
class road{
    int from;
    int  to;
    int dis;
    public road(int from, int to, int dis){
        this.dis = dis;
        this.from = from;
        this.to = to;
    }
        }
