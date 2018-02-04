/*
ID: jamesya4
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

class barn1 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int num_board = Integer.parseInt(st.nextToken());
        st.nextToken();
        int num_cow = Integer.parseInt(st.nextToken());
        reverse comp = new reverse();
        PriorityQueue<Integer> gaps = new PriorityQueue<>(comp);
        int[] cow = new int[num_cow];
        for(int i = 0; i < num_cow; i++){
            st = new StringTokenizer(f.readLine());
            cow[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cow);
        for(int i = 1; i < num_cow; i++){
            if(cow[i] - cow[i - 1] != 1){
                gaps.add(cow[i] - cow[i - 1] - 1);
            }
        }
        int size = gaps.size();
        int total = cow[num_cow - 1] - cow[0] + 1;
            for(int i = 0; i < Math.min(num_board - 1, size); i++){
                total -= gaps.poll();
            }
            out.println(total);
     // output result
        out.close();                                  // close the output file
    }
}
class reverse implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return b - a;
    }
}
