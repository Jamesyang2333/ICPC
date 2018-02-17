import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    /*
     * Complete the function below.
     */
    static int sum = 0;
    static int[] heightAndTotalHeight(int[] arr) {
        // Write your code here.
        int len = arr.length;
        TreeNode root = new TreeNode(arr[0], 0, null, null);
        for(int i = 1; i < len; i++){
            insert(root, arr[i]);
        }
        int[] result = new int[2];
        result[0] = getHeight(root);
        getsum(root);
        result[1] = sum;
        return result;
    }
    private static void getsum(TreeNode root){
        sum += (root.height);
        if(root.left != null)
            getsum(root.left);
        if(root.right != null)
            getsum(root.right);
    }
    private static void insert(TreeNode root, int val){
        if(val < root.val){
            if(root.left == null)
                root.left = new TreeNode(val, 0, null, null);
            else insert(root.left, val);
        }
        else if(val > root.val){
            if(root.right == null)
                root.right = new TreeNode(val, 0, null, null);
            else insert(root.right, val);
        }
        else return;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int arrSize = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[arrSize];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrSize; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;

        }

        int[] result = heightAndTotalHeight(arr);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
    public static int getHeight(TreeNode root){
        if(root == null)
            return -1;
        else return root.height;

    }
}
class TreeNode{
    int val;
    int height;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, int height, TreeNode left, TreeNode right){
        this.val = val;
        this.height = height;
        this.left = left;
        this.right = right;
    }
}