//This solution should be correct, but really slow and unnecessary, might got TLE from the OJ
//However, the leetcode Oj verdict is wrong answer, which reveals a bug of the OJ
//However, if I replace the commented part by code of exactly the same function, a TLE verdict was shown
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    private boolean canreach;
    int[] xmovs = {0, 0, 1, -1};
    int[] ymovs = {1, -1, 0, 0};
    HashSet<Integer> visited;
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        visited = new HashSet<>();
        canreach = false;
        return bfs(ghosts, target);
    }
    public boolean bfs(int[][] ghosts, int[] target){
        ArrayDeque<state> queue = new ArrayDeque<>();
        queue.addFirst(new state(0, 0, 0));
        int min = Math.abs(target[0]) + Math.abs(target[1]);
        for(int i = 0; i < ghosts.length; i++){
            if(Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]) <= min)
                return false;
        }
        /*int min = 20000;
        for(int i = 0; i < ghosts.length; i++){
            min = Math.min(Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]), min);
        }
        if(min <= (Math.abs(target[0])) + Math.abs(target[1]))
            return false;
         */
        while(!queue.isEmpty()){
            state current = queue.removeLast();
            int x = current.x;
            int y = current.y;
            int step = current.step + 1;
            if(step > min)
                break;
            for(int i = 0; i < 4; i++){
                int newx = x + xmovs[i];
                int newy = y + ymovs[i];
                if(newx >= -10000 && newx <= 10000 && newy >= -10000 && newy <= 10000){
                    if(!visited.contains(newx * 10001 + newy)){
                        visited.add(newx * 10001 + newy);
                        boolean can = true;
                        for(int j = 0; j < ghosts.length; j++){
                            if(Math.abs(newx - ghosts[j][0]) + Math.abs(newy - ghosts[j][1]) <= step){
                                can = false;
                                break;
                            }
                        }
                        if(can){
                        if(newx == target[0] && newy == target[1])
                            return true;
                            queue.addFirst(new state(newx, newy, step));
                        }
                        else {
                            if (newx == target[0] && newy == target[1])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        Solution test = new Solution();
        int[][] ghosts = {{-2125,1628},{-983,1294},{-418,729},{-3338,415},{-727,1038},{-3021,732},{-2644,1109},{-1471,1782},{-3479,274},{-1969,1784},{-1683,1994},{-1333,1644},{-237,548},{-269,580},{-3053,700},{-1560,1871},{-2314,1439},{-3466,287},{-2283,1470},{-3276,477},{-476,787},{-223,534},{-1023,1334},{-2213,1540},{-2988,765},{-1446,1757},{-2719,1034},{-215,526},{-1527,1838},{-1806,1947},{-1317,1628},{-2022,1731},{-2422,1331},{-2793,960},{-2605,1148},{-257,568},{-445,756},{-3196,557},{-1127,1438},{-3031,722},{-3436,317},{-3072,681},{-630,941},{-2018,1735},{-550,861},{-3553,200},{-1271,1582},{-1049,1360},{-684,995},{-3128,625},{149,162},{-666,977},{-3177,576},{-3505,248},{-1690,2001},{-2145,1608},{-987,1298},{-3487,266},{-1896,1857},{-187,498},{-146,457},{-3476,277},{-3114,639},{-64,375},{-2111,1642},{-2982,771},{-1931,1822},{-2709,1044},{-33,344},{-2600,1153},{-1705,2016},{-857,1168},{-3384,369},{-2235,1518},{-998,1309},{-3033,720},{-2342,1411},{-1944,1809},{-798,1109},{80,231},{-2602,1151},{-73,384},{29,282},{-1172,1483},{-395,706},{-621,932},{-232,543},{-1861,1892},{-71,382},{-208,519},{-3178,575},{-740,1051},{-430,741},{-2702,1051},{-2683,1070},{-2598,1155},{-869,1180},{-2939,814},{-883,1194},{-1514,1825}};
        int[] target = {-1721,155};
        System.out.println(test.escapeGhosts(ghosts, target));
    }
}
class state{
    int x;
    int y;
    int step;
    public state(int x, int y, int step){
        this.x = x;
        this.y = y;
        this.step = step;
    }
}