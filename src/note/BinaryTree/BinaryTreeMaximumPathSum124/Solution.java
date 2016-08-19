package note.BinaryTree.BinaryTreeMaximumPathSum124;

import org.junit.Test;

/**
 * Created by yuxiao on 6/14/16.
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class Solution {
    //https://leetcode.com/discuss/91471/elegant-java-1ms-dfs-solution-beat-99-8%25-with-explanation
    // custom testcases
//            [1,2,3]
//            [4,3,-7,10,12,8,14,100]
//            [4,3,-7,10,12,8,14]
//            [-7,4,3]
//            [-7,4,3,-100]
//            [7,100,-3]
//            [70,100,-3,13,15]

//    Expected answer
//
//            6
//            125
//            26
//            4
//            4
//            107
//            185


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxSum;

    public int helper(TreeNode root){
        if (root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right ==null){
            // it is a leaf, every time find a leave,update max;
            if(root.val > maxSum) maxSum = root.val;
            return root.val;
        }

        int value = root.val; // this value become a new leaf
        int left = helper(root.left);
        int right = helper(root.right);

        if(left == Integer.MIN_VALUE){ // root.left == null
            if(right > 0) value = right + root.val;
            if(value>maxSum) maxSum = value;
            return value;
        }

        if(right == Integer.MIN_VALUE){ // root.right == null
            if(left > 0) value = left + root.val;
            if(value>maxSum) maxSum = value;
            return value;
        }

        //both left and right exist
        if(left>0) value = left+root.val;
        if(right+root.val > value) value = right+root.val;

        // We should notice that the value of new leaf should be
        // Math.max(ancestor.val + left,ancestor.va+right,ancestor.val).
        // The new leave must contains the ancestor, and it cannot contain both left leaf and right left.
        if(left+right+root.val > maxSum) maxSum = left+right+root.val;
        if(value >maxSum ) maxSum = value;
        return value;
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    @Test
    public void test() {
//        TreeNode root = new TreeNode(7);
//        TreeNode firstNode = new TreeNode(100);
//        TreeNode secNode = new TreeNode(-3);
//        TreeNode root = new TreeNode(-7);
//        TreeNode firstNode = new TreeNode(4);
//        TreeNode secNode = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        TreeNode firstNode = new TreeNode(2);
        TreeNode secNode = new TreeNode(3);
        root.left = firstNode;
        root.right = secNode;
        int maxSum = maxPathSum(root);
        System.out.println(maxSum);
    }
}
