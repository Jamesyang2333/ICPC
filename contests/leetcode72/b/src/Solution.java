class Solution {
    private int[][] Graph;
    private boolean[] marked;
    private boolean[] isred;
    private boolean isBipartite;
    public boolean isBipartite(int[][] graph) {
        Graph = graph;
        isBipartite = true;
        int len = graph.length;
        marked = new boolean[len];
        isred = new boolean[len];
        for(int i = 0; i < len; i++){
            marked[i] = false;
        }
        for(int i = 0; i < len; i++){
            if(!marked[i])
            dfs(0);
        }
        return isBipartite;
    }
    private void dfs(int v){
        if(!isBipartite)
            return;
        if(v == 0){
            isred[v] = true;
        }
        marked[v] = true;
        int adjlen = Graph[v].length;
        for(int i = 0; i < adjlen; i++){
            if(!marked[Graph[v][i]]){
                isred[Graph[v][i]] = !isred[v];
                dfs(Graph[v][i]);
            }
            else if(isred[Graph[v][i]] == isred[v]){
                isBipartite = false;
                return;
            }
        }
    }
    public static void main(String[] args){
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0,  2}};
        Solution test = new Solution();
        System.out.println(test.isBipartite(graph));
    }
}