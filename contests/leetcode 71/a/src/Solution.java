import java.util.ArrayList;

class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
class Solution {
    private ArrayList<Integer> allvalue;
    public int minDiffInBST(TreeNode root) {
        allvalue = new ArrayList<>();
        inorder(root);
        int len = allvalue.size();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len - 1; i++){
            if(allvalue.get(i + 1) - allvalue.get(i) < min)
                min = allvalue.get(i + 1) - allvalue.get(i);
        }
        return min;
    }
    public void inorder(TreeNode a){
        if(a == null)
            return;
        inorder(a.left);
        allvalue.add(a.val);
        inorder(a.right);
    }
}