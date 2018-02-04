import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            int trees = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int nimsum = 0;
            for(int j = 0; j < trees; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int nodes = Integer.parseInt(st.nextToken());
                if(nodes % 2 == 1){
                    nimsum = nimsum ^ 1;
                }
                else {
                    if(nodes != 2)
                        nimsum = nimsum ^ 2;}
            }
            if(nimsum == 0)
                System.out.println("BEN");
            else System.out.println("BOB");
        }
    }
}
