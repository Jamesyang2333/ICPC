import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int movesToChessboard(int[][] board) {
        int len = board.length;
        if(len % 2 == 0){
            HashMap<Integer, Integer> row = new HashMap<>();
            HashMap<Integer, Integer> col = new HashMap<>();
            int firstrowpattern = 0;
            int firstcolpattern = 0;
            int evensamerow = 0;
            int evensamecol = 0;
            for(int i = 0; i < len; i++){
                int countrow1 = 0;
                int countcol1 = 0;
                int rowpattern = 0;
                int colpattern = 0;
                for(int j = 0; j < len; j++){
                    if(board[i][j] == 1){
                        countrow1++;
                        rowpattern += (1 << j);
                    }
                    if(board[j][i] == 1){
                        countcol1++;
                        colpattern += (1 << j);
                    }
                }
                if(i == 0) {
                    firstrowpattern = rowpattern;
                    evensamerow++;
                    firstcolpattern = colpattern;
                    evensamecol++;
                }
                if(i % 2 == 0 && i != 0) {
                    if(rowpattern == firstrowpattern)
                        evensamerow++;
                    if(colpattern == firstcolpattern)
                        evensamecol++;
                }
                if(!row.containsKey(rowpattern)) {
                    if(row.size() < 2)
                        row.put(rowpattern, 1);
                    else return -1;
                }
                else {
                    row.put(rowpattern, row.get(rowpattern) + 1);
                }
                if(!col.containsKey(colpattern)) {
                    if(col.size() < 2)
                        col.put(colpattern, 1);
                    else return -1;
                }
                else {
                    col.put(colpattern, col.get(colpattern) + 1);
                }
                if(countrow1 != len / 2 || countcol1 != len / 2)
                    return -1;
            }
            if(row.size() == 2 && col.size() == 2){
                for(int i : row.keySet()){
                    if(row.get(i) != len / 2)
                        return  -1;
                    break;
                }
                for(int i : col.keySet()){
                if(col.get(i) != len / 2)
                    return  -1;
                break;
                }
                return (Math.min(len / 2 - evensamecol, evensamecol) + Math.min(len / 2 - evensamerow, evensamerow));
            }
            return -1;
        }
        else{
                HashMap<Integer, Integer> row = new HashMap<>();
                HashMap<Integer, Integer> col = new HashMap<>();
                int firstrowpattern = 0;
                int firstcolpattern = 0;
                int evensamerow = 0;
                int evensamecol = 0;
                for(int i = 0; i < len; i++){
                    int countrow1 = 0;
                    int countcol1 = 0;
                    int rowpattern = 0;
                    int colpattern = 0;
                    for(int j = 0; j < len; j++){
                        if(board[i][j] == 1){
                            countrow1++;
                            rowpattern += (1 << j);
                        }
                        if(board[j][i] == 1){
                            countcol1++;
                            colpattern += (1 << j);
                        }
                    }
                    if(i == 0) {
                        firstrowpattern = rowpattern;
                        evensamerow++;
                        firstcolpattern = colpattern;
                        evensamecol++;
                    }
                    if(i % 2 == 0 && i != 0) {
                        if(rowpattern == firstrowpattern)
                            evensamerow++;
                        if(colpattern == firstcolpattern)
                            evensamecol++;
                    }
                    if(!row.containsKey(rowpattern)) {
                        if(row.size() < 2)
                            row.put(rowpattern, 1);
                        else return -1;
                    }
                    else {
                        row.put(rowpattern, row.get(rowpattern) + 1);
                    }
                    if(!col.containsKey(colpattern)) {
                        if(col.size() < 2)
                            col.put(colpattern, 1);
                        else return -1;
                    }
                    else {
                        col.put(colpattern, col.get(colpattern) + 1);
                    }
                    if((countrow1 != (len + 1) / 2 && countrow1 != (len - 1) / 2) || (countcol1 != (len + 1) / 2 && countcol1 != (len - 1) / 2))
                        return -1;
                }
                if(row.size() == 2 && col.size() == 2){
                    for(int i : row.keySet()){
                        if(row.get(i) != (len - 1) / 2 && row.get(i) != (len + 1) / 2)
                            return  -1;
                        break;
                    }
                    for(int i : col.keySet()){
                        if(col.get(i) != (len - 1) / 2 && col.get(i) != (len + 1) / 2)
                            return  -1;
                        break;
                    }
                    int rowtrans = 0;
                    int coltrans = 0;
                    if(row.get(firstrowpattern) == (len + 1) / 2){
                        rowtrans = (len + 1) / 2 - evensamerow;
                    }
                    else rowtrans = evensamerow;
                    if(col.get(firstcolpattern) == (len + 1) / 2){
                        coltrans = (len + 1) / 2 - evensamecol;
                    }
                    else coltrans = evensamecol;
                    return rowtrans + coltrans;

                }
                return -1;
        }
    }
    public static void main(String[] args){
        Solution test = new Solution();
        int[][] sample = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        System.out.println(test.movesToChessboard(sample));
    }
}