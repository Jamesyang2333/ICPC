import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int nheaps = Integer.parseInt(br.readLine());
            int nimSum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < nheaps; j++){
                nimSum = nimSum ^ Integer.parseInt(st.nextToken());
            }
            if(nimSum == 0)
                System.out.println("Second");
            else{
                System.out.println("First");
            }
        }
    }
}