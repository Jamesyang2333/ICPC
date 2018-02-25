class Solution {
    private int[] rotation = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++){
            if (canrotate(i))
                count++;
        }
        return count;
    }
    public boolean canrotate(int n){
        int[] digits = new int[10];
        int count = 0;
        while(n > 0){
            digits[count] = n % 10;
            if(digits[count] == 3 || digits[count] == 4 || digits[count] == 7)
                return false;
            n = n / 10;
            count++;
        }
        for(int i = 0; i < count; i++){
            if(digits[i] != rotation[digits[i]])
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.rotatedDigits(10));
    }
}