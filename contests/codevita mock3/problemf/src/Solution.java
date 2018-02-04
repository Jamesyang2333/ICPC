import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int result;
        if(n == 0)
            result = 0;
        else{
        int firstIt = 0;
        if(n % 2 == 0)
            firstIt = 2;
        int numIt = 0;
        while(n > 0){
            numIt++;
            n /= 2;
        }
        int multiplier = 0;
        if(numIt == 1){
            multiplier = 1;
        }
        else if(numIt == 2)
            multiplier = 3;
        else{
            multiplier = (3 + ((numIt - 2) % 10) * 8) % 10;
        }
        result = (multiplier * firstIt) % 10;
        }

        System.out.print(result);}
        catch (IOException e){}
    }
}
