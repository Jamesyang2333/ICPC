/*
ID: jamesya4
LANG: JAVA
TASK: job
*/
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;

class job {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("job.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("job.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int N = Integer.parseInt(st.nextToken());
        int M1 = Integer.parseInt(st.nextToken());
        int M2 = Integer.parseInt(st.nextToken());
        int[] atime = new int[M1];
        int[] btime = new int[M2];
        for(int count = 0; count < M1 + M2; count++) {
            if (!st.hasMoreTokens())
                st = new StringTokenizer(f.readLine());
            if (count < M1) {
                atime[count] = Integer.parseInt(st.nextToken());
            } else {
                btime[count - M1] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<machine> alla= new PriorityQueue<>();
        for(int i = 0; i < M1; i++){
            alla.add(new machine(i, atime[i]));
        }
        int[] adone = new int[N];
        for(int i = 0; i < N; i++){
            machine current = alla.poll();
            adone[i] = current.endtime;
            alla.add(new machine(current.no, current.endtime + atime[current.no]));
        }
        PriorityQueue<machine> allb= new PriorityQueue<>();
        for(int i = 0; i < M2; i++){
            allb.add(new machine(i, btime[i]));
        }
        int[] bdone = new int[N];
        for(int i = 0; i < N; i++){
            machine current = allb.poll();
            bdone[i] = current.endtime;
            allb.add(new machine(current.no, current.endtime + btime[current.no]));
        }
        int max = 0;
        for(int i = 0; i < N; i++){
            if(adone[i] + bdone[N - 1- i] > max)
                max = adone[i] + bdone[N - 1 - i];
        }
        out.println(adone[N - 1] + " " + max);                           // output result
        out.close();                                  // close the output file
    }
}
class machine implements Comparable<machine>{
    int no;
    int endtime;
    public machine(int no, int time){
        this.no = no;
        this.endtime = time;
    }
    public int compareTo(machine a){
        return this.endtime - a.endtime;
    }
}