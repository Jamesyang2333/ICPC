/*
ID: jamesya4
LANG: JAVA
TASK: frameup
*/
import java.io.*;
import java.util.*;

class frameup {
    private static ArrayList<int[]>[] pawns;
    private static int m;
    private static int n;
    private static boolean[] marked;
    private static byte[][] board;
    private static Stack<Integer> order = new Stack<>();
    private static int ncount;
    private static PrintWriter out;
    private static ArrayList<String> result = new ArrayList<>();
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("frameup.in"));
        // input file name goes above
        out = new PrintWriter(new BufferedWriter(new FileWriter("frameup.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new byte[m][n];
        pawns = (ArrayList<int[]>[]) new ArrayList[26];
        for(int i = 0; i < 26; i++)
            pawns[i] = new ArrayList<int[]>();
        for(int i = 0; i < m; i++){
            String line = f.readLine();
            for(int j = 0; j < n; j++){
                if(line.charAt(j) != '.'){
                    byte letter = (byte)(line.charAt(j) - 'A');
                    board[i][j] = letter;
                    pawns[letter].add(new int[]{i, j});
                }
                else{
                    board[i][j] = -1;
                }
            }
        }
        marked = new boolean[26];
        for(int i = 0; i < 26; i++)
            marked[i] = false;
        ncount = 0;
        for(int i = 0; i < 26; i++){
            if(!pawns[i].isEmpty())
                ncount++;
        }
        search(ncount);
        Collections.sort(result);
        for(String a : result)
            out.println(a);
        out.close();                                  // close the output file
    }
    private static void search(int count){
        if(count == 0){
            String sequence = "";
            for(int i = 0; i < ncount; i++){
                sequence += (String.valueOf((char)(order.get(ncount - 1 - i) + 'A')));
            }
            result.add(sequence);
            return;
        }
        for(int i = 0; i < 26; i++){
            if(!pawns[i].isEmpty()){
                if(!marked[i]){
                    if(checkLetter(i)){
                        order.push(i);
                        marked[i] = true;
                        for(int[] pos : pawns[i]){
                            board[pos[0]][pos[1]] = -2;
                        }
                        search(count - 1);
                        for(int[] pos : pawns[i]){
                            board[pos[0]][pos[1]] = (byte)i;
                        }
                        order.pop();
                        marked[i] = false;
                    }
                }
            }
        }
    }
    /*private static boolean checkLetter(int letter){
        for(int i = 0; i < m - 2; i++){
            for(int j = 0; j < n - 2; j++){
                if(board[i][j] == -2 || board[i][j] == letter){
                    for(int k = i + 2; k < m; k++){
                        for(int l = i + 2; l < n; l++){
                            if(board[k][l] == -2 || board[k][l] == letter){
                                boolean can = true;
                                int count = 0;
                                for(int a = i; a <= k; a++){
                                    if(board[a][j] != -2 && board[a][j] != letter){
                                        can = false;
                                        break;
                                    }
                                    else {
                                        if(board[a][j] == letter)
                                            count++;
                                    }
                                    if (board[a][l] != -2 && board[a][l] != letter){
                                        can = false;
                                        break;
                                    }
                                    else {
                                        if(board[a][l] == letter)
                                            count++;
                                    }
                                }
                                if(can){
                                    for(int a = j; a <= l; a++){
                                        if(board[i][a] != -2 && board[i][a] != letter){
                                            can = false;
                                            break;
                                        }
                                        else {
                                            if(board[i][a] == letter)
                                                count++;
                                        }
                                        if (board[k][a] != -2 && board[k][a] != letter){
                                            can = false;
                                            break;
                                        }
                                        else {
                                            if(board[k][a] == letter)
                                                count++;
                                        }
                                    }
                                }
                                if(can){
                                    if(count == pawns[letter].size()){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }*/
    private static boolean checkLetter(int letter){
        int row1 = m;
        int row2 = 0;
        int column1 = n;
        int column2 = 0;
        for(int[] pos : pawns[letter]){
            if(pos[0] < row1)
                row1 = pos[0];
            if(pos[0] > row2)
                row2 = pos[0];
            if(pos[1] < column1)
                column1 = pos[1];
            if(pos[1] > column2)
                column2 = pos[1];
        }
        for(int i = row1; i <= row2; i++){
            if(board[i][column1] != -2 && board[i][column1] != letter)
                return false;
            if(board[i][column2] != -2 && board[i][column2] != letter)
                return false;
        }
        for(int j = column1; j <= column2; j++){
            if(board[row1][j] != -2 && board[row1][j] != letter)
                return false;
            if(board[row2][j] != -2 && board[row2][j] != letter)
                return false;
        }
        return true;
    }
}
