import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {
    private static long divisor = 1000000007;
    private static String s;
    private static int[][] count;
    private static long[] factorials = new long[50001];
    private static long[] inversefac = new long[50001];
    static void initialize(String s) {
        // This function is called once before all queries.
        factorials[0] = 1;
        factorials[1] = 1;
        for(int i = 2; i < 50001; i++){
            factorials[i] = (factorials[i - 1] * i) % divisor;
        }
        for(int i = 0; i < 50001; i++){
            inversefac[i] = getinverse(factorials[i]);
        }
        int len = s.length();
        count = new int[26][len];
        for(int i = 0; i < 26; i++)
            count[i][0] = 0;
        count[s.charAt(0) - 'a'][0]++;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < 26; j++)
                count[j][i] = count[j][i - 1];
            count[s.charAt(i) - 'a'][i]++;
        }
    }
    private static long getinverse(long a){
        long result = 1;
        long power = divisor - 2;
        long accu = a;
        while(power > 0){
            if(power % 2 == 1)
                result = (result * accu) % divisor;
            accu = (accu * accu) % divisor;
            power /= 2;
        }
        return result;
    }
    static int answerQuery(int l, int r) {
        int[] subcount = new int[26];
        int len = s.length();
        if(l > 1){
        for(int i = 0; i < 26; i++)
            subcount[i] = count[i][r - 1] - count[i][l - 2];
        }
        else{
            for(int i = 0; i < 26; i++)
                subcount[i] = count[i][r - 1];
        }
        int single = 0;
        for(int i = 0; i < 26; i++){
            if(subcount[i] % 2 == 1)
                single++;
        }
        int sets = 0;
        for(int i = 0; i < 26; i++){
            sets += (subcount[i] / 2);
        }
        long answer = factorials[sets];
        for(int i = 0; i < 26; i++)
            answer = (answer * inversefac[subcount[i] / 2]) % divisor;
        if(single != 0)
            answer = (answer * single) % divisor;
        return (int)answer;
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