import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i  <  ncases;  i++){
            String line = new StringTokenizer(br.readLine()).nextToken();
            char[] sequences = line.toCharArray();
            int  len = sequences.length;
            int start = 0;
            for(int j = 1; j < len; j++){
                for(int k = 0; k  < len; k++){
                    if(sequences[(start + k) % len] < sequences[(j + k) % len])
                        break;
                    else if(sequences[(start + k) % len] > sequences[(j + k) % len]){
                        start = j;
                        break;
                    }
                }
            }
            for(int j = 0; j < len; j++)
                System.out.print(sequences[(start + j) % len]);
            System.out.println();
        }
    }
}
