import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[6];
        int sum = 0;
        for(int i = 0; i < 6; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }
        boolean can = false;
        if(sum % 2 == 0){
            for(int i = 0; i < 6; i++){
                for(int j = i + 1; j < 6; j++)
                    for(int k = j + 1; k < 6; k++){
                    if(numbers[i] + numbers[j] + numbers[k] == sum / 2)
                        can = true;
                    }
            }
        }
        if(can)
            System.out.println("YES");
        else System.out.println("NO");
        }

        catch (IOException err){}
    }
}
