import java.util.Arrays;
class Solution {
    public int maximumSwap(int num) {
        if (num == 0)
            return 0;
        int n = 0;
        for(int i = 0; i < 8; i++){
            int a = num/((int)Math.pow(10,i));
            if (a >=1 && a<10){
                n = i+1;
                break;
            }
        }
        int[] sequence = new int[n];
        for(int i = n-1; i >= 0; i--)
            sequence[i] = (num/((int)Math.pow(10,n-1-i)))%10;
        int[] copy = Arrays.copyOf(sequence,n);
        Arrays.sort(copy);
        for(int i = 0; i < n; i++){
            if(sequence[i] != copy[n-i-1]){
                int x = copy[n-i-1];
                for(int j = n-1; j > i; j--){
                    if (sequence[j] == x){
                        sequence[j] = sequence[i];
                        sequence[i] = x;
                        break;
                    }
                }
                break;
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++)
            result += sequence[i]*((int)Math.pow(10,n-i-1));
        return result;

    }
}