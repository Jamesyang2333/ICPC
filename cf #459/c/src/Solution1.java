import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

        private static byte[][] dp;
        private static String line;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
            int len = line.length();
            int[] lbsum = new int[len + 1];
            int[] rbsum = new int[len + 1];
            int[] qsum = new int[len + 1];
            lbsum[0] = 0;
            rbsum[0] = 0;
            qsum[0] = 0;
            for(int i = 0; i < len; i++){
                lbsum[i + 1] = lbsum[i];
                rbsum[i + 1] = rbsum[i];
                qsum[i + 1] = qsum[i];
                if(line.charAt(i) == '('){
                    lbsum[i + 1]++;
                }
                else if(line.charAt(i) == ')')
                    rbsum[i + 1]++;
                else qsum[i + 1]++;
            }
            int[] lbsum1 = new int[len + 1];
            int[] rbsum1 = new int[len + 1];
            int[] qsum1 = new int[len + 1];
            lbsum1[len] = 0;
            rbsum1[len] = 0;
            qsum1[len] = 0;
            boolean[][] can = new boolean[len][len];
            for(int i = 0; i < len; i++){
                for(int j = i + 1; j < len; j += 2){
                    can[i][j] = true;
                }
            }
            for(int i = len - 1; i >= 0; i--){
                lbsum1[i] = lbsum1[i + 1];
                rbsum1[i] = rbsum1[i + 1];
                qsum1[i] = qsum1[i + 1];
                if(line.charAt(i) == '('){
                    lbsum1[i]++;
                }
                else if(line.charAt(i) == ')')
                    rbsum1[i]++;
                else qsum1[i]++;
            }
            for(int i = len - 1; i >= 0; i--){
                boolean resume = true;
                for(int j = i; j >= 0; j --){
                    if(!resume)
                        can[j][i] = false;
                    else{
                        if(lbsum1[j] - lbsum1[i + 1] > (i - j + 1) / 2){
                            can[j][i] = false;
                            resume = false;
                        }
                    }
                }
            }
            for(int i = 0; i < len; i++){
                boolean resume = true;
                for(int j = i; j < len; j++){
                    if(!resume)
                        can[i][j] = false;
                    else{
                        if(rbsum[j + 1] - rbsum[i] > (j - i + 1) / 2){
                            can[i][j] = false;
                            resume = false;
                        }
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < len;  i++){
                for(int  j = i + 1;  j < len;  j += 2){
                    if(can[i][j])
                        count++;
                }
            }
            System.out.println(count);
        }
}
