import java.util.ArrayList;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sequence = s.toCharArray();
        int n = sequence.length;
        int max = 0;
        ArrayList<Character> temp = new ArrayList<Character>();
        int p = 0;
        int i = 0;
        while(p < n) {
            while (i < n && !temp.contains(sequence[i])) {
                temp.add(sequence[i]);
                i++;
            }
            int size = temp.size();
            if (size > max)
                max = size;

            if (i != n) {
                int b = temp.indexOf(sequence[i]);
                for (int k = 0; k <= b; k++)
                    temp.remove(0);
                p = b + p + 1;
            } else
                p = i;
        }
        return max;
    }
}