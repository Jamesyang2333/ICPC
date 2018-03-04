//TLE
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int len = S.length();
        int count = 0;
        int nStrings = words.length;
        HashSet<Character> allchar = new HashSet<>();
        for(int i = 0; i < len; i++)
            allchar.add(S.charAt(i));
        for(int i = 0; i < nStrings; i++){
            boolean containall = true;
            for(int j = 0; j < words[i].length(); j++){
                if(!allchar.contains(words[i].charAt(j))){
                containall = false;
                break;
                }
            }
            if(!containall)
                continue;
            int counter1 = 0;
            int counter2 = 0;
            for(; counter1 < len; counter1++){
                if(S.charAt(counter1) == words[i].charAt(counter2)){
                    counter2++;
                    if(counter2 == words[i].length()){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        String s = "abcde";
        String[] words = {"a", "bb", "acd"};
        System.out.print(new Solution().numMatchingSubseq(s, words));
    }
}