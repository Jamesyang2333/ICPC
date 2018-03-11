import java.util.ArrayList;
import java.util.List;
class Solution {
    private int n;
    private List<List<Integer>> result;
    private int[][] adj;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        adj = graph;
        n = graph.length;
        dfs(new ArrayList<Integer>(), 0);
        return result;
    }
    private void dfs(ArrayList<Integer> sequence, int v){
        if(v == n - 1){
            sequence.add(v);
            result.add(sequence);
        }
        for(int i = 0; i < adj[v].length; i++){
            ArrayList<Integer> newsequence = (ArrayList<Integer>) sequence.clone();
            newsequence.add(v);
            dfs(newsequence, adj[v][i]);
        }
    }
    public static void main(String[] args){
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        Solution test = new Solution();
        System.out.println(test.allPathsSourceTarget(graph).size());
    }
}