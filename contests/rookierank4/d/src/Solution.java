//Got three TLE for three large cases
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int winningHands(int m, int x, int[] a) {
        // Complete this function
        HashMap<Integer, Integer> dp = new HashMap<>();
        int len = a.length;
        for(int i = 0; i < len; i++){
            HashMap<Integer, Integer> addition = new HashMap<>();
            for(int j: dp.keySet()){
                int rem = (int)(((long)j) * a[i] % m);
                if(addition.containsKey(rem)){
                    addition.put(rem, addition.get(rem) + dp.get(j));
                }
                else addition.put(rem, dp.get(j));
            }
            if(addition.containsKey(a[i] % m)){
                addition.put(a[i] % m, addition.get(a[i] % m) + 1);
            }
            else addition.put(a[i] % m, 1);
            for(int rem : addition.keySet()){
                if(dp.containsKey(rem)){
                    dp.put(rem, dp.get(rem) + addition.get(rem));
                }
                else dp.put(rem, addition.get(rem));
            }
        }
        if(dp.containsKey(x))
            return dp.get(x);
        else return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = winningHands(m, x, a);
        System.out.println(result);
        in.close();
    }
}