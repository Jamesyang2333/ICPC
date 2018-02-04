import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static long longestSequence(long[] a) {
        long result = 0;
        for(int i = 0; i < a.length; i++){
            ArrayList<Long> primefactors = new ArrayList<>();
            result += a[i];
            while(a[i] % 2 == 0){
                a[i] = a[i] / 2;
                primefactors.add((long)2);
            }
            for(int j = 3; j < Math.sqrt(a[i]) + 0.5; j += 2){
                while (a[i] % j == 0){
                    a[i] /= j;
                    primefactors.add((long)j);
                }
            }
            if(a[i] > 1)
                primefactors.add(a[i]);
            int size = primefactors.size();
            //System.out.println(size + "hh");
            if(size != 0)
                result += 1;
            long accu = 1;
            for(int j = 0; j < size - 1; j++){
                accu *= primefactors.get(size - 1 - j);
                //System.out.println(accu);
                result += accu;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}
