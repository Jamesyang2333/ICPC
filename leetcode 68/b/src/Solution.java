class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int length = S.length();
        for(int i = 0; i < 26; i++)
            count[i] = 0;
        for(int i = 0; i < length; i++){
            count[S.charAt(i) - 'a']++;
        }
        int max = 0;
        int maxLetter = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > max){
                max = count[i];
                maxLetter = i;
            }
        }
        String result = "";
        if(length % 2 == 0)
            if(max > length / 2)
                return result;
        if(length % 2 == 1)
            if(max > (length + 1) / 2)
                return result;
        char[] sequence = new char[length];
        for(int i = 0; i < max; i++){
            sequence[i * 2] = (char)(maxLetter + 'a');
        }
        int counter = max * 2 - 2;
        for(int i = 0; i < 26; i++){
            if(i != maxLetter){
                for(int j = 0; j < count[i]; j++){
                if(counter == length - 2 || counter == length - 1)
                    counter = 1;
                else counter += 2;
                sequence[counter] = (char)(i + 'a');
                }
            }
        }
        return String.valueOf(sequence);
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.reorganizeString("aaab"));
    }
}