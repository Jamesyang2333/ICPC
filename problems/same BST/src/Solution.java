class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private boolean same;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        same = true;
        check(p, q);
        return same;
    }
    private void check(TreeNode p, TreeNode q){
        if(!same)
            return;
        if((p == null && q != null) || (p != null && q == null)){
            same = false;
        }
        else if(p != null && q != null){
            if(p.val != q.val){
                same = false;
                return;
            }
            else{
                check(p.left, q.left);
                check(p.right, q.right);
            }
        }
    }
}