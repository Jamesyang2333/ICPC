//TLE
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
    private static int[] A;
    private static long[] dp;
    public static void main(String[] args) {
        dp = new long[40];
        dp[1] = 1;
        for(int i = 2; i < 40; i++){
            dp[i] = (i * dp[i - 1]) % 1000000000;
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        HashMap<Integer, operation2> operation2s = new HashMap<>();
        ArrayList<operation1> operation1s = new ArrayList<>();
        for(int a0 = 0; a0 < m; a0++){
            int opnum = in.nextInt();
            if(opnum == 1)
                operation1s.add(new operation1(a0, in.nextInt() - 1, in.nextInt() - 1));
            else if(opnum == 3)
                operation2s.put(in.nextInt() - 1, new operation2(a0, in.nextInt()));
            else{
                int start = in.nextInt();
                int end = in.nextInt();
                long result = 0;
                for(int i = start - 1; i <= end - 1; i++){
                    if(operation2s.containsKey(i)){
                        operation2 lastchange = operation2s.get(i);
                        int val = lastchange.number;
                        int time = lastchange.time;
                        int count = 0;
                        for(operation1 op : operation1s){
                            if(op.time > time){
                                if(i >= op.start && i <= op.end)
                                    count++;
                            }
                        }
                        result = (result + fac(val + count)) % 1000000000;
                    }
                    else{
                        int count = 0;
                        for(operation1 op : operation1s){
                                if(i >= op.start && i <= op.end)
                                    count++;
                        }
                        result = (result + fac(A[i] + count)) % 1000000000;
                    }
                }
                System.out.println(result);
            }
        }
        in.close();
    }
    private static long fac(int a){
        if(a >= 40)
            return 0;
        else return dp[a];
    }
}
class operation1{
    int time;
    int start;
    int end;
    public operation1(int time, int start, int end){
        this.time = time;
        this.time = start;
        this.end = end;
    }
}
class operation2{
    int time;
    int number;
    public operation2(int time, int number){
        this.time = time;
        this.number = number;
    }
}