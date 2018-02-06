class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private boolean valid;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        valid = true;
        validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return valid;
    }
    private void validate(TreeNode root, long min, long max){
        if(!valid)
            return;
        if(root.right != null){
            if(root.right.val <= root.val || root.right.val >= max || root.right.val <= min){
                valid = false;
                return;
            }
            else validate(root.right, Math.max(min, root.val), max);
        }
        if(root.left != null){
            if(root.left.val >= root.val || root.left.val >= max || root.left.val <= min){
                valid = false;
                return;
            }
            else validate(root.left, min, Math.min(max, root.val));
        }
    }
    public static void main(String[] args){
        Solution test = new Solution();
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        System.out.println(test.isValidBST(root));
    }
}