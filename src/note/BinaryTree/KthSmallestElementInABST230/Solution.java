package note.BinaryTree.KthSmallestElementInABST230;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yuxiao on 8/5/16.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    //  count the total number of nodes of  left and  right side of the root
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    // inorder traversal  using stack
    public int kthSmallest2(TreeNode root,int k){
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }

        while (k!=0){
            TreeNode n = stack.pop();
            k--;
            if(k==0) return n.val;
            TreeNode right = n.right;
            while (right!=null){
                stack.push(right);
                right = right.left;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
//        root = threadTreeConstruct(root);
//
//        System.out.println(kthSmallest(root, 5));
    }
}
