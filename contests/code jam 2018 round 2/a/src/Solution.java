import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] balls = new int[n];
            for(int i = 0; i < n; i++){
                balls[i] = Integer.parseInt(st.nextToken());
            }
            if(balls[0] == 0 || balls[n - 1] == 0){
                System.out.format("Case #%d: IMPOSSIBLE\n", cc + 1);
                continue;
            }
            col[] cols = new col[n];
            for(int i = 0; i < n; i++)
                cols[i] = new col();
            int p = 0;
            for(int i = 0; i < n; i++){
                if(balls[i] == 0)
                    continue;
                int start = p;
                int end = p + balls[i] - 1;
                if(start >= i){
                    for(int j = end; j >= i + 1; j--){
                        if(cols[j].max == end - j + 1){
                            System.out.println("confilts");
                        }
                        if(end - j + 1 > cols[j].max)
                            cols[j].max = end - j + 1;
                        cols[j].allramps.add(new ramp(end - j + 1, true));
                    }
                }
                else if(i >= end){
                    for(int j = start; j <= i - 1; j++){
                        if(cols[j].max == j - start + 1){
                            System.out.println("confilts");
                        }
                        if(j - start + 1 > cols[j].max)
                            cols[j].max = j - start + 1;
                        cols[j].allramps.add(new ramp(j - start + 1, false));
                    }
                }
                else{
                    for(int j = end; j >= i + 1; j--){
                        if(cols[j].max == end - j + 1){
                            System.out.println("confilts");
                        }
                        if(end - j + 1 > cols[j].max)
                            cols[j].max = end - j + 1;
                        cols[j].allramps.add(new ramp(end - j + 1, true));
                    }
                    for(int j = start; j <= i - 1; j++){
                        if(cols[j].max == j - start + 1){
                            System.out.println("confilts");
                        }
                        if(j - start + 1 > cols[j].max)
                            cols[j].max = j - start + 1;
                        cols[j].allramps.add(new ramp(j - start + 1, false));
                    }
                }
                p = end + 1;
                if(p == n - 1)
                    break;
            }
            int max = 0;
            for(int i = 0; i < n; i++){
                if(cols[i].max > max)
                    max = cols[i].max;
            }
            System.out.format("Case #%d: %d\n", cc + 1, max + 1);
            char[][] answer = new char[max + 1][n];
            for(int i = 0; i <= max; i++){
                for(int j = 0; j < n; j++){
                    answer[i][j] = '.';
                }
            }
            for(int i = 0; i < n; i++){
                for(ramp a : cols[i].allramps){
                    if(a.left){
                        answer[a.height - 1][i] = '/';
                    }
                    else{
                        answer[a.height - 1][i] = '\\';
                    }
                }
            }
            for(int i = 0; i <= max; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(answer[i][j]);
                }
                System.out.println();
            }
        }
    }
}
class col{
    int max;
    ArrayList<ramp> allramps;
    public col(){
        allramps = new ArrayList<>();
        this.max = 0;
    }
}
class ramp{
    int height;
    boolean left;
    public ramp(int height, boolean left){
        this.height = height;
        this.left = left;
    }
}