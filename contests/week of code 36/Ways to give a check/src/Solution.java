import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        int[] kingpos = new int[2];
        ArrayList<int[]> queens = new ArrayList<>();
        ArrayList<int[]> rooks = new ArrayList<>();
        ArrayList<int[]> bishops = new ArrayList<>();
        int pawnpos = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'k'){
                    kingpos[0] = i;
                    kingpos[1] = j;
                }
                if(i == 1){
                    if(board[i][j] == 'P' && board[i - 1][j] == '#'){
                        pawnpos = j;
                    }
                }
                if(board[i][j] == 'Q')
                    queens.add(new int[]{i, j});
                if(board[i][j] == 'R')
                    rooks.add(new int[]{i, j});
                if(board[i][j] == 'B')
                    bishops.add(new int[]{i, j});
            }
        }
        board[1][pawnpos] = '#';
        board[0][pawnpos] = 'P';
        for(int[] pos : rooks){
            if(rookcheck(pos[0],pos[1], kingpos[0], kingpos[1], board))
                return 4;
        }
        for(int[] pos : bishops){
            if(bishopcheck(pos[0],pos[1], kingpos[0], kingpos[1], board))
                return 4;
        }
        for(int[] pos : queens){
            if(rookcheck(pos[0],pos[1], kingpos[0], kingpos[1], board) || bishopcheck(pos[0],pos[1], kingpos[0], kingpos[1], board))
                return 4;
        }
        int count = 0;
        if(Math.abs(kingpos[0] * (kingpos[1] - pawnpos)) == 2)
            count++;
        boolean canberook = rookcheck(0, pawnpos, kingpos[0], kingpos[1], board);
        if(canberook)
            count++;
        boolean canbebishop = bishopcheck(0, pawnpos, kingpos[0], kingpos[1], board);
        if(canbebishop)
            count++;
        if(canbebishop || canberook)
            count++;
        return count;
    }
    private static boolean rookcheck(int rookx, int rooky, int kingx, int kingy, char[][] board){
        boolean canberook = false;
        boolean rowrook = false;
        if(rookx == kingx){
            rowrook = true;
            for(int i = Math.min(kingy, rooky) + 1; i < Math.max(kingy, rooky); i++){
                if (board[rookx][i] != '#'){
                    rowrook = false;
                    break;
                }
            }
        }
        if(rowrook == true){
            return true;
        }
        else{
            if(kingy == rooky){
                boolean filerook = true;
                for(int i = Math.min(kingx, rookx) + 1; i < Math.max(kingx, rookx); i++){
                    if(board[i][kingy] == '#'){
                        filerook = false;
                        break;
                    }
                }
                if(filerook){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean bishopcheck(int bisx, int bisy, int kingx, int kingy, char[][] board){
        if(Math.abs(kingx - bisx) == Math.abs(kingy - bisy)){
            boolean canbebishop = true;
            int incx = 1;
            int incy = 1;
            if(kingx < bisx)
                incx = -1;
            if(kingy < bisy)
                incy = -1;
            bisx += (incx);
            bisy += (incy);
            for(int i = 0; i < Math.abs(kingx - bisx) - 1; i++){
                if(board[bisx][bisy] != '#'){
                    canbebishop = false;
                    break;
                }
                bisx += (incx);
                bisy += (incy);
            }
            return canbebishop;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][8];
            for(int board_i = 0; board_i < 8; board_i++){
                String line = br.readLine();
                for(int board_j = 0; board_j < 8; board_j++){
                    board[board_i][board_j] = line.charAt(board_j);
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
    }
}
