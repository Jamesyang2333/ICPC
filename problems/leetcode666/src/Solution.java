class Solution {
    private class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key = key;
        }
    }
    public int pathSum(int[] nums) {
        Node root = construct(nums);
        return path(root, 0);
    }
    private Node construct(int[] nums){
        int n = nums.length;
        if (n == 0) return null;
        Node root = new Node(nums[0]%10);
        for(int i = 1; i < n; i++){
            Node p = root;
            int seq = (nums[i]/10)%10;
            int dep = nums[i]/100;
            for(int j = 1; j < dep-1;){
                if(seq > Math.pow(2,dep-2))
                    p = p.right;
                else p = p.left;
                seq = (seq-1)%((int)(Math.pow(2,dep-2)))+1;
                dep--;
            }
            if(seq == 2)
                p.right = new Node(nums[i]%10);
            else p.left = new Node(nums[i]%10);
        }
        return root;

    }

    private int path(Node x,int sum){
        if (x == null)
            return 0;
        if(x.right == null && x.left == null) {
            sum += x.key;
            return sum;
        }
        int sum1 = path(x.right, sum + x.key);
        int sum2 = path(x.left, sum + x.key);
        return sum1 + sum2;

    }
}