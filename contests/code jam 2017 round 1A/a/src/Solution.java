import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nrows = Integer.parseInt(st.nextToken());
            int ncols = Integer.parseInt(st.nextToken());
            byte[][] cake = new byte[nrows][ncols];
            for(int i = 0; i < nrows; i++){
                String line = br.readLine();
                for(int j = 0; j < ncols; j++){
                    if(line.charAt(j) == '?'){
                        cake[i][j] = -1;
                    }
                    else{
                        cake[i][j] = (byte)(line.charAt(j) - 'A');
                    }
                }
            }
            ArrayList<Integer> emptyrows = new ArrayList<>();
            int firstnonempty = -1;
            for(int i = 0; i < nrows; i++){
                int first = -1;
                byte prev = -1;
                for(int j = 0; j < ncols; j++){
                    if(prev == -1){
                        if(cake[i][j] != -1){
                            prev = cake[i][j];
                            first = j;
                        }
                    }
                    else{
                        if(cake[i][j] == -1){
                            cake[i][j] = prev;
                        }
                        else{
                            prev = cake[i][j];
                        }
                    }
                }
                for(int j = 0; j < first; j++){
                    cake[i][j] = cake[i][first];
                }
                if(prev == -1)
                    emptyrows.add(i);
                else {
                    if(firstnonempty == -1)
                        firstnonempty = i;
                }
            }
            for(int row: emptyrows){
                if(row == 0){
                    for(int i = 0; i < ncols; i++){
                        cake[row][i] = cake[firstnonempty][i];
                    }
                }
                else{
                    for(int i = 0; i < ncols; i++){
                        cake[row][i] = cake[row - 1][i];
                    }
                }
            }
            System.out.format("Case #%d:\n", cc + 1);
            for(int i = 0; i < nrows; i++){
                for(int j = 0; j < ncols; j++){
                    System.out.print((char)(cake[i][j] + 'A'));
                }
                System.out.println();
            }
        }
    }
}
