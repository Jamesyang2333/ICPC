import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private ArrayList<Integer> inorder;
    private int larger;
    private boolean largerfound;
    private int smaller;
    private boolean smallerfound;
    public void recoverTree(TreeNode root) {
        inorder = new ArrayList<>();
        inordertra(root);
        larger = 0;
        smaller = 0;
        int len = inorder.size();
        for(int i = 0; i < len - 1; i++){
            if(inorder.get(i) > inorder.get(i + 1)){
                larger = inorder.get(i);
                break;
            }
        }
        for(int i = len - 1; i > 0; i--){
            if(inorder.get(i) < inorder.get(i - 1)){
                smaller = inorder.get(i);
                break;
            }
        }
        largerfound = false;
        smallerfound = false;
        modileft(root);
        modiright(root);
    }
    private void inordertra(TreeNode root){
        if(root == null)
            return;
        inordertra(root.left);
        inorder.add(root.val);
        inordertra(root.right);
    }
    private void modileft(TreeNode root){
        if(largerfound)
            return;
        if(root == null)
            return;
        modileft(root.left);
        if(largerfound)
            return;
        if(root.val == larger){
            root.val = smaller;
            largerfound = true;
            return;
        }
        modileft(root.right);
    }
    private void modiright(TreeNode root){
        if(smallerfound)
            return;
        if(root == null)
            return;
        modiright(root.right);
        if(smallerfound)
            return;
        if(root.val == smaller){
            root.val = larger;
            smallerfound = true;
            return;
        }
        modiright(root.left);
    }
    public static void main(String[] args){
        Solution test = new Solution();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        test.recoverTree(root);
        System.out.println(root.val);
        System.out.println(root.right.val);
    }
}