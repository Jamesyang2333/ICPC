public class Solution {
    private int target;
    private boolean found = false;
    private xTree targetNode;
    private int dis = 10000;
    private int closest;
    public int findClosestLeaf(TreeNode root, int k) {
        xTree root1 = new xTree(root.val, null);
        construct(root, root1);
        target = k;
        find(root1);
        search(targetNode, 0, true, -1);
        return closest;
    }
    private void find(xTree current){
        if(found)
            return;
        if(current.val == target){
            targetNode = current;
            found = true;
        }
        else {
            if(current.left != null)
                find(current.left);
            if(current.right != null)
                find(current.right);
        }
    }
    private void construct(TreeNode root, xTree root1){
        if(root.left != null){
            root1.left = new xTree(root.left.val, root1);
            construct(root.left, root1.left);
        }
        if(root.right != null){
            root1. = new xTree(root.right.val, root1);
            construct(root.right, root1.right);
        }
    }
    private void search(xTree current, int step, boolean up, int prev){
        if(current.left == null && current.right == null){
            if(step < dis){
                closest = current.val;
                dis = step;
            }
        }
        if(up){
            if(current.prev != null)
                search(current.prev, step + 1, true, current.val);
            if(current.left != null){
                if(current.left.val != prev)
                    search(current.left, step + 1, false, 0);
            }
            if(current.right != null){
                if(current.right.val != prev)
                    search(current.right, step + 1, false, 0);
            }
        }
        else{
            if(current.left != null){
                if(current.left.val != prev)
                    search(current.left, step + 1, false, 0);
            }
            if(current.right != null){
                if(current.right.val != prev)
                    search(current.right, step + 1, false, 0);
            }
        }
    }
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(3);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(4);
        a.left.left.left = new TreeNode(5);
        a.left.left.left.left = new TreeNode(6);
        Solution test = new Solution();
        System.out.println(test.findClosestLeaf(a, 2));
    }
}
class xTree{
    int val;
    int dis;
    xTree prev;
    xTree left;
    xTree right;
    xTree(int val, xTree prev){
        this.prev = prev;
        this.val = val;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
