import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String ori = sc.next();
        int length = ori.length();
        int[][] numa = new int[length][length];
        int[][] numb = new int[length][length];
        if(ori.charAt(0) == 'a') {
            numa[0][0] = 1;
            numb[0][0] = 0;
        }
        else {
            numa[0][0] = 0;
            numb[0][0] = 1;
        }
        for(int i = 1; i < length; i++){
            for(int j = 0; j <= i; j++){
                if (ori.charAt(i) == 'a'){
                    if(i == j){
                        numa[i][j] = 1;
                        numb[i][j] = 0;
                    }
                    else{
                        numa[j][i] = numa[j][i - 1] + 1;
                        numb[j][i] = numb[j][i - 1];
                    }
                }else{
                    if(i == j){
                        numb[i][j] = 1;
                        numa[i][j] = 0;
                    }
                    else{
                        numb[j][i] = numb[j][i - 1] + 1;
                        numa[j][i] = numa[j][i - 1];
                    }
                }
            }
        }
        int min = 5000;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                min = Math.min(min, numb[0][i] + numa[i + 1][j - 1] + numb[j][length - 1]);
            }
        }
        for(int i = 0; i < length - 1; i++){
            min = Math.min(min, numa[0][i] + numb[i + 1][length - 1]);
        }
        for(int i = 0; i < length - 1; i++){
            min = Math.min(min, numb[0][i] + numa[i + 1][length - 1]);
        }
        min = Math.min(min, numa[0][length - 1]);
        min = Math.min(min, numb[0][length - 1]);
        System.out.println(length - min);
    }
}
