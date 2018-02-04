import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<Integer> deadend = new HashSet<>();
        for(int i = 0; i < deadends.length; i++){
            deadend.add(Integer.parseInt(deadends[i]));
        }
        int[] dp = new int[10000];
        for(int i = 0; i < 10000; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        int answer = -1;
        int targetNum = Integer.parseInt(target);
        if(deadend.contains(0))
            return -1;
        if(targetNum == 0){
            return 0;
        }
        ArrayDeque<Integer> states = new ArrayDeque<>();
        states.addLast(0);
        while(!states.isEmpty()){
            boolean found = false;
            int current = states.remove();
            int[] next = transform(current);
            for(int i = 0; i < 8; i++){
                if(!deadend.contains(next[i])){
                if(next[i] == targetNum){
                    answer = dp[current] + 1;
                    found = true;
                    break;
                }
                else{
                    if(dp[next[i]] == -1){
                        states.add(next[i]);
                        dp[next[i]] = dp[current] + 1;
                    }
                }
                }
            }
            if(found)
                break;
        }
        return answer;
    }
    private static int[] transform(int a){
        int[] digits = new int[4];
        for(int i = 0; i < 4; i++){
            digits[i] = a % 10;
            a /= 10;
        }
        int[] result = new int[8];
        for(int i = 0; i < 4; i++){
            digits[i] = (digits[i] + 1) % 10;
            result[2 * i] = change(digits);
            digits[i] = (digits[i] + 8) % 10;
            result[2 * i + 1] = change(digits);
            digits[i] = (digits[i] + 1) % 10;
        }
        return result;
    }
    private static int change(int[] digits){
        int result = 0;
        for(int i = 0; i < 4; i++){
            result += ((int)(Math.pow(10, i)) * digits[i]);
        }
        return result;
    }
    public static void main(String[] args){
        Solution test = new Solution();

    }
}