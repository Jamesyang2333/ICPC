import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumTime(int[] x) {
        Arrays.sort(x);
        int length = x.length;
        return x[length - 1] - x[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int x_i = 0; x_i < n; x_i++){
                x[x_i] = in.nextInt();
            }
            int result = minimumTime(x);
            System.out.println(result);
        }
        in.close();
    }
}