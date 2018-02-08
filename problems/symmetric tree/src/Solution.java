class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private boolean symmetric;
    public boolean isSymmetric(TreeNode root) {
        symmetric = true;
        check(root, root);
        return symmetric;
    }
    private void check(TreeNode a, TreeNode b){
        if(!symmetric)
            return;
        if((a == null && b != null) || (a != null && b ==null)){
            symmetric = false;
            return;
        }
        else if(a != null && b != null){
            if(a.val != b.val){
                symmetric = false;
                return;
            }
            else {
                check(a.left, b.right);
                check(a.right, b.left);
            }
        }
    }
}