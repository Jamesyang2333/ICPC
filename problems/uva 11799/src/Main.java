import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0;  i  < ncases; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nclown = Integer.parseInt(st.nextToken());
            int max = 0;
            for(int j = 0; j < nclown; j++){
                int speed = Integer.parseInt(st.nextToken());
                if(speed > max)
                    max = speed;
            }
            System.out.format("Case %d: %d\n", i + 1, max);
        }
    }
}
