import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Solution {
    private static int height;
    private static BigInteger[] factorial = new BigInteger[32];
    private static HashSet<Long> Answers = new HashSet<>();
    public static void main(String[] args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dim = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        factorial[0] = BigInteger.ONE;
        for(int i = 1; i < 32; i++){
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
        search(dim, height - 1, height - 1, 1);
        int size = Answers.size();
        long[] answer = new long[size];
        int count = 0;
        for(Long a :  Answers) {
            answer[count++] = a;
        }
        Arrays.sort(answer);
        for(int i = 0;  i < size; i++){
            System.out.println(answer[i]);
        }
        }
        catch (IOException err){}
    }
    private static void search(int dim, int rem, int min, long current){
        if(dim == 1){
            Answers.add(current);
        }
        else {for(int i = 1; i < rem && i <= min;  i++) {
            long nextcurrent = current * combination(rem,  i);
            search(dim - 1, rem - i, i, nextcurrent);
        }
        Answers.add(current);
        }
    }
    private static long combination(int n, int k){
        BigInteger ans = factorial[n].divide(factorial[n - k].multiply(factorial[k]));
        long result = ans.longValue();
        return result;

    }
}
