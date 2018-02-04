class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0)
            return "";
        int num = strs[0].length();
        boolean isSame = true;
        for(int i = 0; i < strs[0].length(); i++){
            char com = strs[0].charAt(i);
            for(int j = 1; j < n; j++){
                if(i>=strs[j].length() || strs[j].charAt(i) != com){
                    isSame = false;
                    break;
                }
            }
            if(!isSame){
                num = i;
                break;
            }
        }
        String result = strs[0].substring(0,num);
        return result;
    }
}