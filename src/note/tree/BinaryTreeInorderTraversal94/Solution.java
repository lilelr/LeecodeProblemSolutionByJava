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

    // recursive space complex O(n) because of recursive stack
    public void inOrder(TreeNode root,List<Integer> res){
        if(root!=null){
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right,res);
        }
    }

    //  Morris traversal algorithm complex O(n) space complex O(l)
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        TreeNode curr = root;
        while (curr!=null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right!=curr){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                }

                else{
                    predecessor.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
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
