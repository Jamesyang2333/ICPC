import java.io.IOException;

class Solution {
    public int expressiveWords(String S, String[] words) {
        int originlen = S.length();
        int count = 0;
        int nwords = words.length;
        for(int i = 0; i < nwords; i++){
            if(words[i].length() == originlen){
                if(words[i].equals(S))
                    count++;
            }
            else if(words[i].length() < originlen){
                int wlen = words[i].length();
                int pS = 0;
                int pw = 0;
                boolean can = true;
                while (pw < wlen){
                    if(pS == originlen){
                        can = false;
                        break;
                    }
                    int scontinuous = 1;
                    int wcontinuous = 1;
                    for(int j = pw + 1; j < wlen;  j++){
                        if(words[i].charAt(j) == words[i].charAt(pw))
                            wcontinuous++;
                        else break;
                    }
                    for(int j = pS + 1; j < originlen;  j++){
                        if(S.charAt(j) == S.charAt(pS))
                            scontinuous++;
                        else break;
                    }
                    if(!(words[i].charAt(pw) == S.charAt(pS) && ((scontinuous > wcontinuous && scontinuous >= 3) || (scontinuous == wcontinuous)))){
                        can = false;
                        break;
                    }
                    pw = pw + wcontinuous;
                    pS = pS + scontinuous;
                    if(pw == wlen){
                        if(pS != originlen)
                            can = false;
                    }
                }
                if(can)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        Solution test = new Solution();
        String[] words = {"hello", "hi", "helo"};
        System.out.println(test.expressiveWords("heeellooo", words));
    }
}