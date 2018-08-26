import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static long[][] numbers = new long[19][9];
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < 9; i++){
            numbers[1][i] = 1;
        }
        for(int i = 2; i < 19; i++){
            long[] temp = new long[9];
            for(int j = 0; j < 9; j++)
                temp[j] = 0;
            for(int j = 1; j < 9; j++){
                for(int k = 0; k < 9; k++){
                    temp[k] += numbers[i - 1][(k + 9 - j) % 9];
                }
            }
            for(int j = 0; j < 9; j++){
                numbers[i][j] = numbers[i - 1][j] + temp[j];
            }
        }
        System.out.println(getnum(7));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < n; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long geta = getnum(a);
            long getb = getnum(b);
            long num = getb - geta;
            System.out.format("Case #%d: %d\n", cc + 1, b - a + 1 - num);
        }
    }
    public static long getnum(long a){
        long acopy = a;
        long multiples = 0;
        while(acopy % 9 != 0){
            acopy--;
        }
        multiples = (acopy - 9) / 9 + 1;
        int len = 0;
        acopy = a;
        while(acopy > 0){
            acopy = acopy / 10;
            len++;
        }
        long no9 = 0;
        long no9multiple = 0;
        int sum = 0;
        int i;
        for(i = len; i > 1; i--){
            int digit = (int)((a / (long)(Math.pow(10, i - 1))) % 10);
            for(int j = 0; j < digit; j++){
            no9multiple += numbers[i - 1][(900 - sum - j) % 9];
            for(int k = 0; k < 9; k++)
                no9 += numbers[i - 1][k];
            }
            sum = sum + digit;
            if(digit == 9)
                break;
        }
        if(i == 1){
        for(long a1 = a / 10 * 10; a1 <= a; a1++){
            if(a1 % 9 == 0)
                no9multiple++;
            no9++;
        }
        }
        return (multiples + a - no9 - (multiples - no9multiple));
    }
}
