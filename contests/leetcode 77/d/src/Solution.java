import java.util.Arrays;

class Solution {
    private int[] arr;
    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);
        arr = A;
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
        }
        int gcd = gcd(sum, A.length);
        int nume = sum / gcd;
        int deno = A.length / gcd;
        for(int i = 1; ; i++){
            if(i * deno > A.length / 2)
                break;
            int target = nume * i;
            if(find(target, 0, i * deno)) {
                return true;
            }
        }
        return false;
    }
    private int gcd(int a,  int b){
        if(b == 0)
            return a;
        else return gcd(b, a % b);
    }
    private boolean find(int target, int index, int remain){
        if(remain == 0) {
            if(target == 0)
                return true;
            else return false;
        }
        if(arr.length - index < remain){
            return false;
        }
        if(arr[index] * remain > target)
            return false;
        if(index == arr.length - 1){
            if(target != arr[index])
                return false;
            else return true;
        }
        if(target >= arr[index]){
            if(find(target - arr[index], index + 1, remain - 1)){
                return true;
            }
        }
        if(find(target, index + 1, remain))
            return true;
        return false;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        int[] a = {1817,3082,8735,9101,2576,3473,9941,5336,8452,2584,2518,3196,1421,8460,6863,6956,3668,17};
        System.out.println(test.splitArraySameAverage(a));
    }
}