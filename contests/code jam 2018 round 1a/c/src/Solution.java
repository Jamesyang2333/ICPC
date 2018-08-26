import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            int origin = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ncake = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            cake[] allcakes = new cake[ncake];
            for(int i = 0; i < ncake; i++){
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                allcakes[i] = new cake(w, h);
                origin += ((w + h) * 2);
            }
            max -= origin;
            if(max == 0){
                double result = origin;
                System.out.format("Case #%d: %f\n", cc + 1, result);
                continue;
            }
            ArrayList<range> allranges = new ArrayList<>();
            for(int i = 0; i < ncake; i++){
                double from = 2 * (double)(Math.min(allcakes[i].h, allcakes[i].w));
                double end = 2 * Math.sqrt(allcakes[i].h * allcakes[i].h + allcakes[i].w * allcakes[i].w);
                int len = allranges.size();
                for(int j = 0; j < len; j++){
                    range x = allranges.get(j);
                    allranges.add(new range(x.from + from, x.end + end));
                }
                allranges.add(new range(from, end));
                Collections.sort(allranges);
                len = allranges.size();
                int p = 0;
                for(int j = 0; j < len - 1; j++){
                    if(allranges.get(p).end >= allranges.get(p + 1).from){
                        allranges.get(p).merge(allranges.get(p + 1));
                        allranges.remove(p + 1);
                    }
                    else{
                        p++;
                    }
                }
                System.out.println(allranges.size());
            }
            int len = allranges.size();
            double maxresult = 0;
            for(int i = 0; i < len; i++){
                if(allranges.get(i).from > max)
                    break;
                else{
                    if(allranges.get(i).end >= max){
                        maxresult = max;
                        break;
                    }
                    else{
                        maxresult = allranges.get(i).end;
                    }
                }
            }
            System.out.format("Case #%d: %f\n", cc + 1, origin + maxresult);
        }
    }
}
class range implements Comparable<range>{
    double from;
    double end;
    public range(double from, double end){
        this.from = from;
        this.end = end;
    }
    public int compareTo(range a){
        if(from < a.from)
            return -1;
        else if(from == a.from)
            return 0;
        else return 1;
    }
    public void merge(range b){
        this.end = Math.max(this.end, b.end);
    }
}
class cake{
    int w;
    int h;
    public cake(int w, int h){
        this.w = w;
        this.h = h;
    }
}