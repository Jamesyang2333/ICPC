class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int resultHigh = 0;
        int resultLow = 0;
        int n = s.length();
        if(n==0)
            return "";
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                int low = i-1;
                int high = i;
                while(low>=1 && high<n-1){
                    if(s.charAt(low-1) == s.charAt(high+1)){
                        low--;
                        high++;}
                    else {if((high-low)+1>max) {
                        max = high - low + 1;
                        resultHigh = high;
                        resultLow = low;
                    }
                        break;
                    }
                }
                if((high-low)+1>max){
                    max = high-low+1;
                    resultHigh = high;
                    resultLow = low;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(s.charAt(i) == s.charAt(i-2)){
                int low = i-2;
                int high = i;
                while(low>=1 && high<n-1){
                    if(s.charAt(low-1) == s.charAt(high+1)){
                        low--;
                        high++;}
                       else {if((high-low)+1>max) {
                        max = high - low + 1;
                        resultHigh = high;
                        resultLow = low;
                       }
                        break;
                    }
                }
                if((high-low)+1>max){
                    max = high-low+1;
                    resultHigh = high;
                    resultLow = low;
                }
            }
        }
        if(max == 0)
            return s.substring(0,1);
        else return s.substring(resultLow,resultHigh+1);
    }
}