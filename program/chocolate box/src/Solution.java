import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int[] numbers = new int[1000000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int nimSum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
                nimSum = nimSum ^ numbers[j];
            }
            if(nimSum == 0)
                System.out.println(0);
            else{
                int count = 0;
                for(int i = 0; i < n; i++)
                    if((nimSum ^ numbers[i]) < numbers[i])
                        count++;
                System.out.println(count);
            }
    }
}