class Solution {
    public int bestRotation(int[] A) {

        int max = -1;
        int k = 0;
        for(int i = 0; i < A.length; i++){
            int pairs = check(A, i);
            if(pairs > max){
                max = pairs;
                k = i;
            }
        }
        return k;
    }
    public int check(int[] A, int rot){
        int len = A.length;
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] <= (i - rot + len) % len)
                count++;
        }
        return count;
    }
}