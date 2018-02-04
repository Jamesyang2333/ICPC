import java.util.Arrays;

public class Solution {
    public int dominantIndex(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int length = nums.length;
        if(copy[length - 1] < 2 * copy[length - 1])
            return -1;
        else{
            for(int i = 0; i < length; i++){
                if(nums[i] == copy[length - 1])
                    return i;
            }
        }
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.);
    }
}
