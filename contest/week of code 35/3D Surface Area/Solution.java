import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[][] height = new int[H][W];
            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    height[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for(int i = 0; i < H - 1; i++){
                for(int j = 0; j < W; j++){
                    if(height[i][j] > height[i + 1][j])
                        result += (height[i][j] - height[i + 1][j]);
                }
            }
            for(int j = 0; j < W; j++){
                result += height[H - 1][j];
                result += height[0][j];
            }
            for(int i = H - 1; i > 0; i--)
                for(int j = 0; j < W; j++){
                    if(height[i][j] > height[i - 1][j])
                        result += (height[i][j] - height[i - 1][j]);
                }
            for(int j = 1; j < W - 1; j++){
                for(int i = 0; i < H; i++){
                    if(height[i][j] > height[i][j + 1])
                        result += (height[i][j] - height[i][j + 1]);
                    if(height[i][j] > height[i][j - 1])
                        result += (height[i][j] - height[i][j - 1]);
                }
            }
            if(W > 1)
            for(int i = 0; i < H; i++){
                if(height[i][0] > height[i][1])
                    result += (height[i][0] - height[i][1]);
                if(height[i][W - 1] > height[i][W - 2])
                    result += (height[i][W - 1] - height[i][W - 2]);
            }
            for(int i = 0; i < H; i++){
                result += height[i][0];
                result += height[i][W - 1];
            }
            System.out.println(result + 2 * H * W);
        }
        catch (IOException err){}
    }
}