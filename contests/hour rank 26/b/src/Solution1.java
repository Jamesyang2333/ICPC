//The line sweep method here is amazing
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
    private static int n;
    private static int m;
    static long maximumPeople(long[] p, long[] x, long[] y, long[] r) {
        // Return the maximum number of people that will be in a sunny town after removing exactly one cloud.
        ArrayList<event> allEvents = new ArrayList<>();
        for(int i = 0; i < n; i++){
            allEvents.add(new event(x[i], 1, i));
        }
        for(int i = 0; i < m; i++){
            allEvents.add(new event(y[i] - r[i], 0, i));
            allEvents.add(new event(y[i] + r[i], 2, i));
        }
        Collections.sort(allEvents);
        HashSet<Integer> currentClouds = new HashSet<>();
        long max = 0;
        long sunny = 0;
        int prev = 0;
        long acc = 0;
        int nevents = allEvents.size();
        for(int i = 0; i < nevents; i++){
            if(allEvents.get(i).type == 1){
                if(currentClouds.isEmpty())
                    sunny += p[allEvents.get(i).no];
                else if(currentClouds.size() == 1){
                    for(int no : currentClouds){
                        if(no == prev){
                            acc += p[allEvents.get(i).no];
                            if(acc > max)
                                max = acc;
                        }
                        else{
                            prev = no;
                            acc = p[allEvents.get(i).no];
                            if(acc > max)
                                max = acc;
                        }
                        break;
                    }
                }
            }
            else if(allEvents.get(i).type == 0){
                currentClouds.add(allEvents.get(i).no);
            }
            else currentClouds.remove(allEvents.get(i).no);
        }
        return sunny + max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/yangyang/Desktop/ICPC/hour rank 26/b/src/input26.txt"));
        //Scanner in = new Scanner("/Users/yangyang/Desktop/ICPC/hour rank 26/b/src/input26.txt");
        n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        long[] p = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = Long.parseLong(st.nextToken());
        }
        long[] x = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = Long.parseLong(st.nextToken());
        }
        m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        long[] y = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int y_i = 0; y_i < m; y_i++){
            y[y_i] = Long.parseLong(st.nextToken());
        }
        long[] r = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int r_i = 0; r_i < m; r_i++){
            r[r_i] = Long.parseLong(st.nextToken());
        }
        long result = maximumPeople(p, x, y, r);
        System.out.println(result);
    }
}
class event implements Comparable<event>{
    long loc;
    int type;
    int no;
    public event(long loc, int type, int no){
        this.no = no;
        this.loc = loc;
        this.type = type;
    }
    public int compareTo(event a){
        if(loc < a.loc)
            return -1;
        if(loc > a.loc)
            return 1;
        else{
            return (type - a.type);
        }
    }
}