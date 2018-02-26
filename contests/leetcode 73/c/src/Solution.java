import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String customSortString(String S, String T) {
        int[] order = new int[26];
        for(int i = 0; i < 26; i++)
            order[i] = -1;
        int slen = S.length();
        for(int i = 0; i < slen; i++){
            order[S.charAt(i) - 'a'] = i;
        }
        int tlen = T.length();
        Character[] sequence = new Character[tlen];
        for(int i = 0; i < tlen; i++){
            sequence[i] = T.charAt(i);
        }
        Arrays.sort(sequence, new newcompare(order));
        String result = "";
        for(int i = 0; i < tlen; i++)
            result += String.valueOf(sequence[i]);
        return result;

    }
}
class newcompare implements Comparator<Character>{
    private int[] order;
    public newcompare(int[] order){
        this.order = order;
    }
    public int compare(Character a, Character b){
        return (order[a - 'a'] - order[b - 'a']);
    }
}