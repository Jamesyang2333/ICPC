class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x==0) return true;
        int bit = 0;
        int p = x;
        boolean result = true;
        while(p > 0){
            p /= 10;
            bit++;
        }
        for(int i = 1; i<=bit/2;i++){

            if((x/(int)(Math.pow(10,i-1)))%10 != (x/(int)(Math.pow(10,bit-i)))%10){
                result = false;
                break;
            }
        }
        return result;
    }
}