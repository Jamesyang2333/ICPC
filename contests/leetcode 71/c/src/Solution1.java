//Search with Dynamic programming causes TLE
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution1 {
    long multi = 1000000001;
    boolean can;
    HashSet<Long> explored;
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        int gcdxy = gcd(sx,  sy);
        if(tx % gcdxy != 0 || ty % gcdxy != 0)
            return false;
        explored = new HashSet<>();
        can = false;
        dfs(sx, sy, tx, ty);
        return can;
    }
    public int gcd(int x, int y){
        if(x < y){
            return gcd(y,  x);
        }
        if(y == 0)
            return x;
        return gcd(y, x % y);
    }
    public void dfs(int sx, int sy, int tx, int ty){
        Stack<state> allstates = new Stack<>();
        allstates.push(new state(sx, sy));
        int count = 0;
        while(!allstates.isEmpty()){
            if(count == 100)
                break;
            count++;
            state current = allstates.pop();
            System.out.println(current.x + " "  + current.y);
            if(current.x == tx && current.y == ty){
                can = true;
                break;
            }
            //allstates.push(new state(current.x, current.y + current.x));
            if(current.x + current.y  == ty || 2 * current.x + current.y <  ty){
            if(!explored.contains((current.x + current.y) * multi + current.x)) {
            explored.add((current.x + current.y) * multi + current.x);
            allstates.push(new state(current.x, current.y + current.x));
        }
            }

            //allstates.push(new state(current.x + current.y, current.y));
            if(current.x + current.y == tx || 2 * current.y + current.x < tx){
        if(!explored.contains(current.y * multi + current.x + current.y)) {
            explored.add(current.y * multi + current.x + current.y);
            allstates.push(new state(current.x + current.y, current.y));
        }}
        }
    }
    public static void main(String[] args){
        Solution1 test = new Solution1();
        Solution test1 = new Solution();
        //System.out.println(test1.reachingPoints(35, 13, 100000, 200000));
        System.out.println(test.reachingPoints(35, 13, 100000, 200000));
    }
}
class state{
    int x;
    int y;
    public state(int x, int y){
        this.x = x;
        this.y = y;
    }
}