package note.BinaryTree.InvertBinaryTree226;

import org.junit.Test;

/**
 * Created by yuxiao on 8/5/16.
 */


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode invertTree(TreeNode root) {
         invert(root);
        return root;
    }

    public void invert(TreeNode root){
        if(root!=null){
            invert(root.left);
            invert(root.right);
            if(root.left==null && root.right==null) return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(4);
        TreeNode firstLeft = new TreeNode(2);
        TreeNode firstRight = new TreeNode(5);
        TreeNode secLeft = new TreeNode(1);
        TreeNode secRight = new TreeNode(3);

        root.left = firstLeft;
        root.right = firstRight;
        firstLeft.left = secLeft;
        firstLeft.right = secRight;

        root = invertTree(root);
    }
}
