import java.util.HashSet;

class clasSolution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> allcodes = new HashSet<>();
        int len = words.length;
        for(int i = 0; i < len; i++){
            String result = "";
            int slen = words[i].length();
            for(int j = 0; j < slen;  j++){
                result += codes[words[i].charAt(j) - 'a'];
            }
            allcodes.add(result);
        }
        return allcodes.size();
    }
}