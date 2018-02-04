class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0)
            return true;
        Character[] sequence = new Character[n];
        boolean result = true;
        for(int i = 0; i < n; i++)
            sequence[i] = s.charAt(i);
        for(int i = 0; i < n; i++){
            if(sequence[i] == ')' || sequence[i] == ']' || sequence[i] == '}'){
                for(int j = i-1; j >= 0; j--){
                    if(sequence[j] != null){
                        if ((sequence[i] == ')' && sequence[j] == '(') || (sequence[i] == ']' && sequence[j] == '[') || (sequence[i] == '}' && sequence[j] == '{')){
                            sequence[i] = null;
                            sequence[j] = null;}
                        break;

                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(sequence[i] != null){result = false;}
        }
        return result;
    }
}