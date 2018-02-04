//TLE
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] duration = new int[n];
        for(int i = 0; i < n; i++)
            duration[i] = -1;
        HashMap<Integer, Integer> previous = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!previous.containsKey(A[i])){
                previous.put(A[i], i);
            }
            else{
                int last = previous.get(A[i]);
                if(duration[last] == -1){
                    duration[last] = i - 1;
                    for(int j = 1; j <= last; j++){
                        if(duration[last - j] == -1)
                            duration[last - j] = i - 1;
                        else break;
                    }
                }
                previous.put(A[i], i);
            }
        }
        for(int j = n - 1; j >= 0; j--){
            if(duration[j] == -1)
                duration[j] = n - 1;
            else break;
        }
        /*for(int j = 0; j < n; j++){
            System.out.println(duration[j] + " ");
        }*/
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            int result = 0;
            for(int i = l; i <= r; i++){
                result += (Math.min(duration[i], r) - i + 1);
            }
            System.out.println(result);
        }
        in.close();
    }
}