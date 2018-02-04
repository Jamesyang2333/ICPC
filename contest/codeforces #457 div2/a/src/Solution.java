import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        time wakeTime = new time(h,  m);
        int y = 0;
        while(true){
            if(wakeTime.check()){
                break;
            }
            else {
                y++;
                wakeTime.back(x);
            }
        }
        System.out.println(y);
    }
}
class time{
    int h;
    int m;
    public time(int h, int m){
        this.h = h;
        this.m = m;
    }
    public void back(int x){
        if(m >= x){
            m = m - x;
        }
        else if(h > 0){
            m = 60 + m - x;
            h = h - 1;
        }
        else{
            m = 60 + m - x;
            h = 23;
        }
    }
    public boolean check(){
        int[] digits = new int[4];
        digits[0] = h / 10;
        digits[1] = h % 10;
        digits[2] = m / 10;
        digits[3] = m % 10;
        for(int i = 0; i < 4; i++){
            if(digits[i] == 7){
                return true;
            }
        }
        return false;
    }
}
