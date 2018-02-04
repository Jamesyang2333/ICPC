import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int a = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(a % 8 == 0)
                sb.append("Second\n");
            else sb.append("First\n");
        }
        System.out.println(sb.toString());
    }
}