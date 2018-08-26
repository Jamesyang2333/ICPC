import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxshield = Integer.parseInt(st.nextToken());
            String instruction = st.nextToken();
            int[] anaresult = analysis(instruction);
            if(anaresult[0] > maxshield)
                System.out.format("Case #%d: IMPOSSIBLE\n", cc + 1);
            else if(anaresult[1] <= maxshield)
                System.out.format("Case #%d: 0\n", cc + 1);
            else{
                int hurt = anaresult[1];
                char[] sequences = instruction.toCharArray();
                int count = 0;
                while(true){
                    count++;
                    int[] mov = move(sequences);
                    sequences[mov[0]] = 'S';
                    sequences[mov[0] + 1] = 'C';
                    hurt -= (mov[1] / 2);
                    if(hurt <= maxshield)
                        break;
                }
                System.out.format("Case #%d: %d\n", cc + 1, count);
            }
        }
    }
    private static int[] analysis (String instruction){
        int[] result = new int[3];
        int len = instruction.length();
        result[0] = 0;
        result[1] = 0;
        int accu = 1;
        for(int i = 0; i < len; i++){
            if(instruction.charAt(i) == 'S'){
                result[1] += accu;
                result[0] ++;
            }
            else{
                accu *= 2;
            }
        }
        return result;
    }
    private static int[] move(char[] instruction){
        int[] result = new int[2];
        int len = instruction.length;
        result[0] = 0;
        result[1] = 1;
        int lasts = 0;
        for(int i = len - 1; i >= 0; i--){
            if(instruction[i] == 'S'){
                lasts = i;
                break;
            }
        }
        for(int i = 0; i < lasts; i++){
            if(instruction[i] == 'C'){
                result[1] *= 2;
                result[0] = i;
            }
        }
        return result;
    }
}
