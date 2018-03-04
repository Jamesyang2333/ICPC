class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length;
        int[] dp = new  int[len];
        int lastmax = -1;
        if(A[0] <= R && A[0] >= L)
            dp[0] = 1;
        else{
            if(A[0] > R)
                lastmax = 0;
            dp[0] = 0;
        }
        for(int i = 1; i < len; i++){
            if(A[i] <= R && A[i] >= L)
                dp[i] = i - lastmax;
            else if(A[i] > R){
                dp[i] = 0;
                lastmax = i;
            }
            else dp[i] = dp[i - 1];
        }
        int result = 0;
        for(int i = 0; i < len; i++)
            result += dp[i];
        return result;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        int[] A = {73, 55,  36, 5, 55, 14,  9, 7, 72, 52};
        System.out.print(test.numSubarrayBoundedMax(A, 32, 69));
    }
}