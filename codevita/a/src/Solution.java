import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] counter;
    private static int[][] digits;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            line = line.replaceAll(","," ");
            StringTokenizer st = new StringTokenizer(line);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            counter = new int[M];
            for(int i = 0; i < M; i++)
                counter[i] = N - 1;
            digits = new int[M][N];
            for(int i = 0; i < M; i++){
                line = br.readLine();
                line = line.replaceAll(",", " ");
                st = new StringTokenizer(line);
                for(int j = 0; j < N; j++){
                    digits[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] result = new int[M * N];
            int count = 0;
            for(int i = 0; i < M * N; i++){
                int current = 0;
                for(int j = 1; j < M; j++){
                    current = select(current, j);
                }
                result[count++] = digits[current][counter[current]];
                counter[current]--;
            }
            boolean allzero = true;
            int length = result.length;
            for(int i = 0; i < length - 1; i++){
                if(allzero){
                    if(result[i] != 0){
                        System.out.print(result[i]);
                        allzero = false;
                    }
                }
                else System.out.print(result[i]);
            }
            System.out.println(result[length - 1]);
        }

        catch(IOException err){}
    }
    private static int select(int a, int b){
        int times = Math.min(counter[a], counter[b]);
        boolean choosea = false;
        boolean chooseb = false;
        int i = 0;
        for(; i <= times; i++){
            if(digits[a][counter[a] - i] > digits[b][counter[b] - i]){
                choosea = true;
                break;
            }
            else if(digits[a][counter[a] - i] < digits[b][counter[b] - i]){
                chooseb = true;
                break;
            }
        }
        if(choosea)
            return a;
        else if(chooseb)
            return b;
        else{
            if(counter[a] > counter[b])
                return a;
            else return b;
        }
    }
}
