import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p1;
        int n = sc.nextInt();
        long p = sc.nextLong();
        if(p >= 0)
            p1 = 1;
        else p1 = -1;
        long q = sc.nextLong();
        long r = sc.nextLong();
        int[] max = new int[n];
        long[] max1 = new long[n];
        long[] max11 = new long[n];
        long[] max2 = new long[n];
        int[] value = new int[n];
        for(int i = 0; i < n; i++)
            value[i] = sc.nextInt();
        max[0] = 0;
        for(int i = 1; i < n; i++){
            if(p1 * value[max[i-1]] < p1 * value[i])
                max[i] = i;
            else max[i] = max[i-1];
        }
        for(int i = 0; i < n; i++){
            max1[i] = value[i] * q + value[max[i]] * p;
        }
        max11[0] = max1[0];
        for(int i = 1; i < n; i++){
            if(max1[i] > max11[i-1])
                max11[i] = max1[i];
            else max11[i] = max11[i-1];
        }
        for(int i = 0; i < n; i++){
            max2[i] = value[i] * r + max11[i];
        }
        Long result = max2[0];
        for(int i = 1; i < n; i++){
            result = Math.max(result, max2[i]);
        }
        System.out.println(result);
    }
}
