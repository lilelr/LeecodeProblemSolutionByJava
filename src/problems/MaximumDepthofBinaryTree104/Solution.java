package problems.MaximumDepthofBinaryTree104;

/**
 * Created by yuxiao on 16/4/13.
 */
public class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1+ ((leftHeight>rightHeight)?leftHeight:rightHeight);
    }
}
