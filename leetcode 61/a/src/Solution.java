//tried the worst case n ^ 2 still quiet fast
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] days = new int[len];
        int[] max = new int[len];
        int[] nextwarm = new int[len];
        max[len - 1] = temperatures[len - 1];
        for(int i = len - 2;  i >= 0;  i--)
            max[i] = Math.max(max[i + 1],  temperatures[i]);
        if(max[1] < temperatures[0])
            days[0] = 0;
        else{
        for(int i = 1; i < len; i++){
            if (temperatures[i] > temperatures[0]){
                days[0] = i;
                nextwarm[0] = temperatures[i];
                break;
            }
        }
        }
        for(int i = 1; i < len - 1; i++){
            if(temperatures[i] > max[i + 1])
                days[i] = 0;
            else{
                if(days[i - 1] > 1){
                    if(temperatures[i] >= temperatures[i - 1] && temperatures[i] <  nextwarm[i - 1]){
                        days[i] = days[i - 1] - 1;
                        nextwarm[i] = nextwarm[i - 1];
                        continue;
                    }
                }
                for(int j = i + 1; j < len; j++){
                    if(temperatures[j] > temperatures[i]){
                        days[i] = j - i;
                        nextwarm[i] = temperatures[j];
                        break;
                    }
                }
            }
        }
        return days;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        int[] hh = new int[30001];
        for(int i = 0; i < 30000; i++)
            hh[i] = 30000 - i;
        hh[30000] = 100000;
        int[] result = test.dailyTemperatures(hh);
        for(int i = 0;  i < result.length; i++)
        System.out.println(result[i]);
    }
}
