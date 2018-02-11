class Solution2 {
    public boolean reachingPoints(int tx, int ty, int sx, int sy) {
        while(sx >= tx && sy >= ty){
            if(sx > sy){
                int newx = sx - ((sx - sy) / sy + 1) * sy;
                if(ty == sy && (sx - tx) % ty == 0 && tx >= newx)
                    return true;
                sx = newx;
            }
            else  if(sy > sx){
                int newy = sy - ((sy - sx) / sx + 1) * sx;
                if(tx == sx && (sy - ty) % tx == 0 && ty >= newy)
                    return true;
                sy = newy;
            }
            else break;
        }
        return (sx == tx && sy == ty);
    }
    public static void main(String[] args){
        Solution2 test = new Solution2();
        System.out.println(test.reachingPoints(3, 3, 12,  9));
    }
}
