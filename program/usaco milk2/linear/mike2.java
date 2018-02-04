/*
ID: jamesya4
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.util.Arrays;
class milk2{
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        farmer[] all = new farmer[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            all[i] = new farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        bystart x = new bystart();
        Arrays.sort(all, x);
        int end = all[0].end;
        int start = all[0].start;
        ArrayList<farmer> merge= new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(all[i].start <= end)
                end = Math.max(end, all[i].end);
            else {merge.add(new farmer(start, end));
            start = all[i].start;
            end = all[i].end;}
        }
        merge.add(new farmer(start, end));
        int slots = merge.size();
        int max1 = 0;
        for(int i = 0; i < slots; i++)
            max1 = Math.max(max1,merge.get(i).duration);
        int max2 = 0;
        for(int i = 0; i < slots - 1; i++)
            max2 = Math.max(max2, merge.get(i+1).start - merge.get(i).end);
        out.print(max1);
        out.print(" ");
        out.println(max2);
        out.close();                                  // close the output file
    }
}

class farmer{
    public int start;
    public int end;
    public int duration;
    public farmer(int start, int end){
        this.start = start;
        this.end = end;
        this.duration = end - start;
    }
}
class bystart implements Comparator<farmer>{
    public int compare(farmer a, farmer b){
        return a.start - b.start;
    }
}