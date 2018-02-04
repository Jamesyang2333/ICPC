import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final int hh = 1000000007;
    public static long countArray(int n, int k, int x) {
        long result = 0;
        long rem = 1;
        for(int i = 1; i <= n - 2; i++){
            rem = (rem * (k - 1)) % hh;
            if((n - 2 - i) % 2 == 0)
                result = (result + rem) % hh;
            else result = (result + hh - rem) % hh;
        }
        if(x != 1){
            if((n - 2) % 2 ==0){
            result = (result + 1) % hh;
            }
            else result = (result + hh - 1) % hh;}
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }
}