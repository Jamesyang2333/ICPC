import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] seats = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                if(line.charAt(j) == '.')
                    seats[i][j] = true;
                else seats[i][j] = false;
            }
        }
        ArrayList<Integer> busy = new ArrayList<>();
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!seats[i][j]){
                    busy.add(j);
                }
            }
            int size = busy.size();
            if(size == 0){
                if(m >= k)
                result += (m - k + 1);
            }
            else{
            for(int j = 0; j < size - 1; j++){
                if(busy.get(j + 1) - busy.get(j) - 1 >= k)
                    result += busy.get(j + 1) - busy.get(j) - k;
            }
            if(busy.get(0) >= k)
                result += busy.get(0) - k + 1;
            if(m - 1 - busy.get(size - 1) >= k)
                result += (m - busy.get(size - 1) - k);
            busy.clear();
            }
        }
        if(k != 1){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!seats[j][i]){
                    busy.add(j);
                }
            }
            int size = busy.size();
            if(size == 0){
                if(n >= k)
                result += (n - k + 1);
            }
            else{
            for(int j = 0; j < size - 1; j++){
                if(busy.get(j + 1) - busy.get(j) - 1 >= k)
                    result += busy.get(j + 1) - busy.get(j) - k;
            }
            if(busy.get(0) >= k)
                result += busy.get(0) - k + 1;
            if(n - 1 - busy.get(size - 1) >= k)
                result += (n - busy.get(size - 1) - k);
            busy.clear();
            }
        }}
        System.out.println(result);
    }
}
