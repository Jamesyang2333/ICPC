import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[][] table = new byte[9][9];
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0 && i != 0)
                br.readLine();
            String line = br.readLine();
            for(int j = 0; j < 9; j++){
                if(j < 3){
                    if(line.charAt(j) == 46)
                        table[i][j] = -1;
                    else if(line.charAt(j) == 120)
                        table[i][j] = 1;
                    else table[i][j] = 2;
                }
                else if(j < 6){
                    if(line.charAt(j + 1) == 46)
                        table[i][j] = -1;
                    else if(line.charAt(j + 1) == 120)
                        table[i][j] = 1;
                    else table[i][j] = 2;
                }
                else {
                    if(line.charAt(j + 2) == 46)
                        table[i][j] = -1;
                    else if(line.charAt(j + 2) == 120)
                        table[i][j] = 1;
                    else table[i][j] = 2;
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int x = (row + 2) % 3;
        int y = (column + 2) % 3;
        boolean empty = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if (table[x * 3 + i][y * 3 + j] < 0) {
                    empty = true;
                    break;
                }
            }
            if(empty)
                break;
        }
        if(empty){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(j % 3 == 0 && j != 0)
                    System.out.print(" ");
                if(table[i][j] > 0){
                    if(table[i][j] == 1){
                        System.out.print(Character.toString((char)120));
                    }
                    else System.out.print(Character.toString((char)111));
                }
                else{
                    if(i >= x * 3 && i < x * 3 + 3 && j >= y * 3 && j < y * 3 + 3)
                        System.out.print("!");
                    else
                        System.out.print(Character.toString((char)46));
                }
            }
            System.out.println();
            if(i % 3 == 2 && i != 8)
                System.out.println();
        }
        }
        else{
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(j % 3 == 0 && j != 0)
                        System.out.print(" ");
                    if(table[i][j] > 0){
                        if(table[i][j] == 1){
                            System.out.print(Character.toString((char)120));
                        }
                        else System.out.print(Character.toString((char)111));
                    }
                    else{
                        System.out.print("!");
                    }
                }
                System.out.println();
                if(i % 3 == 2 && i != 8)
                    System.out.println();
            }
        }
    }

}