package note.tree.BinaryTreeInorderTraversal94;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 8/5/16.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

 //Definition for a binary tree node.
  class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }

    public void inOrder(TreeNode root,List<Integer> res){
        if(root!=null){
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right,res);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(inorderTraversal(root));
    }
}
