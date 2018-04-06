class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        if(S == null){
            int[] result = new int[2];
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int count = 0;
        int len = S.length();
        int currentlen = 0;
        for(int i = 0; i < len; i++){
            if(currentlen + widths[S.charAt(i) - 'a'] <= 100){
                currentlen = widths[S.charAt(i) - 'a'] + currentlen;
            }
            else{
                count++;
                currentlen = widths[S.charAt(i) - 'a'];
            }
        }
        int[] result = new int[2];
        result[0] = count + 1;
        result[1] = currentlen;
        return result;
    }
}