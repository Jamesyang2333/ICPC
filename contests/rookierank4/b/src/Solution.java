import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String checkAll(int n, int[] height, int[] position) {
        // Complete this function
        rack[] allracks = new rack[n];
        for(int i = 0; i < n; i++){
            allracks[i] = new rack(position[i], height[i]);
        }
        Arrays.sort(allracks);
        boolean leftcan = true;
        int current = 0;
        for(int i = 0; i < n - 1; i++){
            if(i > current){
                leftcan = false;
                break;
            }
            for(int j = current + 1; j < n; j++){
                if(position[i] + height[i] < position[j]){
                    current = j - 1;
                    break;
                }
            }
            if(position[i] + height[i] >= position[n - 1]){
                current = n - 1;
                break;
            }
        }
        if(current != n - 1)
            leftcan = false;
        boolean rightcan = true;
        current = n - 1;
        for(int i = n - 1; i > 0; i--){
            if(i < current){
                rightcan = false;
                break;
            }
            for(int j = current - 1; j >= 0; j--){
                if(position[i] - height[i] > position[j]){
                    current = j + 1;
                    break;
                }
            }
            if(position[i] - height[i] <= position[0]){
                current = 0;
                break;
            }
        }
        if(current != 0)
            rightcan = false;
        if(rightcan && leftcan)
            return "BOTH";
        else if(rightcan)
            return "RIGHT";
        else if(leftcan)
            return "LEFT";
        else return "NONE";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        for(int position_i = 0; position_i < n; position_i++){
            position[position_i] = in.nextInt();
        }
        int[] height = new int[n];
        for(int height_i = 0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        String ret = checkAll(n, height, position);
        System.out.println(ret);
        in.close();
    }
}
class rack implements Comparable<rack>{
    int pos;
    int height;
    public rack(int pos, int height){
        this.pos = pos;
        this.height = height;
    }

    @Override
    public int compareTo(rack o) {
        return pos - o.pos;
    }
}