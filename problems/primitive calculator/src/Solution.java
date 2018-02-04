public class Solution {
    private static int[] dp;
    public static void main(String[] args){
        dp = new int[1000001];
        for(int i = 0; i < 1000001; i++)
            dp[i] = -1;
        dp[1] = 0;
        System.out.print(search(5));
    }
    private static int search(int a){
        if(dp[a] != -1)
            return dp[a];
        else{
            int min = 1000000000;
            if(a % 2 == 0){
                int steps1 = search(a / 2) + 1;
                if(steps1 < min)
                    min = steps1;
            }
            if(a % 3 == 0){
                int steps2 = search(a / 3) + 1;
                if(steps2 < min)
                    min = steps2;
            }
            int steps3 = search(a - 1) + 1;
            if(steps3 < min)
                min = steps3;
            dp[a] = min;
            return min;
        }
    }
}
