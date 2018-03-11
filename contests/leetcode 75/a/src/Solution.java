class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length())
            return false;
        else{
            boolean can = false;
            int len = A.length();
            for(int i = 0; i < len; i++){
                if(A.charAt(0) == B.charAt(i)){
                    boolean rotate = true;
                    for(int j = 1; j < len; j++){
                        if(A.charAt(j) != B.charAt((i + j)  % len)){
                            rotate = false;
                            break;
                        }
                    }
                    if(rotate){
                        can = true;
                        break;
                    }
                }
            }
            return can;
        }
    }
}