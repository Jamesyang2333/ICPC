import java.util.List;
import java.util.ArrayList;
public class Solution1 {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<wordstate>[] waiting = (ArrayList<wordstate>[])new ArrayList[26];
        for(int i = 0; i < 26; i++)
            waiting[i] = new ArrayList<wordstate>();
        for(int i = 0; i < words.length; i++){
            waiting[words[i].charAt(0) - 'a'].add(new wordstate(i, 0));
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(!waiting[S.charAt(i) - 'a'].isEmpty()){
                ArrayList<wordstate> temp = (ArrayList<wordstate>) waiting[S.charAt(i) - 'a'].clone();
                waiting[S.charAt(i) - 'a'].clear();
                for(wordstate current  : temp){
                    if(current.pos == words[current.index].length() - 1)
                        count++;
                    else{
                        waiting[words[current.index].charAt(current.pos + 1) - 'a'].add(new wordstate(current.index, current.pos + 1));
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        String s = "abcde";
        String[] words = {"a", "bb", "acd"};
        System.out.print(new Solution1().numMatchingSubseq(s, words));
    }
}
class wordstate{
    int index;
    int pos;
    public wordstate(int index, int pos){
        this.index = index;
        this.pos = pos;
    }
}