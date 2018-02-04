import java.util.HashMap;
import java.util.Map;

class MagicDictionary {
    HashMap<String, Integer> dic;
    /** Initialize your data structure here. */
    public MagicDictionary() {
    dic = new HashMap<String, Integer>(100);
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        int n = dict.length;
        for (int i=0; i<n; i++){
            dic.put(dict[i],dict[i].length());
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word == null)
            return false;
        int len = word.length();
        if (len == 0)
            return false;
        if(dic.containsValue(len)) {
            for (Map.Entry<String, Integer> item : dic.entrySet()) {
                String key = item.getKey();
                if(item.getValue() == len){
                    int dif = 0;
                    for(int i = 0; i < len; i++){
                        if(word.charAt(i) != key.charAt(i))
                            dif++;
                    }
                    if (dif == 1)
                        return true;
                }
            }
        }
        return false;

    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */