import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> round = new ArrayList<>();
        while (true){
            if(h2 <= a1){
                round.add(true);
                break;
            }
            if(h1 <= a2){
                round.add(false);
                h1 += (c1 - a2);
            }
            else{
                round.add(true);
                h1 -= a2;
                h2 -= a1;
            }
        }
        System.out.println(round.size());
        for(int i = 0; i < round.size(); i++){
            if(round.get(i))
                System.out.println("STRIKE");
            else System.out.println("HEAL");
        }
    }
}
