//This solution is wrong
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    TreeNode parent = null;
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode result = ceiling(root, V);
        TreeNode[] answer = new TreeNode[2];
        if(result == null){
        answer[0] = null;
        answer[1] = root;
        return answer;
        }
        else{
            if(parent == null){
                answer[0] = root.left;
                root.left = null;
                answer[1] = root;
                return answer;
            }
            else{
                parent.right = result.left;
                answer[0] = parent;
                result.left = null;
                answer[1] = result;
                return answer;

            }
        }
    }
    public TreeNode ceiling(TreeNode root, int v){
        if(root.val > v){
            if(root.left != null){
                if(root.left.val > v){
                    parent = root;
                    return ceiling(root.left, v);
                }
                else return root;
            }
            else return root;
        }
        else{
            if(root.right != null){
                parent = root;
                return ceiling(root.right, v);}
            else return null;
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Solution test = new Solution();
        TreeNode[] answer = test.splitBST(root,2);
    }
}