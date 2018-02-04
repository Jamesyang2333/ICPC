import javax.transaction.TransactionRequiredException;

//The correct version of the solution
public class Solution1 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] result = new TreeNode[2];
        if(root == null)
            return result;
        if(root.val > V){
            TreeNode[] leftResult = splitBST(root.left, V);
            result[1] = root;
            root.left = leftResult[1];
            result[0] = leftResult[0];
        }
        else{
            TreeNode[] rightResult = splitBST(root.right, V);
            result[1] = rightResult[1];
            result[0] = root;
            result[0].right = rightResult[0];
        }
        return result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Solution1 test = new Solution1();
        TreeNode[] answer = test.splitBST(root,2);
    }
}
