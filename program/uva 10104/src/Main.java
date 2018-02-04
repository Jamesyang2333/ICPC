import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] hh;
    public static void main(String[] args) throws IOException{
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean swap = false;
            if(a < b){
                swap = true;
                int temp = a;
                a = b;
                b = temp;
            }
            hh = new int[2][2];
            hh[0][0] = 1;
            hh[0][1] = 0;
            hh[1][0] = 0;
            hh[1][1] = 1;
            int result = gcd1(a, b);
            if(swap){
                System.out.println(hh[0][1] + " " + hh[0][0] + " " + result);
            }
            else System.out.println(hh[0][0] + " " + hh[0][1] + " " + result);
        }

    }
    private static int gcd1(int a, int b){
        if(b == 0)
            return a;
        int new0 = hh[0][0] - (a / b) * hh[1][0];
        int new1 = hh[0][1] - (a / b) * hh[1][1];
        hh[0][0] = hh[1][0];
        hh[0][1] = hh[1][1];
        hh[1][0] = new0;
        hh[1][1] = new1;
        return gcd1(b, a % b);
    }
}
