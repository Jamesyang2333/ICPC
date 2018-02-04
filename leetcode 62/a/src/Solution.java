public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int p = -1;
        for(int i = 0; i < len; i++){
            if(target < letters[i]){
                p = i;
                break;
            }
        }
        if(p == -1)
            p = 0;
        return letters[p];
    }
    public static void main(String[] args){
        char[] letters = {'c', 'f', 'j'};
        Solution test = new Solution();
        System.out.println(test.nextGreatestLetter(letters, 'k'));
    }
}
