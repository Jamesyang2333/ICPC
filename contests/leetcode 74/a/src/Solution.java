class Solution {
    public boolean validTicTacToe(String[] board) {
        int countx = 0;
        int counto = 0;
        for(int i = 0;  i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'X')
                    countx++;
                else if(board[i].charAt(j) == 'O')
                    counto++;
            }
        }
        if(!(counto == countx || counto == countx - 1))
            return false;
        boolean x = false;
        boolean o = false;
        for(int i = 0;  i < 3; i++){
            boolean owin = true;
            boolean xwin = true;
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) != 'X')
                    xwin = false;
                if(board[i].charAt(j) != 'O')
                    owin = false;
            }
            if(xwin)
                x = true;
            if(owin)
                o = true;
        }
        for(int i = 0;  i < 3; i++){
            boolean owin = true;
            boolean xwin = true;
            for(int j = 0; j < 3; j++){
                if(board[j].charAt(i) != 'X')
                    xwin = false;
                if(board[j].charAt(i) != 'O')
                    owin = false;
            }
            if(xwin)
                x = true;
            if(owin)
                o = true;
        }
        boolean owin = true;
        boolean xwin = true;
        for(int i = 0;  i < 3; i++){
            if(board[i].charAt(i) != 'O')
                owin = false;
            if(board[i].charAt(i) != 'X')
                xwin = false;
        }
        if(xwin)
            x = true;
        if(owin)
            o = true;
        owin = true;
        xwin = true;
        for(int i = 0;  i < 3; i++){
            if(board[i].charAt(2 - i) != 'O')
                owin = false;
            if(board[i].charAt(2 - i) != 'X')
                xwin = false;
        }
        if(xwin)
            x = true;
        if(owin)
            o = true;
        if(x && (counto == countx))
            return false;
        if(o && (counto != countx))
            return false;
        if(x && o)
            return false;
        return true;

    }
    public static void main(String[] args){
        Solution test = new Solution();
        String[] example = {"XXX", "XOO", "OO "};
        System.out.print(test.validTicTacToe(example));
    }
}