import java.util.ArrayList;
import java.util.List;
class Solution {
    private ArrayList<String> result;
    private int lastindex;
    private char[] sequences;
    public List<String> letterCasePermutation(String S) {
        sequences = S.toCharArray();
        result = new ArrayList<>();
        int len = sequences.length;
        lastindex = -1;
        for(int i = len - 1; i >= 0; i--){
            if((sequences[i] >= 'a' && sequences[i] <= 'z') || (sequences[i] >= 'A' && sequences[i] <= 'Z')){
                lastindex = i;
                break;
            }
        }
        if(lastindex == -1){
            result.add(S);
            return result;
        }
        else {search(0);
        return result;
        }

    }
    public void search(int index){
        if(index == lastindex){
            if(sequences[index] >= 'a' && sequences[index] <= 'z'){
                result.add(String.valueOf(sequences.clone()));
                sequences[index] = (char)(sequences[index] + ('A' - 'a'));
                result.add(String.valueOf(sequences.clone()));
            }
            else {
                result.add(String.valueOf(sequences.clone()));
                sequences[index] = (char)(sequences[index] + ('a' - 'A'));
                result.add(String.valueOf(sequences.clone()));
            }
        }
        else{
            if((sequences[index] >= 'a' && sequences[index] <= 'z') || (sequences[index] >= 'A' && sequences[index] <= 'Z')){
                if(sequences[index] >= 'a' && sequences[index] <= 'z'){
                    search(index + 1);
                    sequences[index] = (char)(sequences[index] + ('A' - 'a'));
                    search(index + 1);
                }
                else {
                    search(index + 1);
                    sequences[index] = (char)(sequences[index] + ('a' - 'A'));
                    search(index + 1);
                }
            }
            else {
                search(index + 1);
            }
        }
    }
}