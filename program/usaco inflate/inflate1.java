/*
ID: jamesya4
LANG: JAVA
TASK: inflate
*/
import java.io.*;
import java.util.*;

class inflate1 {
    private static int[] newtime = new int[170000];
    private static int[] newpoints = new int[170000];
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int maxTime = Integer.parseInt(st.nextToken());
        int qnum = Integer.parseInt(st.nextToken());
        int newproblems = 0;
        for(int i = 0; i < qnum; i++){
            st = new StringTokenizer(f.readLine());
            int points = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= expoent(maxTime / time); j++){
                newtime[newproblems] = time * (1 << (j - 1));
                newpoints[newproblems] = points * (1 << (j - 1));
                newproblems++;
            }
        }
        int result = search(newproblems - 1, maxTime);
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
    private static int search(int problemleft, int timeleft){
        if(timeleft == 0)
            return 0;
        if(problemleft == 0){
            if(newtime[problemleft] <= timeleft)
                return newpoints[problemleft];
            else return 0;
        }
        int previous = search(problemleft - 1, timeleft);
        if(newtime[problemleft] > timeleft)
            return previous;
        else return Math.max(previous, search(problemleft - 1, timeleft - newtime[problemleft]) + newpoints[problemleft]);

    }
    private static int expoent (int n){
        int count = 0;
        while(n > 0){
            n /= 2;
            count++;
        }
        return count;
    }
}
