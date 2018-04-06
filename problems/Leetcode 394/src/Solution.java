import java.io.IOException;

class Solution {
    public String decodeString(String s) {
        return recurdecode(s);
    }
    public int[] getcloseintdex(String a){
        int len = a.length();
        int num = -1;
        int start = -1;
        int end = -1;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(Character.isDigit(a.charAt(i))){
                if(num == -1)
                    num = i;
            }
            else if(a.charAt(i) == '['){
                if(start == -1)
                    start = i;
                count++;
            }
            else if(a.charAt(i) == ']'){
                if(count == 1){
                    end = i;
                    break;
                }
                else count--;
            }
        }
        int[] result = new int[3];
        result[0] = start;
        result[1] = end;
        result[2] = num;
        return result;
    }
    public String recurdecode(String a){
        int[] pos = getcloseintdex(a);
        if(pos[0] == -1)
            return a;
        else{
            int n = Integer.parseInt(a.substring(pos[2], pos[0]));
            String repeat = a.substring(0, pos[2]);
            String recurresult = recurdecode(a.substring(pos[0] + 1, pos[1]));
            for(int i = 0; i < n; i++)
                repeat += recurresult;
            if(pos[1] != a.length() - 1){
                repeat += recurdecode(a.substring(pos[1] + 1));
            }
            return repeat;

        }
    }
    public static void main(String[] args) throws IOException{
        Solution test = new Solution();
        String s = "2[abc]3[cd]ef";
        System.out.println(test.decodeString(s));
    }
}