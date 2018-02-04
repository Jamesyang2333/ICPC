class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int max = 1;
        int[] sequence = new int[n];
        sequence[0]=1;
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1])
                sequence[i] = sequence[i-1]+1;
            else{
                sequence[i] = 1;
                if(sequence[i-1] > max)
                    max = sequence[i-1];

            }
        }
        if(sequence[n-1] > max)
            max = sequence[n-1];
        return max;

    }
}