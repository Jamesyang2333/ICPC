import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(check(i))
                answer.add(i);
        }
        return answer;
    }
    private boolean check(int n){
        boolean result = true;
        int ncopy = n;
        while (ncopy > 0){
            int digit = ncopy % 10;
            if(digit == 0){
                result = false;
                break;
            }
            if(n % digit != 0){
                result = false;
                break;
            }
            ncopy /= 10;
        }
        return result;
    }
    public static void main(String[]){
        Solution test = new Solution();

    }
}