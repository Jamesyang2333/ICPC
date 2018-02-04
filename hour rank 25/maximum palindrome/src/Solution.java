import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static String s;
    private static BigInteger[] factorials = new BigInteger[110];
    static void initialize(String s) {
        // This function is called once before all queries.
        factorials[0] = BigInteger.ONE;
        factorials[1] = BigInteger.ONE;
        for(int i = 2; i < 110; i++){
            factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    static int answerQuery(int l, int r) {
        int[] count = new int[26];
        int len = s.length();
        for(int i = 0; i < 26; i++)
            count[i] = 0;
        for(int i = l - 1; i <= r - 1; i++){
            count[(s.charAt(i) - 'a')]++;
        }
        int single = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] % 2 == 1)
                single++;
        }
        int sets = 0;
        for(int i = 0; i < 26; i++){
            sets += (count[i] / 2);
        }
        BigInteger total = factorials[sets];
        for(int i = 0; i < 26; i++)
            total = total.divide(factorials[count[i] / 2]);
        if(single != 0)
            total = total.multiply(BigInteger.valueOf(single));
        return (total.mod(BigInteger.valueOf(1000000007)).intValue());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        s = in.next();
        initialize(s);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(l, r);
            System.out.println(result);
        }
        in.close();
    }
}