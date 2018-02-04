import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean can = false;
            String brand = null;
            int min = 1000000001;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String current = st.nextToken();
                int price = Integer.parseInt(st.nextToken());
                if (check(price)){
                    if(!can)
                        can = true;
                    if(price < min){
                        min = price;
                        brand = current;
                    }
                }
            }
            if(can){
                System.out.println(brand);
            }
            else System.out.println(-1);
        }
        catch (IOException err){}
    }
    private static boolean check(int a){
        boolean can = true;
        int n4 = 0;
        int n7 = 0;
        while(a > 0){
            if(a % 10 != 4 && a % 10 != 7){
                can = false;
                break;
            }
            if(a % 10 == 4)
                n4++;
            else n7++;
            a = a/10;
        }
        if(can)
            if(n4 == n7)
                return true;
        return false;
    }
}
