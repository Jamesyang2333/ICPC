import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<TreeNode>();
        return recurgen(1, n);
    }
    private List<TreeNode> recurgen(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start == end){
            result.add(new TreeNode(start));
            return result;
        }
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftResult = recurgen(start, i - 1);
            List<TreeNode> rightResult = recurgen(i + 1, end);
            for(TreeNode left : leftResult){
                for (TreeNode right : rightResult){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        List<TreeNode> answer = test.generateTrees(1);
        System.out.println(answer.size());
    }
}