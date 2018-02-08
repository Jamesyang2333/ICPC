import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        ArrayDeque<augmentedNode> states = new ArrayDeque<>();
        states.add(new augmentedNode(1, root));
        int lastlevel = 0;
        ArrayList<Integer> currentlevel = null;
        while(!states.isEmpty()){
            augmentedNode current = states.remove();
            if(lastlevel != current.level){
                if(current.level != 1){
                    if(current.level % 2 == 0)
                        result.add(currentlevel);
                    else result.add(reverse(currentlevel));
                }
                lastlevel = current.level;
                currentlevel = new ArrayList<Integer>();
                currentlevel.add(current.root.val);
            }
            else{
                currentlevel.add(current.root.val);
            }
            if(current.root.left != null){
                states.add(new augmentedNode(current.level + 1, current.root.left));
            }
            if(current.root.right != null){
                states.add(new augmentedNode(current.level + 1, current.root.right));
            }
            if(states.isEmpty()){
                if(current.level % 2 == 1)
                    result.add(currentlevel);
                else result.add(reverse(currentlevel));
            }
        }
        return result;
    }
    public ArrayList<Integer> reverse(ArrayList<Integer> a){
        ArrayList<Integer> reverseresult = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            reverseresult.add(a.get(a.size() - 1 - i));
        }
        return reverseresult;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(test.levelOrder(tree));
    }
}
class augmentedNode{
    int level;
    TreeNode root;
    public augmentedNode(int level, TreeNode root){
        this.level = level;
        this.root = root;
    }
}