package note.BinaryTree.CountCompleteTreeNodes222;

import org.junit.Test;

/**
 * Created by yuxiao on 8/5/16.
 * https://leetcode.com/problems/count-complete-tree-nodes/
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
    // the index or height 0 of the first level (root) is 0. So the value of (1<<height) is
    // equal to the total number of nodes of this level.
    //
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if(root.left==null) return 1;
        int height = 0;
        int nodesums = 0;
        TreeNode node = root;
        while (node.left != null) {
            nodesums += (1 << height);
            height++;
            node = node.left;
        }
        return nodesums+countLastLevel(root,height);

    }

    public int countLastLevel(TreeNode root, int height) {
        if(height==0 || root.left==null) return 0;
        if (height == 1) {
            if (root.right != null) return 2;
            if (root.left != null) return 1;
        }

        TreeNode node = root.left;
        TreeNode midNode = node.right;
        int curHeight = 2;
        while (curHeight < height) {
            curHeight++;
            midNode = midNode.right;
        }
        if (midNode == null) {
            return countLastLevel(root.left, height - 1);
        }
        return (1 << height - 1) + countLastLevel(root.right, height - 1);


    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(countNodes(root));
    }
}
