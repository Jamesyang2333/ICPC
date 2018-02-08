import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] revisedRussianRoulette(int[] doors) {
        int len = doors.length;
        int nlocked = 0;
        for(int i = 0; i < len; i++){
            if(doors[i] == 1)
                nlocked++;
        }
        int[] result = new int[2];
        result[1] = nlocked;
        int consec = 0;
        int min = 0;
        for(int i = 0; i < len; i++){
            if(doors[i] == 1){
                consec++;
                if(i == len - 1){
                    if(consec % 2 == 0)
                        min += (consec / 2);
                    else {
                        min += (consec / 2 + 1);
                    }
                }
            }
            else if(doors[i] == 0){
                if(consec % 2 == 0)
                    min += (consec / 2);
                else {
                    min += (consec / 2 + 1);
                }
                consec = 0;
            }
        }
        result[0] = min;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
