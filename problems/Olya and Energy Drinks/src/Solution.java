import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int speed = sc.nextInt();
        int[][] bfs = new int[row][column];
        for(int i = 0; i < row; i++){
            String line = sc.next();
            for(int j = 0; j < column; j++){
                if(line.charAt(j) == '.')
                    bfs[i][j] = -1;
                else bfs[i][j] = -2;
            }
        }
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        ArrayDeque<int[]> states = new ArrayDeque<int[]>();
        bfs[x1 - 1][y1 - 1] = 0;
        states.add(new int[]{x1 - 1, y1 - 1});
        boolean find = false;
        while(!states.isEmpty()){
            int[] current = states.remove();
            int x = current[0];
            int y = current[1];
            for(int i = 1; i <= speed; i++){
                if(x - i < 0)
                    break;
                if(bfs[x - i][y] == -2)
                    break;
                if(bfs[x - i][y] == -1) {
                    states.add(new int[]{x - i, y});
                    bfs[x - i][y] = bfs[x][y] + 1;
                    if((x - i == x2 - 1) && (y == y2 - 1)) {
                        find = true;
                        break;
                    }
                }
            }
            if(find)
                break;
            for(int i = 1; i <= speed; i++){
                if(x + i > row - 1)
                    break;
                if(bfs[x + i][y] == -2)
                    break;
                if(bfs[x + i][y] == -1) {
                    states.add(new int[]{x + i, y});
                    bfs[x + i][y] = bfs[x][y] + 1;
                    if((x + i == x2 - 1) && (y == y2 - 1)) {
                        find = true;
                        break;
                    }
                }
            }
            if(find)
                break;
            for(int i = 1; i <= speed; i++){
                if(y - i < 0)
                    break;
                if(bfs[x][y - i] == -2)
                    break;
                if(bfs[x][y - i] == -1) {
                    states.add(new int[]{x, y - i});
                    bfs[x][y - i] = bfs[x][y] + 1;
                    if((x == x2 - 1) && (y - i == y2 - 1)) {
                        find = true;
                        break;
                    }
                }
            }
            if(find)
                break;
            for(int i = 1; i <= speed; i++){
                if(y + i > column - 1)
                    break;
                if(bfs[x][y + i] == -2)
                    break;
                if(bfs[x][y + i] == -1) {
                    states.add(new int[]{x, y + i});
                    bfs[x][y + i] = bfs[x][y] + 1;
                    if((x == x2 - 1) && (y + i == y2 - 1)) {
                        find = true;
                        break;
                    }
                }
            }
            if(find)
                break;
        }
        System.out.println(bfs[x2 - 1][y2 - 1]);
    }
}
