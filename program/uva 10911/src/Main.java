import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int[][] students;
    private static int[] pair;
    private static double min = 0;
    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true){
            count++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0)
                break;
            else{
                min = 10000;
                students = new int[N * 2][2];
                for(int i = 0; i < 2 * N; i++){
                    st = new StringTokenizer(br.readLine());
                    st.nextToken();
                    students[i][0] = Integer.parseInt(st.nextToken());
                    students[i][1] = Integer.parseInt(st.nextToken());
                }
                pair = new int[2 * N];
                for(int i = 0; i < 2 * N; i++)
                    pair[i] = -1;
                search(N, 0);
                System.out.format("Case %d: %.2f\n", count, min);
            }
        }
    }
    private static void search(int n, double sum){
        int current = 0;
        for(int i = 0; i < 2 * N; i++){
            if(pair[i] == -1){
                current = i;
                break;
            }
        }
        for(int i = current + 1; i < 2 * N; i++){
            if(pair[i] == -1){
                pair[i] = current;
                pair[current] = i;
                double dis = Math.sqrt(Math.pow(students[i][0] - students[current][0], 2) + Math.pow(students[i][1] - students[current][1], 2));
                if(n == 1){
                    if (sum + dis < min)
                        min = sum + dis;
                }
                else{
                    if(sum + dis < min)
                        search(n - 1, sum + dis);
                }
                pair[i] = -1;
                pair[current] = -1;
            }
        }
    }
}
