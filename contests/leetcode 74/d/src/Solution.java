class Solution {
    public int preimageSizeFZF(int K) {
        double deno = 5;
        double sum = 0;
        for(int i = 0; i < 15; i++){
            sum += (1 / deno);
            deno *= 5;
        }
        double estimate = K / sum;
        long number = (long)estimate;
        boolean canfind = false;
        while(true){
            if(get5(number) == K){
                canfind = true;
                break;
            }
            else if(get5(number) > K)
                break;
            else number += 5;
        }
        if(canfind)
            return 5;
        else return 0;
    }
    public static int get5(long a){
        int count = 0;
        while(a >= 5){
            count += (a / 5);
            a = a / 5;
        }
        return count;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.print(test.preimageSizeFZF(29));
    }
}