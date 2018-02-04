import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int v3 = Integer.parseInt(st.nextToken());
        int vm = Integer.parseInt(st.nextToken());
        boolean can = true;
        if(vm > 2 * v3){
            can = false;
        }
        else{
            if(v3 > 2 * vm)
                can = false;
            else{
                if(vm >= v2)
                    can = false;
            }
        }
        if(can){
            System.out.println(2 * v1);
            System.out.println(2 * v2);
            System.out.println(Math.max(vm, v3));
        }
        else System.out.println(-1);
    }
}
