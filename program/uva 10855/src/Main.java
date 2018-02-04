import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0 && N == 0)
                break;
            char[][] big = new char[N][N];
            char[][] small = new char[n][n];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String row = st.nextToken();
                big[i] = row.toCharArray();
            }
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String row = st.nextToken();
                small[i] = row.toCharArray();
            }
            for(int i = 0; i < 4; i++){
                System.out.print(check(big, small));
                if(i != 3)
                    System.out.print(" ");
                else System.out.println();
                small = rotate(small);
            }
        }
    }
    private static int check(char[][] big, char[][] small){
        int N = big.length;
        int n = small.length;
        int count = 0;
        for(int i = 0; i <= N - n; i++){
            for(int j = 0; j <= N - n; j++){
                boolean can = true;
                for(int i1 = 0; i1 < n; i1++){
                    for(int i2 = 0; i2 < n; i2++){
                        if(small[i1][i2] != big[i + i1][j + i2]){
                            can = false;
                            break;
                        }
                    }
                    if(!can){
                        break;
                    }
                }
                if(can)
                    count++;
            }
        }
        return count;
    }
    private static char[][] rotate(char[][] a){
        int n = a.length;
        char[][] result = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                result[i][j] = a[n - 1 - j][i];
        return result;
    }
}
