public class Solution {
    public int monotoneIncreasingDigits(int N) {
        int len = (int)(Math.log10(N)) + 1;
        int ncopy = N;
        int[] digits = new int[len];
        for(int i = len - 1;  i >= 0;  i--){
            digits[i] = ncopy % 10;
            ncopy /= 10;
        }
        int first = -1;
        for(int i = 0; i < len - 1; i++){
            if(digits[i] > digits[i + 1]){
                first = i;
                break;}
        }
        if(first == -1)
            return N;
        else{
            int change = -1;
            for(int i = first; i >= 1; i--){
                if(digits[i] > digits[i - 1]) {
                    change = i;
                    break;
                }
            }
            if(change == -1)
                change = 0;
            digits[change]--;
            for(int i = change + 1; i < len;  i++){
                digits[i] = 9;
            }
            int result = 0;
            for(int i = 0; i < len; i++){
                result += (int)(digits[i] * Math.pow(10,  len - 1 - i) + 0.5);
            }
            return result;
        }
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.monotoneIncreasingDigits(127768));
    }
}
