class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            sum[i] += sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }

}
