import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args){
        boolean[] firstWin = new boolean[101];
        firstWin[0] = false;
        firstWin[1] = false;
        firstWin[2] = true;
        firstWin[3] = true;
        firstWin[4] = true;
        for(int i = 5; i <= 100; i++){
            if(firstWin[i - 2] && firstWin[i - 3] && firstWin[i - 5]){
                firstWin[i] = false;
            }
            else firstWin[i] = true;
        }
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int ncases = Integer.parseInt(br.readLine());
            for(int i = 0; i < ncases; i++){
                if(firstWin[Integer.parseInt(br.readLine())])
                    System.out.println("First");
                else System.out.println("Second");
            }
        }
        catch (IOException err){}
    }
}
