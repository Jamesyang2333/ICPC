import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < n; i++){
            int l = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            int[] p1 = new int[l];
            int[] p2 = new int[l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < l; j++)
                p1[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < l; j++)
                p2[j] = Integer.parseInt(st.nextToken());
            element[] net = new element[l];
            for(int j = 0; j < l; j++){
                net[j] = new element(p1[j] + p2[j], j);
            }
            byValue comp = new byValue();
            Arrays.sort(net, comp);
            int sum1 = 0;
            int sum2 = 0;
            boolean[] can = new boolean[l];
            for(int j = 0; j < l; j++){
                if(j % 2 == 0)
                    sum1 += p1[net[j].pos];
                else sum2 += p2[net[j].pos];
            }
            if(sum1 == sum2)
                System.out.println("Tie");
            else if(sum1 > sum2)
                System.out.println("First");
            else System.out.println("Second");
        }
    }
}
class element{
    int value;
    int pos;
    public element(int value, int pos){
        this.value = value;
        this.pos = pos;
    }
}
class byValue implements Comparator<element>{
    public int compare(element a, element b){
        return b.value - a.value;
    }
}
