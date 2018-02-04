class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] maxArray = new int[n];
        int[] order = new int[n];
        maxArray[0] = 1;
        order[0] = 1;
        int realmax = 1;
        for(int i =1;i<n;i++){
            int max = 1;
            int maxno = 1;
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    if(maxArray[j]+1 > max){
                        max = maxArray[j] + 1;
                        maxno = order[j];
                    }
                    else if(maxArray[j]+1 == max)
                        maxno += order[j];
                }
            }
            maxArray[i] = max;
            if(max > realmax)
                realmax = max;
            order[i] = maxno;
        }
        int x = 0;
        for(int i=0;i<n;i++)
            if(maxArray[i] == realmax){
            x += order[i];
            }
            return x;
    }
}