public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] numbers = new int[10001];
        for(int i = 0; i < 10001;  i++)
            numbers[i] = 0;
        for(int i = 0; i < nums.length; i++)
            numbers[nums[i]]++;
        int result = 0;
        int start = 0;
        int[] sum1 = new int[10001];
        int[] sum2 = new int[10001];
        for(int i = 0; i < 10001; i++){
            if(numbers[i] > 0){
                start = i;
                int end = -1;
                for(int j = i + 1; j < 10001; j++){
                    if(numbers[j] == 0){
                        end = j - 1;
                        break;
                    }
                }
                sum1[i] = numbers[i] * i;
                sum2[i] = 0;
                for(int j = i + 1; j <= end; j++){
                    sum1[j] = sum2[j - 1] + numbers[j] * j;
                    sum2[j] = Math.max(sum1[j - 1],  sum2[j - 1]);
                }
                result += Math.max(sum1[end], sum2[end]);
                i = end;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] hh = {1,1,1,2,2,2,2,3,3,3,4,5,6,8,8,9,10};
        Solution test = new Solution();
        System.out.println(test.deleteAndEarn(hh));
    }
}
