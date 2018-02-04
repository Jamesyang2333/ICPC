public class Solution {
    public int kthGrammar(int N, int K) {
        return search(N, K, 0);
    }
    private int search(int N, int k, int ini){
        if(N == 1)
            return ini;
        if(k > (1 << (N - 2))){
            if(ini == 0){
                return search(N - 1, k - (1 << (N - 2)), 1);
            }
            if(ini == 1){
                return search(N - 1, k - (1 << (N - 2)), 0);
            }
        }
        else {
            if(ini == 0){
                return search(N - 1, k , 0);
            }
            if(ini == 1){
                return search(N - 1, k , 1);
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.kthGrammar(1, 1));
    }
}
