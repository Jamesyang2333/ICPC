import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < T; i++) {
            int max = 0;
            int min = 1000000;
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int current = Integer.parseInt(st.nextToken());
                if (current > max)
                    max = current;
                if (current < min)
                    min = current;
                sum += current;
            }
            System.out.format("Case %d: %d\n", i + 1, sum - max - min);
        }
    }
}
