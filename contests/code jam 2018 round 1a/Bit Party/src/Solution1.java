import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1 {
    private static cashier[] allcash;
    private static int c;
    private static int b;
    private static int r;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            allcash = new cashier[c];
            for(int i = 0; i < c; i++){
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                allcash[i] = new cashier(m, s, p);
            }
            System.out.format("Case #%d: %d\n", cc + 1, bsearch(0, (long)(2e19)));
        }
    }

    public static long bsearch(long start, long end){
        //System.out.println(start + " " + end);
        long mid = start + (end - start) / 2;
        if(mid ==  start)
            return end;
        else{
            boolean result = check(mid);
            if(result){
                return bsearch(start, mid);
            }
            else return bsearch(mid, end);
        }
    }

    public static boolean check(long time){
        cashiercomp comp = new cashiercomp(time);
        Arrays.sort(allcash, comp);
        long accumulate = 0;
        for(int i = 0; i < r; i++){
            accumulate += Math.min(allcash[i].max, (time - allcash[i].process) / allcash[i].single);
            if(accumulate >= b)
                return true;
        }
        return false;
    }
}
class cashier{
    int max;
    int single;
    int process;
    public cashier(int max, int single, int process){
        this.max = max;
        this.single = single;
        this.process = process;
    }
}
class cashiercomp implements Comparator<cashier>{
    long time;
    public cashiercomp(long time){
        this.time = time;
    }
    public int compare(cashier a, cashier b){
        int aresult = (int)Math.min(a.max, (time - a.process) / a.single);
        int bresult = (int)Math.min(b.max, (time - b.process) / b.single);
        return bresult - aresult;
    }
}
