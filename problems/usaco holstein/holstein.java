/*
ID: jamesya4
LANG: JAVA
TASK: holstein
*/
import java.io.*;
import java.util.*;

class holstein {
    private static int numFeed;
    private static int[] requirement;
    private static int numVit;
    private static int[][] feed;
    private static int min = 15;
    private static boolean[] choice;
    private static boolean[] answer;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        numVit = Integer.parseInt(st.nextToken());
        requirement = new int[numVit];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < numVit; i++){
            requirement[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        numFeed = Integer.parseInt(st.nextToken());
        feed = new int[numFeed][numVit];
        choice = new boolean[numFeed];
        for(int i = 0; i < numFeed; i++)
            choice[i] = false;
        for(int i = 0; i < numFeed; i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < numVit; j++)
                feed[i][j] = Integer.parseInt(st.nextToken());
        }
        search(0, 0);

        
        out.print(min);
        for(int i = 0; i < numFeed; i++)
            if(answer[i])
                out.print(" " + (i + 1));
        out.println();// output result
        out.close();                                  // close the output file
    }
    private static void search(int n, int count){
        if(n == numFeed - 1){
            boolean enough = true;
            for(int i = 0; i < numVit; i++)
                if(feed[n][i] < requirement[i])
                    enough = false;
            if(!enough)
                return;
            else {
                count++;
                if(count < min){
                    min = count;
                    choice[n] = true;
                    answer = choice.clone();
                    choice[n] = false;
                }
                count--;
            }
        }
        else{
            boolean enough = true;
            for(int i = 0; i < numVit; i++)
                if(feed[n][i] < requirement[i])
                    enough = false;
            if(!enough){
                for(int i = 0; i < numVit; i++)
                    requirement[i] -= feed[n][i];
                count++;
                choice[n] = true;
                search(n + 1, count);
                count--;
                choice[n] = false;
                for(int i = 0; i < numVit; i++)
                    requirement[i] += feed[n][i];
                search(n + 1, count);
            }
            else {
                if(count + 1 < min){
                    min = count + 1;
                    choice[n] = true;
                    answer = choice.clone();
                    choice[n] = false;
                    return;
                }
            }
        }
    }
}
