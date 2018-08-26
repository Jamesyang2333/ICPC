import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < n; cc++){
            long number = Long.parseLong(new StringTokenizer(br.readLine()).nextToken());
            ArrayList<Byte> sequence = new ArrayList<>();
            while(number > 0){
                sequence.add((byte)(number % 10));
                number = number / 10;
            }
            int len = sequence.size();
            byte[] arraysequence = new byte[len];
            for(int i = 0; i < len; i++){
                arraysequence[i] = sequence.get(i);
            }
            int firstproblem = -1;
            for(int i = 0; i < len - 1; i++){
                if(arraysequence[i] < arraysequence[i + 1]){
                    firstproblem = i;
                }
            }
            if(firstproblem == -1){
                System.out.format("Case #%d: ", cc + 1);
                for(int i = len - 1; i >= 0; i--)
                    System.out.print(arraysequence[i]);
                System.out.println();
            }
            else{
                boolean solved = false;
                for(int i = firstproblem; i < len - 1; i++){
                    if(arraysequence[i] - arraysequence[i + 1] > 0){
                        solved = true;
                        arraysequence[i]--;
                        for(int j = 0; j < i; j++){
                            arraysequence[j] = 9;
                        }
                        break;
                    }
                }
                if(solved){
                    System.out.format("Case #%d: ", cc + 1);
                    for(int i = len - 1; i >= 0; i--)
                        System.out.print(arraysequence[i]);
                    System.out.println();
                }
                else{
                    arraysequence[len - 1]--;
                    for(int j = 0; j < len - 1; j++){
                        arraysequence[j] = 9;
                    }
                    System.out.format("Case #%d: ", cc + 1);
                    boolean prezero = true;
                    for(int i = len - 1; i >= 0; i--){
                        if(prezero){
                            if(arraysequence[i] != 0){
                                prezero = false;
                                System.out.print(arraysequence[i]);
                            }
                        }
                        else System.out.print(arraysequence[i]);
                    }
                    System.out.println();
                }
            }
        }
    }
}
