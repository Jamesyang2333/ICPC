/*
ID: jamesya4
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.*;

class milk3 {
    private static int[] capacity;
    private static boolean[][][] repeat;
    private static ArrayList<Integer> result = new ArrayList<>();
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        capacity = new int[3];
        for(int i = 0; i < 3; i++){
            capacity[i] = Integer.parseInt(st.nextToken());
        }
        state.capacity = capacity;
        repeat = new boolean[capacity[0] + 1][capacity[1] + 1][capacity[2] + 1];
        for(int i = 0; i <= capacity[0]; i++)
            for(int j = 0; j <= capacity[1]; j++)
                for(int k = 0; k <= capacity[2]; k++)
                    repeat[i][j][k] = false;
        state ini = new state(0, 0, capacity[2]);
        search(ini);
        int[] result1 = new int[result.size()];
        for(int i = 0; i < result1.length; i++){
            result1[i] = result.get(i);
        }
        Arrays.sort(result1);
        for(int i = 0; i < result1.length - 1; i++)
            out.print(result1[i] + " ");
        out.println(result1[result1.length - 1]);
        out.close();                                  // close the output file
    }
    private static void search(state a){
        if(repeat[a.bucket[0]][a.bucket[1]][a.bucket[2]])
            return;
        if(a.bucket[0] == 0)
            result.add(a.bucket[2]);
        repeat[a.bucket[0]][a.bucket[1]][a.bucket[2]] = true;
        for (state x : a.next()){
            search(x);
        }

    }
}

class state{
    public int[] bucket = new int[3];
    public static int[] capacity;
    public state(int i, int j, int k){
        this.bucket[0] = i;
        this.bucket[1] = j;
        this.bucket[2] = k;
    }
    public ArrayList<state> next(){
        ArrayList<state> next = new ArrayList<>();
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
            if(j == i)
                continue;
            if(bucket[i] == 0)
                continue;
            if(bucket[j] == capacity[j])
                continue;
            int pull = capacity[j] - bucket[j];
            int[] newbucket = bucket.clone();
            if(newbucket[i]  > pull) {
                newbucket[j] = capacity[j];
                newbucket[i] = newbucket[i] - pull;
            }
            else{
                newbucket[j] = newbucket[j] + newbucket[i];
                newbucket[i] = 0;
            }
            next.add(new state(newbucket[0], newbucket[1], newbucket[2]));
            }
            return next;
    }
}
