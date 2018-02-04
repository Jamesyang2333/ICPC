import java.util.*;
class Solution {
    private int[][] forest1;
    private int n;
    private int m;
    private int[] xmov = new int[]{1, -1, 0 , 0};
    private int[] ymov = new int[]{0, 0, 1, -1};
    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size();
        m = forest.get(0).size();
        tree[] allTree = new tree[n * m];
        forest1 = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                forest1[i][j] = forest.get(i).get(j);
                allTree[i * m + j] = new tree(forest1[i][j], i, j);
            }
        }
        Arrays.sort(allTree, new byHeight());
        int start = 0;
        for(int i = 0; i < m * n; i++){
            if(allTree[i].height > 1){
                start = i;
                break;
            }
        }
        int result = -1;
        int firstStep = dis(0, 0, allTree[start].xpos, allTree[start].ypos);
        if(firstStep >= 0){
            result = firstStep;
            for(int i = start; i < m * n - 1; i++){
                int step = dis(allTree[i].xpos, allTree[i].ypos, allTree[i + 1].xpos, allTree[i + 1].ypos);
                if(step > 0)
                    result += step;
                else{
                    //System.out.println(allTree[i].xpos + " " +  allTree[i].ypos + " " + allTree[i + 1].xpos + " " +  allTree[i + 1].ypos);
                    result = -1;
                    break;
                }
            }
        }
        return result;
    }
    private int dis(int x1, int y1, int x2, int y2){
        int[][] dis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dis[i][j] = -1;
            }
        }
        ArrayList<int[]> states = new ArrayList<>();
        dis[x1][y1] = 0;
        states.add(new int[]{x1, y1});
        int result = -1;
        while(!states.isEmpty()){
            int[] current = states.remove(0);
            if(current[0] == x2 && current[1] == y2){
                result = dis[x2][y2];
                break;
            }
            for(int i = 0; i < 4; i++){
                int newx = current[0] + xmov[i];
                int newy = current[1] + ymov[i];
                if(newx >= 0 && newx < n && newy >= 0 && newy < m){
                    if(dis[newx][newy] == -1 && forest1[newx][newy] != 0){
                        dis[newx][newy] = dis[current[0]][current[1]] + 1;
                        states.add(new int[]{newx, newy});
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.cutOffTree(null));
    }
}
class tree{
    int height;
    int xpos;
    int ypos;
    public tree(int height, int xpos, int ypos){
        this.height = height;
        this.xpos = xpos;
        this.ypos = ypos;
    }
}
class byHeight implements Comparator<tree>{
    public int compare(tree a, tree b){
        return a.height - b.height;
    }
}