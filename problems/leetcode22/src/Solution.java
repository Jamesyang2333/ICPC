import java.util.List;
import java.util.ArrayList;
class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        int[] position = new int[n];
        for(int i = 0; i < n;i++){
            position[i] = i;
        }
        while(position[0] == 0){
            char[] sequence = new char[2*n];
            for(int i = 0; i < n; i++){
                sequence[position[i]] = '(';
            }
            for(int i = 0; i < 2*n; i++){
                if(sequence[i]!='(')
                    sequence[i] = ')';
            }
            result.add(String.valueOf(sequence));
            position[n-1] += 1;
            for(int i = n-1; i >= 1; i--){
                if(position[i] > 2*i){
                    position[i-1] += 1;
                    for(int j = i; j < n;j++)
                        position[j] = position[i-1]+(j-i+1);
                }
            }

        }
        return result;

    }
}