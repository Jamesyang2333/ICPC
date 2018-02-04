import java.math.BigInteger;

public class test {
    private static BigInteger[] factorial = new BigInteger[101];
    public static void main(String[] args){
        factorial[0] = BigInteger.ONE;
        for(int i = 1; i < 101; i++){
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
        for(int i = 1; i < 32; i++)
            for(int j = 0; j <= i; j++)
                if(combination1(i, j) != combination2(i, j))
                    System.out.println(i + " " + j);
    }
    private static long combination1(int n, int k){
        BigInteger ans = factorial[n].divide(factorial[n - k].multiply(factorial[k]));
        long result = ans.longValue();
        return result;

    }
    private static long combination2(int n, int k){
        if(k > n - k)
            k = n - k;
        int[] product = new int[n - k];
        for(int i = 0; i < k; i++){
            product[i] = n - i;
        }
        for(int j = k; j > 1; j--) {
            int copy = j;
            for(int i = 0; i < k; i++){
                if(product[i] % copy == 0) {
                    product[i] /= copy;
                    break;
                }
                if (product[i] != 1 && copy % product[i] == 0){
                    copy /= product[i];
                    product[i] = 1;
                }
            }
        }
        long result = 1;
        for(int i = 0;  i < k; i++)
            result *= product[i];
        return result;

    }
}
