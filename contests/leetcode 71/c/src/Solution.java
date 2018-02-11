//naive search causes  TLE and stackoverflow
import java.util.HashMap;
        import java.util.HashSet;

class Solution {
    long multi = 1000000001;
    boolean can;
    HashSet<Long> explored;
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        explored = new HashSet<>();
        can = false;
        dfs(sx, sy, tx, ty);
        return can;
    }
    public void dfs(int sx, int sy, int tx, int ty){
        if(can)
            return;
        if(sx == tx && sy == ty){
            can = true;
            return;
        }
        if(sx > tx || sy > ty)
            return;
        if(!explored.contains((sx + sy) * multi + sx)) {
            explored.add((sx + sy) * multi + sx);
            dfs(sx, sx + sy, tx, ty);
        }
        if(!explored.contains(sy * multi + sx + sy)) {
            explored.add(sy * multi + sx + sy);
            dfs(sx + sy, sy, tx, ty);
        }
    }
    public static void main(String[] args){
        HashSet<state> test = new HashSet<>();
        test.add(new state(1, 2));
        test.add(new state(1,  2));
        System.out.println(test.size());
    }
}
