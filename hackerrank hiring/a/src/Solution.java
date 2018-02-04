import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        ArrayList<programmer> all = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            all.add(new programmer(name, start, end, i));
        }
        Collections.sort(all);
        System.out.println(all.get(n - 1).name + " " + (all.get(n - 1).end - all.get(n - 1).start));
    }
}
class programmer implements Comparable<programmer>{
    int sequence;
    String name;
    int start;
    int end;
    public programmer(String name, int start, int end, int sequence){
        this.sequence = sequence;
        this.name = name;
        this.start = start;
        this.end = end;
    }
    public int compareTo(programmer a){
        if(start - end == a.start - a.end){
            return a.sequence - sequence;
        }
        else return ((end - start) - (a.end - a.start));
    }
}
