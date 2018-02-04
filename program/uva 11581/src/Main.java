import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] xmove = {0, 0, 1, -1};
    private static int[] ymove = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < n; i++){
            br.readLine();
            boolean[][] grid = new boolean[3][3];
            for(int j = 0; j < 3; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int line = Integer.parseInt(st.nextToken());
                for(int k = 0; k < 3; k++){
                    int current = line % 10;
                    if(current == 1)
                        grid[j][2 - k] = true;
                    else grid[j][2 - k] = false;
                    line /= 10;
                }
            }
            int[] states = new int[512];
            for(int j = 0; j < 512; j++){
                states[j] = -1;
            }
            int count = 0;
            int result = 0;
            while (true){
                int number = toIndex(grid);
                //System.out.println(number);
                if(states[number]== -1)
                    states[number] = count;
                else{
                    result = states[number] - 1;
                    break;
                }
                count++;
                grid = transform(grid);
            }
            System.out.println(result);
        }
    }
    private static int toIndex(boolean[][] grid){
        int count = 8;
        int result = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j])
                    result += (1 << count);
                count--;
            }
        }
        return result;
    }
    private static boolean[][] transform(boolean[][] grid){
        boolean[][] result = new boolean[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int sum = 0;
                for(int k = 0; k < 4; k++){
                    int newx = i + xmove[k];
                    int newy = j + ymove[k];
                    if(newx >= 0 && newy >= 0 && newx <=2 && newy <= 2){
                        if(grid[newx][newy]){
                            sum++;
                        }
                    }
                }
                if(sum % 2 == 0)
                    result[i][j] = false;
                else result[i][j] = true;
            }
        }
        return result;
    }
}
