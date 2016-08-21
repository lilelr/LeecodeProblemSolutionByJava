package note.BinaryTree.FlattenBinaryTreetoLinkedList114;

/**
 * Created by yuxiao on 16/4/14.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null)
            root = root.right;

        root.right = temp;
    }


    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        helper(root);
    }

    //definetion: flatten the tree with this root and return the tail of its flattend list
//invariant: tail musn't be null, root musn't be null
    public TreeNode helper(TreeNode root) {
        //at this moment, I can guarantee that root is not null

        //4 cases:
        //1.have both children
        //2.have left child and right child is null
        //3.have right child and left child is null
        //4.have no children
        if (root.left != null && root.right != null) {
            TreeNode tmpRight = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tailOfLeft = helper(root.right);
            tailOfLeft.right = tmpRight;
            return helper(tmpRight);
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            return helper(root.right);
        } else if (root.left == null && root.right != null) {
            return helper(root.right);
        } else {
            return root;
        }
    }

}
