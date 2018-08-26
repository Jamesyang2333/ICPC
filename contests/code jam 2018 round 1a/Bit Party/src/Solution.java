import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static cashier[] allcash;
    private static boolean[] marked;
    private static long result = Long.MAX_VALUE;
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
            marked = new boolean[c];
            for(int i = 0; i < c; i++)
                marked[i] = false;
            for(int i = 0; i < c; i++){
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                allcash[i] = new cashier(m, s, p);
            }
            result = Long.MAX_VALUE;
            dfs(r);
            System.out.format("Case #%d: %d\n", cc + 1, result);
        }
    }
    private static void dfs(int n){
        if(n == 0){
            long total = 0;
            for(int i = 0; i < c; i++){
                if(marked[i]){
                    total += allcash[i].max;
                }
            }
            if(total >= b){
                int[] started = new int[c];
                for(int i = 0; i < c; i++)
                    started[i] = 0;
                long min = 0;
                for(int i = 0; i < b; i++){
                    long currentmin = Long.MAX_VALUE;
                    int minindex = 0;
                    for(int j = 0; j < c; j++){
                        if(marked[j] && started[j] < allcash[j].max){
                            long expected = Math.max(min, allcash[j].process + allcash[j].single * (started[j] + 1));
                            if(expected < currentmin){
                                currentmin = expected;
                                minindex = j;
                            }
                        }
                    }
                    started[minindex]++;
                    min = currentmin;
                }
                if(min < result)
                    result = min;
            }
        }
        else{
            for(int i = 0; i < c; i++){
                if(!marked[i]){
                    marked[i] = true;
                    dfs(n - 1);
                    marked[i] = false;
                }
            }
        }
    }
}
